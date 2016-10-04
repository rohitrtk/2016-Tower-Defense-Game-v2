import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Tile of type 'Dirt', tower CAN NOT be placed on this tile
 * 
 * @author Rohit Terry Kisto 
 * @version 2016/9/19
 */
public class Dirt extends Tile
{
    /**
     * Constructor for Dirt, used as a test object for scene
     * @param int x position
     * @param int y position
     */
    public Dirt(int x, int y)
    {
        super(x, y);
        this.x = x;
        this.y = y;
    }
    
    /**
     * Constructor for Dirt 
     * @param World world
     * @param int x position
     * @param int y position
     */
    public Dirt(World world, int x, int y)
    {
        super(world, x, y);
        this.world = world;
        this.x = x;
        this.y = y;
    }
    
    /**
     * Act - do whatever the Dirt wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
