/**
 * main Main-Package in der sich der Programmeinstieg befindet.
 */
package main;

import userInterface.UserInterface;

/**
 * Beschreibung:
 * Main-Klasse - Einstiegspunkt in das Programm.
 *
 * @author Malte Dammann
 * E-Mail: s0549309@htw-berlin.de
 * Bearbeitungszeitraum: 22.04.15 - 28.04.2015
 *
 * Modul: Programmierung 2
 * 
 * Dateiname: Engine.java
 * IDE: NetBeans IDE 8.0.2
 * Java: 1.8.0_20; Java HotSpot(TM) 64-Bit
 *
 * @since 2015-04-22
 * @version 0.3
 *
 */
public class PersonManager {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {

        UserInterface uiManager = new UserInterface();
        uiManager.start();
    }
}
