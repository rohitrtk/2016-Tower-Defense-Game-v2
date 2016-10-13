import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * If an enemy touches an instance of this class, the enemy will be removed and the player will lose health
 * depending on what enemy touches this
 * 
 * @author Rohit Kisto
 * @version 13/10/2016
 */

public class Castle extends Actor
{
    private World world;
    private int x;
    private int y;
    
    public Castle(World world, int x, int y)
    {
        this.world = world;
        this.x = x;
        this.y = y;
        
        world.addObject(this, x, y);
    }
    
    /**
     * Act - do whatever the Castle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
    }    
}
