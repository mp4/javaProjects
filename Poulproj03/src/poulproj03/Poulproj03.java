/*
 * this is the driver program to demonstrate my calender class and allow the
 * user to test it by allowing them to input values
 * by marsh poulson 9/12/2013
 */
package poulproj03;

import java.util.Scanner;

public class Poulproj03 {

    /**
     * prints a greeting initializes a Scanner to the keyboard and calls the 
     * menu
     */
    public static void main(String[] args) {
        System.out.println("welcome to the calender driver program");
        Scanner keyboard = new Scanner(System.in);
        menu(keyboard);
    }
    public static Calender calender;
    /*
     * this function accepts a scanner which should already be directed to the 
     * standard input device it will output a menu and then call the 
     * appropraiate functions including itself
     */
    public static void menu(Scanner keyboard)
    {
        int choice;
        System.out.println("\nmenu");
        System.out.println("1) create new Calender");
        System.out.println("2) advance Calender by one day");
        System.out.println("3) print current Calender date MM/DD/YYYY");
        System.out.println("4) print current Calender date with month as text");
        System.out.println("5) exit");
        choice = getValidMenuInt(keyboard);
        System.out.println("");
        
        switch(choice)
        {
            case 1:
                try
                {
                    calender = getCalender(keyboard);
                    System.out.println("calender created");
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
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
     * calls the functions in the right order to be able to properly initialize 
     * a calender instance and returns a reference to this instance the  
     * parameter is an initialized Scanner instance
     */
    public static Calender getCalender(Scanner keyboard)
    {
        int month, day, year;
        month = getMonth(keyboard);
        year = getYear(keyboard);
        day = getDay(keyboard, month, year);
        return new Calender(day, month , year);
    }
    /*
     * prompts the user to enter a valid month and returns this value the 
     * parameter is an initialized Scanner instance
     */
    private static int getMonth(Scanner keyboard)
    {
        try
        {
            int value;
            System.out.println("please enter a month:");
            value = keyboard.nextInt();
            if(value < 0 || value > 12)
            {
                System.out.println("please enter an interger 1-12");
                return getMonth(keyboard);
            }
            //else
            //base case
            return value;
        }
        catch(Exception e)
        {
            return getMonth(keyboard);
        }
    }
    /*
     * prompts the user to enter a valid day based on the month and year
     * and returns this value
     */
    private static int getDay(Scanner keyboard, int month, int year)
    {
        try
        {
            int value;
            System.out.println("please enter a day:");
            value = keyboard.nextInt();
            if(value < 0 || value > Calender.numberOfDays(month, year))
            {
                System.out.println("please enter a valid number of days");
                return getMonth(keyboard);
            }
            //else
            //base case
            return value;
        }
        catch(Exception e)
        {
            return getMonth(keyboard);
        }
    }
    /*
     * returns a valid value for a year to be used with the calender class
     * will prompt the user to enter a year the parameter is an initialized 
     * Scanner instance
     */
    private static int getYear(Scanner keyboard)
    {
        try
        {
            int value;
            System.out.println("please enter the year:");
            value = keyboard.nextInt();
            return value;
        }
        catch(Exception e)
        {
            System.out.println("please enter a number");
            return getYear(keyboard);
        }
    }
}
