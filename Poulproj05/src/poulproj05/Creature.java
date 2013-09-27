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
        boolean success = false;
        if(maze.isClear(creature.x_, creature.y_ +1))
        {
            creature.y_++;
            maze.markPath(creature.x_, creature.y_);
            if(maze.atExit(creature.x_, creature.y_))
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
                                maze.markVisited(creature.x_, creature.y_);
                                creature.y_--;
                            }
                        }
                    }
                }
                
            }
        }
        return success;
    }
    public static boolean goSouth(Maze maze, Creature creature)
    {
        boolean success = false;
        if(maze.isClear(creature.x_, creature.y_ +1))
        {
            creature.y_++;
            maze.markPath(creature.x_, creature.y_);
            if(maze.atExit(creature.x_, creature.y_))
                return true;
            else
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
                            maze.markVisited(creature.x_, creature.y_);
                            creature.y_--;
                        }
                    }
                }
                
            }
        }
        return success;
    }
    public static boolean goWest(Maze maze, Creature creature)
    {
        boolean success = false;
        if(maze.isClear(creature.x_, creature.y_ +1))
        {
            creature.y_++;
            maze.markPath(creature.x_, creature.y_);
            if(maze.atExit(creature.x_, creature.y_))
                return true;
            else
            {
                success = goNorth(maze, creature);
                if(!success)
                {
                    success = goWest(maze, creature);
                    if(!success)
                    {
                        success = goSouth(maze, creature);
                        if(!success)
                        {
                            maze.markVisited(creature.x_, creature.y_);
                            creature.y_--;
                        }
                    }
                }
                
            }
        }
        return success;
    }
    public static boolean goEast(Maze maze, Creature creature)
    {
        boolean success = false;
        if(maze.isClear(creature.x_, creature.y_ +1))
        {
            creature.y_++;
            maze.markPath(creature.x_, creature.y_);
            if(maze.atExit(creature.x_, creature.y_))
                return true;
            else
            {
                success = goNorth(maze, creature);
                if(!success)
                {
                    success = goEast(maze, creature);
                    if(!success)
                    {
                        success = goSouth(maze, creature);
                        if(!success)
                        {
                            maze.markVisited(creature.x_, creature.y_);
                            creature.y_--;
                        }
                    }
                }
                
            }
        }
        return success;
    }
    public int[] reportPosition()
    {
        return new int[]{x_, y_};
    }
}
