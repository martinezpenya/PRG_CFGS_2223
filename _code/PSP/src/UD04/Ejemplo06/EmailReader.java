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
package UD04.Ejemplo06;

import com.sun.mail.imap.IMAPFolder;
import java.util.Properties;
import java.util.Scanner;
import javax.mail.*;
import javax.mail.Message.*;
import javax.mail.internet.*;

/**
 *
 * @author David Martínez (wwww.martinezpenya.es|www.eduardoprimo.es)
 */
public class EmailReader {

    private Session getSesionImap() {
        Properties properties = new Properties();
        properties.setProperty("mail.store.protocol", "imap");
        properties.setProperty("mail.imap.host", "imap.gmail.com");
        properties.setProperty("mail.imap.port", "993");
        properties.setProperty("mail.imap.ssl.enable", "true");
        properties.setProperty("mail.imap.ssl.trust", "imap.gmail.com");
        Session session = Session.getDefaultInstance(properties);
        return session;
    }

    public void readINBOX(String email, String password) throws Exception {
        Session session = this.getSesionImap();
        Store storage = session.getStore("imaps");
        storage.connect("imap.gmail.com", 993, email, password);
        IMAPFolder inbox = (IMAPFolder) storage.getFolder("INBOX");
        inbox.open(Folder.READ_WRITE);
        Message[] messages = inbox.getMessages();
        for (Message message : messages) {
            Address[] fromAddress = message.getFrom();
            String from = fromAddress[0].toString();
            Address[] toAddress = message.getRecipients(RecipientType.TO);
            String to = toAddress[0].toString();
            String subject = message.getSubject();
            MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
            if (mimeMultipart.getBodyPart(0).isMimeType("text/plain")) {
                String textoMensaje = (String) mimeMultipart.getBodyPart(0).getContent();
                System.out.printf("From %s To %s Subject: %s Message: %s\n", from,
                        to, subject, textoMensaje);
            } else {
                System.out.printf("From %s To %s Subject: %s Message: %s\n", from,
                        to, subject, "[*ATTACHED FILES*]");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce your gmail address:");
        String email = sc.nextLine();
        System.out.print("Introduce your password:");
        String password = sc.nextLine();
        sc.close();
        try {
            new EmailReader().readINBOX(email, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
