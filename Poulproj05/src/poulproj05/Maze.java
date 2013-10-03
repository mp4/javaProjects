/*
 * the maze contains squares that are clear, walls, path to exit and visited 
 * but not in final path
 * marsh Poulson 9/26/2013
 */
package poulproj05;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.imageio.IIOException;

/*
 * The class maze represents a maze and internally stores values for each of its squares
 */
public class Maze {
    public static final char CLEAR = ' ', WALL = 'x', CREATURE = 'o', VISTITED = 'v', PATH = 'p';
    private char[][] maze_;
    private Creature creature_;
    private int startX, startY, endX, endY;
    private final int height, width;
    
    /*
     * returns the height of the maze
     */
    public int getHeight()
    {
        return height;
    }
    /*
     * returns the width of the maze
     */
    public int getWidth()
    {
        return width;
    }
    /*
     * returns the x value of the starting location
     */
    public int getStartX()
    {
        return startX;
    }
    /*
     * returns the y value for the starting position 
     */
    public int getStartY()
    {
        return startY;
    }
    /*
     * mark position x, y as visited 
     */
    public void markVisited(int x, int y)
    {
        maze_[x][y] = Maze.VISTITED;
    }
    /*
     * Mark the position x, y as the path
     */
    public void markPath(int x, int y)
    {
        maze_[x][y] = Maze.PATH;
    }
    /*
     * Instantiated a maze from a given file throws exceptions if the file
     * is not in the correct format
     */
    public Maze(String file) throws FileNotFoundException, IOException
    {
        BufferedReader fileIn = new BufferedReader(new FileReader(file));
        String heightWidth = fileIn.readLine();
        String[] hw = heightWidth.split(" ");
        if(hw.length != 2)
        {
            throw new IIOException("file is not of the correct format");
        }
        height = Integer.parseInt(hw[1]);
        width = Integer.parseInt(hw[0]);
        
        maze_ = new char[height][width];
        
        //get exit from file
        String[] exit = fileIn.readLine().split(" ");
        if(exit.length != 2)
        {
            throw new IIOException("file is not of the correct format");
        }
        endX = Integer.parseInt(exit[0]);
        endY = Integer.parseInt(exit[1]);
        
        //get start from file
        String[] start = fileIn.readLine().split(" ");
        if(start.length != 2)
        {
            throw new IIOException("file is not of the correct format");
        }
        startX = Integer.parseInt(start[0]);
        startY = Integer.parseInt(start[1]);
        try
        {
            //now read in values
            for(int i= 0; i < height; i++)
            {
                String line = fileIn.readLine();
                for(int k=0; k< width; k++)
                {
                    maze_[i][k] = line.charAt(k);
                    //verify value here
                    if(!(line.charAt(k) == CLEAR || line.charAt(k) == WALL))
                    {
                        throw new IOException("maze should only be composed of x "+
                                "and \' \' found" + line.charAt(k));
                    }
                }
            }
        }
        catch(Exception e)
        {
            //get the right message out of this part of the program
            if(e == null)
                throw new IOException("maze file is corrupt");
            throw e;
        }
        fileIn.close();
        creature_ = new Creature(startX, startY);
    }
    /*
     * returns whether or not a square is clear given by x, y
     * if not in the maze is not clear
     */
    public boolean isClear(int x , int y)
    {
        if(x >= height || x < 0 || y >= width || y < 0)
            return false;
        if(maze_[x][y] == CLEAR)
            return true;
        return false;
    }
    /*
     * returns true if the coordinates x, y are the exit
     */
    public boolean atExit(int x, int y)
    {
        if(endX == x && endY == y)
        {
            return true;
        }
        return false;
    }
    
    /*
     * returns the string representation of the maze
     */
    @Override public String toString()
    {
        String returnMe = new String();
        for(int i=0; i < height; i++)
        {
            for(int k=0; k < width; k++)
            {
                returnMe = returnMe + maze_[i][k];
            }
            returnMe = returnMe + "\n";
        }
        return returnMe;
    }
    /*
     * runs the creature through the maze will modify the maze
     * returns if it was successful false means there is no way to the exit
     */
    public boolean runCreature()
    {
        return Creature.goNorth(this, creature_) || 
                Creature.goSouth(this, creature_) ||
                Creature.goEast(this, creature_) ||
                Creature.goWest(this, creature_);
    }
}
