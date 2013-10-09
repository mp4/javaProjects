/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poulproj06;

import java.util.Scanner;

/**
 *
 * @author marsh
 */
public class Poulproj06 {
    static FlightMap flightMap;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        flightMap = new FlightMap();
        System.out.println("welcome to the Flightmap program");
        Scanner scanner = new Scanner(System.in);
        menu(scanner);
    }
    
    public static void menu(Scanner keyboard)
    {
        int choice;
        System.out.println("\nmenu");
        System.out.println("1) load Flightmap from file");
        System.out.println("2) display all cities");
        System.out.println("3) display adjacent cities");
        System.out.println("4) mark visited city");
        System.out.println("5) unvisit all cities");
        System.out.println("6) swap active and inactive polynomials");
        System.out.println("7) adds active and inactive polynomials");
        System.out.println("8) exit");
        choice = getValidMenuInt(keyboard);
        System.out.println("");
        
        switch(choice)
        {
            case 1:
                menu(keyboard);
                break;
            case 2:

                menu(keyboard);
                break;
            case 3:

                menu(keyboard);
                break;
            case 4:

                menu(keyboard);
                break;
            case 5:

                menu(keyboard);
                break;
            case 6:

                menu(keyboard);
                break;
            case 7:
                
                menu(keyboard);
                break;
            case 8:
                break;
        } 
    }
    final static int MINMENUCHOICE = 1;
    final static int MAXMENUCHOICE = 8;
    
    /*
     * this function will prompt the user to enter a valid menu integer
     * and will return this value will reprompt as many times as necessary
     * the parameter is an initialized instance of a scanner
     */
    public static int getValidMenuInt(Scanner keyboard)
    {
        try
        {
            int value;
            System.out.println("please enter your choice:");
            value = keyboard.nextInt();
            if((value > MAXMENUCHOICE) || (value < MINMENUCHOICE))
            {
                return getValidMenuInt(keyboard);
            }
            //else
            //base case
            return value;
        }
        catch(Exception e)
        {
            return getValidMenuInt(keyboard);
        }
    }
}
