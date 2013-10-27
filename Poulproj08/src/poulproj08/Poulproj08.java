/*
 * contains the driver class for the sorting algorithms project
 * by marsh poulson 10/26/2013
 */
package poulproj08;

import java.util.Scanner;
import java.util.Random;

/*
 * this class contains the driver program and the associated user facing logic
 */
public class Poulproj08 {

    static Random rand;
    /**
     * will initialize rand and a scanner output a greeting to the user 
     * and then call the menu
     */
    public static void main(String[] args) {
        rand = new Random(System.nanoTime());
        Scanner kb = new Scanner(System.in);
        System.out.println("welcome to the sort comparison application");
        menu(kb);
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
        System.out.println("1) time sorts");
        System.out.println("2) exit");
        choice = getValidMenuInt(keyboard);
        System.out.println("");
        
        switch(choice)
        {
            case 1:
                runAllTests(keyboard);
                menu(keyboard);
                break;
            case 2:
                break;
        } 
    }
    final static int MINMENUCHOICE = 1;
    final static int MAXMENUCHOICE = 2;
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
     * this function will prompt the user to enter a valid array length
     * and will return this value will reprompt as many times as necessary
     * the parameter is an initialized instance of a scanner
     */
    public static int getValidInt(Scanner keyboard)
    {
        try
        {
            int value;
            System.out.println("please enter the length:");
            value = keyboard.nextInt();
            keyboard.nextLine();//purges \n from the stream
            if(value < 0 )
            {
                return getValidMenuInt(keyboard);
            }
            //else
            //base case
            return value;
        }
        catch(Exception e)
        {
            return getValidInt(keyboard);
        }
    }
    /*
     * returns an array loaded with random values of length length 
     * Random rand must be initialized before calling this function
     */
    public static Integer[] loadArray(int length)
    {
        Integer[] returnMe = new Integer[length];
        
        for(int i=0; i < length; i++)
        {
            returnMe[i] = rand.nextInt();
        }
        
        return returnMe;
    }
    /*
     * runs all of the sorts with the same data and displays the time it takes 
     * to complete each to the user
     */
    public static void runAllTests(Scanner keyboard)
    {
        Integer[] data0 = loadArray(getValidInt(keyboard));
        Integer[] data1 = new Integer[data0.length];
        long startTime, endTime, duration;
        System.arraycopy(data0, 0, data1, 0, data0.length);
        
        startTime = System.nanoTime();
        sorts.bubbleSort(data0, data0.length);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        
        System.out.println(duration + " ns for the bubble sort");
        
        //now setup for next run
        System.arraycopy(data1, 0, data0, 0, data1.length);
        
        startTime = System.nanoTime();
        sorts.insertionSort(data0, data0.length);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        
        System.out.println(duration + " ns for the insertion sort");
        
        //now setup for next run
        System.arraycopy(data1, 0, data0, 0, data1.length);
        
        startTime = System.nanoTime();
        sorts.mergesort(data0);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        
        System.out.println(duration + " ns for the merge sort");
        
        //now setup for next run
        System.arraycopy(data1, 0, data0, 0, data1.length);
        
        startTime = System.nanoTime();
        //should only have to pass in array and have this function figure out
        //the length
        sorts.quickSort(data0, 0, data0.length-1);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        
        System.out.println(duration + " ns for the quick sort");
        
        //now setup for next run
        System.arraycopy(data1, 0, data0, 0, data1.length);
        
        startTime = System.nanoTime();
        sorts.selectionSort(data0, data0.length);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        
        System.out.println(duration + " ns for the selection sort");
    }
}
