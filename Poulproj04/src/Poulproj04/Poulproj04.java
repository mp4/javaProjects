/**
 * contains the driver program to test the polynomial class
 * @author marsh poulson 9/19/2013
 */
package Poulproj04;

import java.util.Scanner;

public class Poulproj04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        polynomial = new Polynomial();
        System.out.println("welcome to the polynomial driver program");
        Scanner keyboard = new Scanner(System.in);
        menu(keyboard);
    }
    
    static Polynomial polynomial;
    
    /*
     * this function accepts a scanner which should already be directed to the 
     * standard input device it will output a menu and then call the 
     * appropraiate functions including itself
     */
    public static void menu(Scanner keyboard)
    {
        int choice;
        System.out.println("\nmenu");
        System.out.println("1) clear polynomial");
        System.out.println("2) advance Calender by one day");
        System.out.println("3) print current Calender date MM/DD/YYYY");
        System.out.println("4) print current Calender date with month as text");
        System.out.println("5) exit");
        choice = getValidMenuInt(keyboard);
        System.out.println("");
        
        switch(choice)
        {
            case 1:
                polynomial = new Polynomial();
                menu(keyboard);
                break;
            case 2:
                try
                {
                    calender.advanceByOneDay();
                    System.out.println("calender advanced");
                }
                catch(Exception e)
                {
                    System.out.println("try creating a calender before using " +
                            "this function");
                }
                menu(keyboard);
                break;
            case 3:
                try
                {
                    System.out.println(calender.toStringNumeralsAndSlashes());
                }
                catch(Exception e)
                {
                    System.out.println("try creating a calender before using " +
                            "this function");
                }
                menu(keyboard);
                break;
            case 4:
                try
                {
                    System.out.println(calender.toStringMDYText());
                }
                catch(Exception e)
                {
                    System.out.println("try creating a calender before using " +
                            "this function");
                }
                menu(keyboard);
                break;
            case 5:
                //fallout of the menu
                break;
        } 
    }
    final static int MINMENUCHOICE = 1;
    final static int MAXMENUCHOICE = 5;
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
    /*
     * gets an integer from the user and returns it it prompts the user 
     * with the message keyboard must be an initialized scanner instance
     */
    public static int getInt(String message, Scanner keyboard)
    {
        try
        {
            int value;
            System.out.println(message);
            value = keyboard.nextInt();
            
            return value;
        }
        catch(Exception e)
        {
            return getInt(message, keyboard);
        }
    }
}
