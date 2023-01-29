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
package UD06.Ejemplo1;

/**
 *
 * @author David Martínez (wwww.martinezpenya.es|ieseduardoprimo.es)
 */
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Provider.Service;
import java.security.Security;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Hash {

    public static void todosMetodos(String message) throws NoSuchAlgorithmException {
        System.out.format("ORIGINAL: %s%n", message);
        final String TIPO_MESSAGE_DIGEST = MessageDigest.class.getSimpleName();
        //Get the list of providers
        Provider[] proveedores = Security.getProviders();
        for (Provider proveedor : proveedores) {
            //For each provider, get services
            Set<Service> servicios = proveedor.getServices();
            for (Service servicio : servicios) {
                //and filter them by type
                if (servicio.getType().equals(TIPO_MESSAGE_DIGEST)) {
                    String hashName = servicio.getAlgorithm();
                    MessageDigest algorithm = MessageDigest.getInstance(hashName);
                    algorithm.reset();
                    algorithm.update(message.getBytes(StandardCharsets.UTF_8));
                    String hash = String.format("%064x", new BigInteger(1, algorithm.digest()));
                    System.out.format("%s: t%s%n", hashName, hash);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        System.out.print("Introduce una cadena de texto sobre la que calcular el Hash: ");
        try {
            todosMetodos(input.nextLine());
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Hash.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}