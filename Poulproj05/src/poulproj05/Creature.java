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
    
    public boolean moveNorth()
    {
        if(maze.isClear(x_, y_ +1))
        {
            y_++;
            MarkPosition();
        }
    }
    public boolean moveSouth()
    {
        
    }
    public boolean moveWest()
    {
        
    }
    public boolean moveEast()
    {
        
    }
    public void MarkPosition()
    {
        maze_[x][y] = Maze.PATH;//set this to the proper letter
    }
    public int[] reportPosition()
    {
        return new int[]{x_, y_};
    }
}
