import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class will be extended upon for all GUI objects
 * 
 * @author Rohit Terry Kisto
 * @version 2016/9/30
 */
public abstract class GUI extends Actor
{
    protected World world;                      // The world the GUI object is in
    protected int x;                            // x position on screen
    protected int y;                            // y position on screen
    protected String imagePath;                 // The GUIs image path location
    
    /**
     * Constructs a GUI object, must be called as super by subclasses
     * @param World world
     * @param int x position
     * @param int y position
     */
    public GUI(World world, int x, int y)
    {
        this.world = world;
        this.x = x;
        this.y = y;
    }
    
    /**
     * Act - do whatever the GUI wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {    
    }
}
