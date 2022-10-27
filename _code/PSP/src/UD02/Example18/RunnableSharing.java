/*
 * Copyright (C) 2022 David Martínez (wwww.martinezpenya.es|www.ieseduardoprimo.es)
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
package UD02.Example18;

/**
 *
 * @author David Martínez (wwww.martinezpenya.es|www.ieseduardoprimo.es)
 */
public class RunnableSharing extends Thread {

    private int counter;

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter++;           
        }
        System.out.println("Counter: " + counter);
    }

    public static void main(String[] args) throws InterruptedException {
        RunnableSharing rs = new RunnableSharing();
        for (int i = 0; i < 1000; i++) {
            new Thread(rs).start();
        }
    }
}
