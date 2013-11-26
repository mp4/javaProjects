/*
 * contains the driver program to test my priority queue
 * by marsh poulson 11/18/2013
 */

package poulproj10;

import java.util.Scanner;

/**
 * contains the driver program to test the priority queue and the helper 
 * functions for getting data from the user
 */
public class Poulproj10 {


    static PriorityQueue<Float> priorityQueue;

    /*
     * greets the user then initializes the keyboard and priority queue
     * afterwards it calls the menu that interacts with the user
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("welcome to the priority queue driver");
        priorityQueue = new PriorityQueue<>();
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
        System.out.println("3) is empty");
        System.out.println("4) exit");
        choice = getValidMenuInt(keyboard);
        System.out.println("");
        
        switch(choice)
        {
            case 1:
                float value = getValidFloat(keyboard, 
                        "please enter the value:");
                int priority = getValidInt(keyboard, 
                        "please enter its priority:");
                priorityQueue.Add(value, priority);
                menu(keyboard);
                break;
            case 2:
                try
                {
                    System.out.println(priorityQueue.Remove());
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
                menu(keyboard);
                break;
            case 3:
                System.out.println(priorityQueue.isEmpty());
                menu(keyboard);
                break;
            case 4:
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
            return getValidMenuInt(keyboard);
        }
    }
    /*
     * this function will prompt the user to enter a valid int
     * and will return this value will reprompt as many times as necessary
     * the parameter is an initialized instance of a scanner and the message
     * that will be displayed
     */
    public static int getValidInt(Scanner keyboard, String message)
    {
        try
        {
            int value;
            System.out.println(message);
            value = keyboard.nextInt();
            keyboard.nextLine();//purges \n from the stream
            return value;
        }
        catch(Exception e)
        {
            return getValidInt(keyboard, message);
        }
    }
    /*
     * this function will prompt the user to enter a valid float
     * and will return this value will reprompt as many times as necessary
     * the parameter is an initialized instance of a scanner and the message 
     * that will be displayed
     */
    public static float getValidFloat(Scanner keyboard, String message)
    {
        try
        {
            float value;
            System.out.println(message);
            value = keyboard.nextFloat();
            keyboard.nextLine();//purges \n from the stream
            return value;
        }
        catch(Exception e)
        {
            return getValidFloat(keyboard, message);
        }
    }
}
