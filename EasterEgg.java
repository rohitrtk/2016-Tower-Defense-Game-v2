import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EasterEgg here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
