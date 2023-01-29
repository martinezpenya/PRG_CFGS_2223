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
package UD01;

import java.io.IOException;

/**
 *
 * @author David Martínez (wwww.martinezpenya.es|ieseduardoprimo.es)
 */
public class Ejemplo02 {

    public static void main(String[] args) {
        
        try {
            
            Runtime.getRuntime().exec("kwrite notes.txt"); //kubuntu
            //Runtime.getRuntime().exec("notepad.exe notes.txt"); //windows
            
            String[] procesInfo = {"kwrite","notes.txt"};//kubuntu
            //String[] procesInfo = {"Notepad.exe","notes.txt"};//windows
            Process p = Runtime.getRuntime().exec(procesInfo);
            int returnCode = p.waitFor();
            System.out.println("Fin de la ejecución:" + returnCode);
            
            ProcessBuilder pBuilder = new ProcessBuilder("kwrite");//kubuntu
            //ProcessBuilder pBuilder = new ProcessBuilder("Notepad.exe");//windows
            for (int i=0; i<10;i++){
                pBuilder.start();
                Thread.sleep(1000); //Espera 1000 milisegundos (1 segundo)
            }
            
            //shows the number of cores
            int processors = Runtime.getRuntime().availableProcessors();
            System.out.println("CPU cores: " + processors);
            
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}