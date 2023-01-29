/*
 * Copyright (C) 2023 David Martínez (wwww.martinezpenya.es|www.ieseduardoprimo.es)
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

import java.io.File;
import java.nio.file.Files;
import java.util.Scanner;

/**
 *
 * @author David Martínez (wwww.martinezpenya.es|www.ieseduardoprimo.es)
 */
public class CredentialsRegister {

    private static final String ENCODING_TYPE = "UTF-8";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce your identifier (email): ");
        String identifier = sc.nextLine();
        System.out.print("Introduce your password: ");
        String password = sc.nextLine();
        try {
            byte[] hash = HASHManager.getDigest(password.getBytes(ENCODING_TYPE));
            Files.write(new File(identifier + ".credential").toPath(), hash);
        } catch (Exception e) {
            e.printStackTrace();
        }
        sc.close();
    }

}
