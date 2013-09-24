/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poulproj05;

/**
 *
 * @author marsh
 */
public class Creature {
    private int x_, y_;
    private Maze maze_;
    
    public void setMaze(Maze maze)
    {
        maze_ = maze;
        x_ = maze.getStartX();
        y_ = maze.getStartY();
    }
    
    public void moveNorth()
    {
        
    }
    public void moveSouth()
    {
        
    }
    public void moveWest()
    {
        
    }
    public void moveEast()
    {
        
    }
    public void MarkPosition()
    {
        maze_[x][y] = "m";//set this to the proper letter
    }
    public int[] reportPosition()
    {
        return new int[]{x_, y_};
    }
}
