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
package UD03.Ejemplo02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author David Martínez (wwww.martinezpenya.es|www.eduardoprimo.es)
 */
public class SocketUDPClient {

    public static void main(String[] args) {
        String strMessage = "Message sent from the client";
        DatagramSocket socketUDP;
        try {
            System.out.println("(Client): Stablishing connection parameters");
            InetAddress serverHost = InetAddress.getByName("localhost");
            int serverPort = 49171;
            System.out.println("(Client): Creating socket...");
            socketUDP = new DatagramSocket();
            System.out.println("(Client): Sending datagram...");
            byte[] message = strMessage.getBytes();
            DatagramPacket peticion = new DatagramPacket(message,
                    message.length, serverHost, serverPort);
            socketUDP.send(peticion);
            System.out.println("(Client): Receiving datagram...");
            byte[] buffer = new byte[64];
            DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length,
                    serverHost, serverPort);
            socketUDP.receive(respuesta);
            System.out.println("(Client): Message received: " + new String(
                    buffer));
            System.out.println("(Client): Closing socket...");
            socketUDP.close();
            System.out.println("(Client): Socket closed.");
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
