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
import java.net.SocketException;

/**
 *
 * @author David Martínez (wwww.martinezpenya.es|www.eduardoprimo.es)
 */
public class SocketUDPServer {

    public static void main(String[] args) {
        DatagramSocket socket;
        try {
            System.out.println("(Server): Creating socket...");
            socket = new DatagramSocket(49171);
            System.out.println("(Server): Receiving datagram...");
            byte[] readBuffer = new byte[64];
            DatagramPacket inputDatagram = new DatagramPacket(readBuffer,
                    readBuffer.length);
            socket.receive(inputDatagram);
            System.out.println("(Server): Message received: " + new String(
                    readBuffer));
            System.out.println("(Server): Sending datagram...");
            byte[] sentMessage = "Message sent from the server".getBytes();
            DatagramPacket outputDatagram = new DatagramPacket(sentMessage,
                    sentMessage.length, inputDatagram.getAddress(),
                    inputDatagram.getPort());
            socket.send(outputDatagram);
            System.out.println("(Server): Closing socket...");
            socket.close();
            System.out.println("(Server): Socket closed.");
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
