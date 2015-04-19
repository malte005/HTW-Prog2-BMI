package bmi;

import java.util.Scanner;

/**
 * @version 0.1
 * @author Malte
 */
public class Eingabe {
    static Scanner scanner;
    
    public static void init(){
         scanner = new Scanner(System.in);
        
    }
    
    public static Person liesPersonen(){
        
         System.out.println("Namen eingaben:");
         String name = scanner.nextLine();
         
         System.out.println("Geschlecht eingaben (Mann = true, Frau = false):");
         boolean mann = scanner.nextBoolean();
         
         System.out.println("Größe eingaben:");
         int groesse = scanner.nextInt();
         
         System.out.println("Gewicht eingaben:");
         float gewicht = scanner.nextFloat();
         
         Person pTemp = new Person(name, groesse, gewicht);
         
         return pTemp;
    }
    
    public static boolean liesAuswahl(){
        
        return true;
         
    }
}
