/*
 * Contains the creature class partially specified in the project description
 * by marsh Poulson 9/27/2013
 */
package poulproj05;

/**
 * the creature class to represent the creature that moves through the maze
 * north is y+, south y-, east x+, west x- 
 */
public class Creature {
    private int x_, y_;
    /*
     * returns the success of attempting to move the creature through the maze
     * attempt to go north first and then attempts to move in all of the other directions
     */
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
