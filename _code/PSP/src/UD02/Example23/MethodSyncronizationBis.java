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
package UD02.Example23;

/**
 *
 * @author David Martínez (wwww.martinezpenya.es|www.ieseduardoprimo.es)
 */
public class MethodSyncronizationBis implements Runnable {

    public void method1() {
        System.out.println("Method 1 start");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {
            return;
        }
        System.out.println("Method 1 ends");
    }

    public void method2() {
        System.out.println("Method 2 start");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {
            return;
        }
        System.out.println("Method 2 ends");
    }

    @Override
    public void run() {
        method1();
        method2();
    }

    public static void main(String[] args) {
        MethodSyncronizationBis ms = new MethodSyncronizationBis();
        new Thread(ms).start();
        new Thread(ms).start();
        new Thread(ms).start();
        new Thread(ms).start();
        new Thread(ms).start();
    }
}
