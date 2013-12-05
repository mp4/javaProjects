/*
 * contains the driver program to demonstrate the symbol table 
 * by marsh poulson 12/04/2013
 */

package poulproj11;

import java.util.Scanner;

/**
 * contains the driver program to test my symbol table program and helper
 * programs
 */
public class Poulproj11 {

    static SymbolTable table;
    /**
     * initializes the table outputs a greeting to the user and then calls the
     * menu
     */
    public static void main(String[] args) {
        table = new SymbolTable();
        Scanner keyboard = new Scanner(System.in);
        menu(keyboard);
    }
        /*
     * this function accepts a scanner which should already be directed to the 
     * standard input device it will output a menu and then call the 
     * appropraiate functions including itself
     */
    public static void menu(Scanner keyboard)
    {
        int choice;
        System.out.println("\nmenu");
        System.out.println("1) add");
        System.out.println("2) remove");
        System.out.println("3) print all");
        System.out.println("4) exit");
        choice = getValidMenuInt(keyboard);
        System.out.println("");
        
        switch(choice)
        {
            case 1:
                try
                {
                    table.Add(getValidJavaID(keyboard));
                }
                catch(IllegalAccessException e)
                {
                    System.out.println(e);
                }
                menu(keyboard);
                break;
            case 2:
                try
                {
                    table.deleteSymbol(getValidJavaID(keyboard));
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
                menu(keyboard);
                break;
            case 3:
                
                table.outputAllSymbols();
                menu(keyboard);
                break;
            case 4:
                //fallout of the menu
                break;
        } 
    }
    final static int MINMENUCHOICE = 1;
    final static int MAXMENUCHOICE = 4;
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
            keyboard.nextLine();//purges \n from the stream
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
            keyboard.nextLine();
            return getValidMenuInt(keyboard);
        }
    }
    /*
     * this function will prompt the user to enter a valid java identifier
     * and will return this value will reprompt as many times as necessary
     * the parameter is an initialized instance of a scanner
     */
    public static String getValidJavaID(Scanner keyboard)
    {
        String value;
        System.out.println("please enter a java identifier:");
        value = keyboard.nextLine();
        if(SymbolTable.validJavaIdentifier(value))
            return value;
        else
            return getValidJavaID(keyboard);
    }    
}
