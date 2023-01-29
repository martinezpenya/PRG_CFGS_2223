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
package UD06.Ejemplo3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.security.Key;

/**
 *
 * @author David Martínez (wwww.martinezpenya.es|ieseduardoprimo.es)
 */
public class DecipherAESSimple {

    public static void main(String[] args) {
        final int BLOCK_LENGTH = 16; //Expresado en bytes
        final String FILENAME = "ciphered_message.txt";
        final String PASSWORD = "MyNameIsDavidMar";
        File file = new File(FILENAME);
        try (BufferedReader br = new BufferedReader(new FileReader(file));) {
            Key key = AESSimpleManager.getKey(PASSWORD, BLOCK_LENGTH);
            String cipheredText = br.readLine();
            String plainText = AESSimpleManager.decipher(cipheredText, key);
            System.out.println("Deciphered text is: "+ plainText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
