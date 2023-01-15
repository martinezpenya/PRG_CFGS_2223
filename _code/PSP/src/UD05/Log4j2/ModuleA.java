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
package UD05.Log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ModuleA {

    private static final Logger logger = LogManager.getLogger();

    // Log messages
    public static void main(String[] args) {
        logger.debug("It is a debug logger.");
        logger.error("It is an error logger.");
        logger.fatal("It is a fatal logger.");
        logger.info("It is a info logger.");
        logger.trace("It is a trace logger.");
        logger.warn("It is a warn logger.");
    }
}
