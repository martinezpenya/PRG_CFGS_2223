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
package UD03.Ejemplo03;

import java.util.concurrent.TimeUnit;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Random;

/**
 *
 * @author David Martínez (wwww.martinezpenya.es|www.eduardoprimo.es)
 */
public class ProcessManager extends Thread {

    private Socket socket;
    private OutputStream os;

    public ProcessManager(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            doProcess();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void doProcess() throws IOException {
        os = this.socket.getOutputStream();
        Random randomNumberGenerator = new Random();
        int waitTime = randomNumberGenerator.nextInt(60);
        try {
            TimeUnit.SECONDS.sleep(waitTime);
            os.write(waitTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            os.close();
        }
    }
}
