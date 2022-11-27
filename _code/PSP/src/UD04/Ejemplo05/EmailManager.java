/*
 * Copyright (C) 2022 David Martínez (wwww.martinezpenya.es|www.eduardoprimo.es)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package UD04.Ejemplo05;

import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author David Martínez (wwww.martinezpenya.es|www.eduardoprimo.es)
 */
public class EmailManager {

    private Properties properties;
    private Session session;

    private void setSMTPServerProperties() {
        properties = System.getProperties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", 587);
        properties.put("mail.smtp.starttls.enable", "true");
        session = Session.getInstance(properties, null);
    }

    private Transport connectSMTPServer(String emailAddress, String password) throws NoSuchProviderException, MessagingException {
        Transport t = (Transport) session.getTransport("smtp");
        t.connect(properties.getProperty("mail.smtp.host"), emailAddress,
                password);
        return t;
    }

    private Message createMessageCore(String from, String to, String subject) throws AddressException, MessagingException {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject(subject);
        return message;
    }

    private Message createTextMessage(String from, String to, String subject,
            String messageText) throws MessagingException, AddressException, IOException {
        Message message = createMessageCore(from, to, subject);
        message.setText(messageText);
        return message;
    }

    public void sendTextMessage(String from, String to, String subject,
            String messageText, String user, String password) throws AddressException, MessagingException, IOException {
        setSMTPServerProperties();
        Message message = createTextMessage(from, to, subject, messageText);
        Transport t = connectSMTPServer(user, password);
        t.sendMessage(message, message.getAllRecipients());
        t.close();
    }

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Introduce email to:");
            String emailTo = sc.nextLine();
            System.out.print("Introduce email from:");
            String emailFrom = sc.nextLine();
            System.out.print("Introduce password:");
            String passwordFrom = sc.nextLine();
            sc.close();
            EmailManager emailManager = new EmailManager();
            emailManager.sendTextMessage(emailFrom, emailTo,
                    "Sample text email without attachment",
                    "Test Message from Java.",
                    emailFrom, passwordFrom);
            System.out.println("Email sent.");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
