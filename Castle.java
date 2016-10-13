import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Castle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
