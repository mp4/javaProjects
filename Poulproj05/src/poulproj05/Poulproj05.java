/*
 * this is the driver program to test the creature and maze classes
 * marsh poulson 9/27/2013
 */
package poulproj05;

import java.util.Scanner;


public class Poulproj05 {

    public static Maze maze;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("welcome to the creature and maze driver program");
        
        getMazeFile();
    }
    /*
     * attempts to get a valid maze file goes until it gets one from the user
     * will prompt the user to enter this file and then will display whether
     * or not there was a solution and if there is will print the maze with 
     * the path of the solution and all paths tried
     */
    public static void getMazeFile()
    {
        try
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("please enter a maze file:");
            String file = scanner.nextLine();
            System.out.println("filepath:" + file);
            maze = new Maze(file);
            if(maze.runCreature())
            {
                System.out.println("maze solution");
            }
            else
            {
                System.out.println("no solution");
            }
            System.out.println(maze.toString());
        }
        catch(Exception e)
        {
            System.out.println("exception " + e.getMessage());
            getMazeFile();
        }
    }
}
