/*
 * this file contains the driver program for the queue class
 * by marsh poulson 10/22/2013
 */
package poulproj07;

import java.util.Scanner;

/*
 * the main class designed to hold the driver program, main, the menu and the 
 * funticions that the menu needs to verify user input
 */
public class Poulproj07 {

    static Queue<String> queue;
    /**
     * outputs a greeting to the user initializes a queue and Scanner to the
     * keyboard and then calls the menu
     */
    public static void main(String[] args)
    {
        System.out.println("welcome to the queue driver program");
        Scanner keyboard = new Scanner(System.in);
        queue = new Queue<>();
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
        System.out.println("1) enqueue");
        System.out.println("2) peek");
        System.out.println("3) dequeue");
        System.out.println("4) is empty");
        System.out.println("5) exit");
        choice = getValidMenuInt(keyboard);
        System.out.println("");
        
        switch(choice)
        {
            case 1:
                System.out.println("please enter a string");
                keyboard.reset();
                String temp = keyboard.nextLine();
                queue.enqueue(temp);
                menu(keyboard);
                break;
            case 2:
                try
                {
                    System.out.println(queue.peek());
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
                menu(keyboard);
                break;
            case 3:
                try
                {
                    System.out.println(queue.dequeue());
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
                menu(keyboard);
                break;
            case 4:
                System.out.println(queue.isEmpty());
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
}
