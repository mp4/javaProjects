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
    
    public static void getMazeFile()
    {
        try
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("please enter a maze file:");
            String file = scanner.nextLine();
            System.out.println("filepath:" + file);
            maze = new Maze(file);
            maze.runCreature();
            System.out.println(maze.toString());
        }
        catch(Exception e)
        {
            System.out.println("exception " + e.getMessage());
            getMazeFile();
        }
    }
}
