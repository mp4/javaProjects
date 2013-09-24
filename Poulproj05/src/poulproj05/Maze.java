/*
 * the maze contains squares that are clear, walls, path to exit and visited 
 * but not in final path
 */
package poulproj05;

/**
 *
 * @author marsh
 */
public class Maze {
    public static final char CLEAR = ' ', WALL = 'x', CREATURE = 'o', VISTITED = 'v';
    private char[][] maze_;
    private Creature creature_;
    private int startX, startY;
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
    public static Maze LoadFromFile(String file)
    {
        
    }
    public Maze(file)
    {
        this = Maze.LoadFromFile(file);
    }
}
