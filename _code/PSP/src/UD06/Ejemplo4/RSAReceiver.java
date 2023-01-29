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
package UD06.Ejemplo4;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.Cipher;

/**
 *
 * @author David Martínez (wwww.martinezpenya.es|ieseduardoprimo.es)
 */
public class RSAReceiver {

    private final static String DATOS = "Secret access code is 2294";

    private static byte[] decipher(byte[] cipheredMessage, Key key) throws Exception {
        Cipher decipherer = Cipher.getInstance("RSA");
        decipherer.init(Cipher.DECRYPT_MODE, key);
        byte[] decipheredMessage = decipherer.doFinal(cipheredMessage);
        return decipheredMessage;
    }

    public static void main(String[] args) {
        PublicKey publicKey;
        File file = new File("ciphereddata.rsa");
        try {
            publicKey = KeysManager.getClavePublica();
            byte[] cipheredMessage = Files.readAllBytes(file.toPath());
            byte[] decipheredMessage = decipher(cipheredMessage, publicKey);
            System.out.println(new String(decipheredMessage, StandardCharsets.UTF_8));
            Files.write(file.toPath(), cipheredMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
