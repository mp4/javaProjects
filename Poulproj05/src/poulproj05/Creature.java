/*
 * Contains the creature class partially specified in the project description
 * by marsh Poulson 9/27/2013
 */
package poulproj05;

/**
 * the creature class to represent the creature that moves through the maze
 * north is y+, south y-, east x+, west x- axes
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
    /*
     * attempts to move the creature in the maze to the south and will also try
     * all the other directions except north returns success
     */
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
    /*
     * attempts to move the creature to the west in the maze 
     * Returns success will attempt all directions except east
     */
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
    /*
     * returns the success attempt to move the creature to the east in the maze
     * will attempt to move it to all directions except west 
     */
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
    /*
     * returns an array of length 2 the first index is the x position of the creature
     * and the second index is the y value of the creature
     */
    public int[] reportPosition()
    {
        return new int[]{x_, y_};
    }
}
