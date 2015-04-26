/**
 * main Main-Package in der sich der Programmeinstieg befindet.
 */
package main;

import userInterface.UserInterface;

/**
 * @version 0.3
 * @author Malte
 */
public class PersonManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        UserInterface uiManager = new UserInterface();
        uiManager.start();
    }
}
