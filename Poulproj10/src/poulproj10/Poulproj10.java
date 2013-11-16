/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package poulproj10;

import java.util.Scanner;

/**
 *
 * @author marsh
 */
public class Poulproj10 {

    /**
     * @param args the command line arguments
     */
    static PriorityQueue<Float> priorityQueue;
    
    public static void main(String[] args) {
        // TODO code application logic here
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

                menu(keyboard);
                break;
            case 2:
   
                menu(keyboard);
                break;
            case 3:
                System.out.println(priorityQueue.isEmpty());
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
