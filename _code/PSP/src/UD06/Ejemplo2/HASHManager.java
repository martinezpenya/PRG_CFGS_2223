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
package UD06.Ejemplo2;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author David Martínez (wwww.martinezpenya.es|ieseduardoprimo.es)
 */
public class HASHManager {

    private static final String ALGORITHM = "SHA-256";

    public static byte[] getDigest(byte[] message) throws NoSuchAlgorithmException {
        byte[] hash = null;
        try {
            MessageDigest algorithm = MessageDigest.getInstance(ALGORITHM);
            algorithm.reset();
            algorithm.update(message);
            hash = algorithm.digest();
        } catch (NoSuchAlgorithmException e) {
            throw e;
        }
        return hash;
    }

    public static boolean compareHash(byte[] hash1, byte[] hash2) throws NoSuchAlgorithmException {
        boolean equals;
        try {
            MessageDigest algorithm = MessageDigest.getInstance(ALGORITHM);
            algorithm.reset();
            equals = algorithm.isEqual(hash1, hash2);
        } catch (NoSuchAlgorithmException e) {
            throw e;
        }
        return equals;
    }
}
