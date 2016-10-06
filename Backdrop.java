import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class will be used as a backdrop for the GUI on the right hand side of the screen
 * 
 * @author Rohit Terry Kisto 
 * @version 2016/9/30
 */
public class Backdrop extends GUI
{
    /**
     * Constructs a new Backdrop
     * @param World world
     * @param int x position
     * @param int y position
     */
    public Backdrop(World world, int x, int y)
    {
        super(world, x, y);
        imagePath = "backdrop.png";
        
        setImage(imagePath);
        world.addObject(this, x, y);
    }
    
    /**
     * Act - do whatever the Backdrop wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
    }   
}
