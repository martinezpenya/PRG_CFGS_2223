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
package UD05.ValidacionEntradas;

import java.util.Scanner;
import java.util.regex.*;

/**
 *
 * @author David Martínez (wwww.martinezpenya.es|ieseduardoprimo.es)
 */
public class Validacion {

    public static void main(String[] args) {
        Scanner teclado = new Scanner (System.in);

        Pattern pat = null;
        Matcher mat = null;

        pat=Pattern.compile("[0-9]{8}-[a-zA-Z]");
        System.out.print("Introduce un DNI con formato 00000000-X: ");
        mat=pat.matcher(teclado.nextLine());
        
        if (mat.find()){
            System.out.println("El DNI cumple el formato");
        } else {
            System.out.println("El DNI NO cumple el formato");
        }
        
        //Otros patterns de ejemplo:
        //pat=Pattern.compile("Almería","Granada","Jaén","Málaga","Sevilla","Cádiz","Córdoba","Huelva");
        //pat=Pattern.compile("Verdadero","Falso","V","F","True","False","Córdoba","Huelva");
    }
}
