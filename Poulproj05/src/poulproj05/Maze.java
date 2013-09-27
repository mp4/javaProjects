/*
 * the maze contains squares that are clear, walls, path to exit and visited 
 * but not in final path
 */
package poulproj05;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.imageio.IIOException;

/**
 *
 * @author marsh
 */
public class Maze {
    public static final char CLEAR = ' ', WALL = 'x', CREATURE = 'o', VISTITED = 'v', PATH = 'p';
    private char[][] maze_;
    private Creature creature_;
    private int startX, startY, endX, endY;
    private final int height, width;
    
    public int getHeight()
    {
        return height;
    }
    public int getWidth()
    {
        return width;
    }
    
    public int getStartX()
    {
        return startX;
    }
    public int getStartY()
    {
        return startY;
    }
    public void markVisited(int x, int y)
    {
        maze_[x][y] = Maze.VISTITED;
    }
    public void markPath(int x, int y)
    {
        maze_[x][y] = Maze.PATH;
    }
    /**
     *
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
        height = Integer.parseInt(hw[0]);
        width = Integer.parseInt(hw[1]);
        
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
        
        //now read in values
        for(int i= 0; i < height; i++)
        {
            String line = fileIn.readLine();
            for(int k=0; k< width; k++)
            {
                maze_[i][k] = line.charAt(k);
                //verify value here
                
                
            }
        }
        fileIn.close();
    }
    public boolean isClear(int x , int y)
    {
        if(maze_[x][y] == CLEAR)
            return true;
        return false;
    }
    public boolean atExit(int x, int y)
    {
        if(endX == x && endY == y)
        {
            return true;
        }
        return false;
    }
}
