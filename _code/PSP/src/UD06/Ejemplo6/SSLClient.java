/*
 * Copyright (C) 2023 David Martínez (wwww.martinezpenya.es|ieseduardoprimo.es)
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
package UD06.Ejemplo6;

import java.io.PrintStream;
import java.util.Scanner;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/**
 *
 * @author David Martínez (wwww.martinezpenya.es|ieseduardoprimo.es)
 */
public class SSLClient {

    public static void main(String[] argv) throws Exception {
        System.setProperty("javax.net.ssl.trustStore", "ClientTrustStore.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "clientts");
        try {
            SSLSocketFactory sslFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket cliSocket = (SSLSocket) sslFactory.createSocket("localhost", 4043);
            Scanner reader = new Scanner(System.in);
            PrintStream writer = new PrintStream(cliSocket.getOutputStream());
            System.out.println("Send empty line (ENTER) to end:");
            String text = reader.nextLine();
            while (!text.equals("")) {
                writer.println(text);
                writer.flush();
                text = reader.nextLine();
            }
            writer.println("<<END>>");
            writer.flush();
            cliSocket.close();
        } catch (Exception ex) {
            System.out.println("Communication error: " + ex);
        }
    }
}
