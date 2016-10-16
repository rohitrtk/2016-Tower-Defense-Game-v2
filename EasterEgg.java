import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class handles the easter egg in this game, if the mouse is pressed
 * on an object of this class, add to the counter, if the counter reaches 3,
 * spawn the boss
 * 
 * @author Rohit Kisto
 * @version 14/10/2016
 */
public class EasterEgg extends Actor
{
    private World world;
    private int x;
    private int y;
    
    public EasterEgg(World world, int x, int y)
    {
        this.world = world;
        this.x = x;
        this.y = y;
        
        world.addObject(this, x, y);
    }
   
    /**
     * Act - do whatever the EasterEgg wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
        {
            EasterEggHandler.counter++;
            world.removeObject(this);
        }
    }    
}
