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
package UD04.Ejemplo01;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author David Martínez (wwww.martinezpenya.es|www.eduardoprimo.es)
 */
public class RAE {

    public static StringBuilder htmlDownload(String address) throws Exception {
        StringBuilder answer = new StringBuilder();
        URL url = new URL(address);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "text/plain");

        connection.setRequestProperty("charset", "utf-8");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
        int state = connection.getResponseCode();
        Reader streamReader = null;
        if (state == HttpURLConnection.HTTP_OK) {
            streamReader = new InputStreamReader(connection.getInputStream());
            int character;
            while ((character = streamReader.read()) != -1) {
                answer.append((char) character);
            }
        } else {
            throw new Exception("HTTP Error: " + state);
        }
        connection.disconnect();
        return answer;
    }

    public static void writeFile(String strPath, String content) throws IOException {
        Path path = Paths.get(strPath);
        byte[] strToBytes = content.getBytes();
        Files.write(path, strToBytes);
    }

    public static void main(String[] args) {
        try {
            String scheme = "https://";
            String server = "dle.rae.es/";
            String resource = URLEncoder.encode("Tiburón",
                    StandardCharsets.UTF_8.name());
            String address = scheme + server + resource;
            StringBuilder result = htmlDownload(address);
            RAE.writeFile("src/UD04/Ejemplo01/tiburon.html",
                    result.toString());
            System.out.println("Download completed");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}