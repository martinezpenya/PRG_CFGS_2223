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
package UD02.producer_consumer_v4;

/**
 *
 * @author David Martínez (wwww.martinezpenya.es|www.ieseduardoprimo.es)
 */
public class SharedData {

    int data;
    boolean available = false;

    public synchronized int get() {
        if (!available) {
            try {
                wait();
            } catch (Exception e) {
            }
        }
        available = false;
        notify();
        return data;

    }

    public synchronized void put(int newData) {
        if (available) {
            try {
                wait();
            } catch (Exception e) {
            }
        }
        data = newData;
        available = true;
        notify();
    }
}
