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
package UD04.Ejemplo07.server;

import UD04.Ejemplo07.interfaces.CalculatorInterface;
import java.rmi.RemoteException;

/**
 *
 * @author David Martínez (wwww.martinezpenya.es|www.eduardoprimo.es)
 */
public class Server implements CalculatorInterface {

    @Override
    public int add(int o1, int o2) throws RemoteException {
        return o1 + o2;
    }

    @Override
    public int substract(int o1, int o2) throws RemoteException {
        return o1 - o2;
    }

    @Override
    public int multiply(int o1, int o2) throws RemoteException {
        return o1 * o2;
    }

    @Override
    public int divide(int o1, int o2) throws RemoteException {
        return o1 / o2;
    }
}
