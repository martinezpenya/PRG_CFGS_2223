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
package UD02.producer_consumer_v5;

/**
 *
 * @author David Martínez (wwww.martinezpenya.es|www.ieseduardoprimo.es)
 */
public class Test {

    public static void main(String[] args) {
        SharedData sd = new SharedData();
        Producer p = new Producer(sd);
        Consumer c1 = new Consumer(sd, 1);
        Consumer c2 = new Consumer(sd, 2);
        new Thread(p).start();
        new Thread(c1).start();
        new Thread(c2).start();
    }

}
