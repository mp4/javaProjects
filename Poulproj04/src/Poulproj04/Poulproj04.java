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
        polynomial2 = new Polynomial();
        System.out.println("welcome to the polynomial driver program");
        Scanner keyboard = new Scanner(System.in);
        menu(keyboard);
    }
    
    static Polynomial polynomial;
    static Polynomial polynomial2;
    
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
        System.out.println("2) get coefficient");
        System.out.println("3) set coefficient");
        System.out.println("4) print polynomial");
        System.out.println("5) evalutate polynomial");
        System.out.println("6) swap active polynomials");
        System.out.println("7) add polynomials active and inactive together");
        System.out.println("8) exit");
        choice = getValidMenuInt(keyboard);
        System.out.println("");
        
        switch(choice)
        {
            case 1:
                polynomial = new Polynomial();
                menu(keyboard);
                break;
            case 2:
                 System.out.println("coefficient is: " +
                        polynomial.getCoefficient(getInt(
                        "please enter the power you want to display",
                        keyboard)));
                menu(keyboard);
                break;
            case 3:
               polynomial.setCoefficient(getInt("please enter the coefficient",
                       keyboard), getInt("please enter the power", keyboard));
                menu(keyboard);
                break;
            case 4:
                System.out.println("p(x) = " + polynomial.toString());
                menu(keyboard);
                break;
            case 5:
                double evalAt = getDouble("please enter the value of x:",
                        keyboard);
                System.out.println("p(" + evalAt + ") = " + polynomial.evalute(evalAt));
                menu(keyboard);
                break;
            case 6:
                Polynomial temp = polynomial;
                polynomial = polynomial2;
                polynomial2 = temp;
                menu(keyboard);
                break;
            case 7:
                polynomial = polynomial.add(polynomial2);
                polynomial2 = new Polynomial();
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
    /*
     * gets an integer from the user and returns it it prompts the user 
     * with the message keyboard must be an initialized scanner instance
     */
    public static double getDouble(String message, Scanner keyboard)
    {
        try
        {
            double value;
            System.out.println(message);
            value = keyboard.nextDouble();
            
            return value;
        }
        catch(Exception e)
        {
            return getDouble(message, keyboard);
        }
    }
}
