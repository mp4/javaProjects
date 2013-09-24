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
    
    public static boolean goNorth(Maze maze, Creature creature)
    {
        boolean success;
        if(maze.isClear(creature.x_, creature.y_ +1))
        {
            creature.y_++;
            creature.MarkPosition();
            if(maze_.atExit(x_, y_))
                return true;
            else
            {
                success = goNorth(maze, creature);
                if(!success)
                {
                    success = goWest(maze, creature);
                    if(!success)
                    {
                        success = goEast(maze, creature);
                        if(!success)
                        {
                            success = goSouth(maze, creature);
                            if(!success)
                            {
                                creature.MarkVisited();
                                creature.y_--;
                            }
                        }
                    }
                }
                
            }
        }
    }
    public static boolean moveSouth(Maze maze, Creature creature)
    {
        
    }
    public static boolean moveWest(Maze maze, Creature creature)
    {
        
    }
    public static boolean moveEast(Maze maze, Creature creature)
    {
        
    }
    public void MarkPosition()
    {
        maze_[x][y] = Maze.PATH;//set this to the proper letter
    }
    public void MarkVisited()
    {
        maze_[x][y] = Maze.VISITED;
    }
    public int[] reportPosition()
    {
        return new int[]{x_, y_};
    }
}
