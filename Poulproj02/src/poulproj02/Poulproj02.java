/*
 * this is a menu driven program to test the methods c and rabbit
 * by marsh poulson 9/04/2013
 */
package poulproj02;
import java.util.Scanner;
/**
 *
 * @author marsh poulson 9/02/2013
 */
public class Poulproj02 {

    /**
     * prints a greeting initializes a scanner and calls the menu
     */
    public static void main(String[] args) 
    {    
        System.out.println("welcome to the recurion testing program");
        Scanner keyboard = new Scanner(System.in);
        menu(keyboard);
    }
    
    private static int stackedRabbitCalls = 0;
    /*
     * this is the spock problem which outputs each equation at each recursive
     * call returns the number of ways to order a collection of n items in 
     * groups of size k
     */
    public static int c(int n, int k)
    {
        System.out.print("c(" + n +", " + k + ") = ");
        if((k == 0) || (k == n))
        {
            System.out.println("1");
            return 1;
        }
        else if(k > n)
        {
            System.out.println("0");
            return 0;
        }
        else
        {
            System.out.println("c(" + (n-1) + ", " + (k-1) + ") + c(" + (n-1) +
                    ", " + k + ");");
            return c(n-1, k-1) + c(n-1, k);
        }
    }
    /*
     * outputs to the user the begin and end of each recursive call for the 
     * factorial funtion n is the n from n!
     */
    public static int rabbit(int n)
    {
        int temp;
        
        for(int i=0; i< stackedRabbitCalls; i++)
        {
            System.out.print("\t");
        }
        
        System.out.println("Entering rabbit: n = " + n);
        stackedRabbitCalls++;
        if( n <= 2)
        {
            stackedRabbitCalls--;
            
            for(int i=0; i< stackedRabbitCalls; i++)
            {
                System.out.print("\t");
            }
        
            System.out.println("Leave rabbit: n = "+ n + "\tvalue = 1");
            return 1;
        }
        temp = rabbit(n-1) + rabbit(n-2);
        stackedRabbitCalls--;
        for(int i=0; i< stackedRabbitCalls; i++)
            {
                System.out.print("\t");
            }
        System.out.println("Leave rabbit: n = "+n + "\tvalue = " + temp);
        return temp;
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
        System.out.println("1) c (spock dilema)");
        System.out.println("2) rabbit (factorial)");
        System.out.println("3) exit");
        choice = getValidMenuInt(keyboard);
        System.out.println("");
        
        switch(choice)
        {
            case 1:
                c(getPositiveInt("please enter a value for n:", keyboard),
                        getPositiveInt("please enter a value for k:", keyboard)
                        );
                menu(keyboard);
                break;
            case 2:
                rabbit(getPositiveInt("please enter a value to run rabbit with:"
                        , keyboard));
                menu(keyboard);
                break;
            case 3:
                //fallout of the menu
                break;
        } 
    }
    final static int MINMENUCHOICE = 1;
    final static int MAXMENUCHOICE = 3;
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
     * gets a positve integer from the user and returns it it prompts the user 
     * with the message keyboard must be an initialized scanner instance
     */
    public static int getPositiveInt(String message, Scanner keyboard)
    {
        try
        {
            int value;
            System.out.println(message);
            value = keyboard.nextInt();
            if(value < BADVALUESBEGIN)
            {
                System.out.println("please enter a positive value");
                return getPositiveInt(message, keyboard);
            }
            //else
            //base case
            return value;
        }
        catch(Exception e)
        {
            return getPositiveInt(message, keyboard);
        }
    }
    final static int BADVALUESBEGIN = 0;
}
