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

import java.io.PrintWriter;
import java.security.Key;

/**
 *
 * @author David Martínez (wwww.martinezpenya.es|ieseduardoprimo.es)
 */
public class CipherAESSimple {

    public static void main(String[] args) {
        final int BLOCK_LENGTH = 16;//Expressed in bytes
        final String FILE_NAME = "ciphered_message.txt";
        final String PASSWORD = "MyNameIsDavidMar"; //AES only supports 16, 24 o 32 length keys.
        final String PLAIN_TEXT = "The secret number is 54321";
        try (PrintWriter pw = new PrintWriter(FILE_NAME);){
            Key key = AESSimpleManager.getKey(PASSWORD, BLOCK_LENGTH);
            String clearText = PLAIN_TEXT;
            String cipheredText = AESSimpleManager.cipher(clearText, key);
            pw.write(cipheredText);
            System.out.println("The message is ciphered correctly");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
