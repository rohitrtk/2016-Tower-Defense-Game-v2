import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This will be used as an after effect for a dead enemy 
 * 
 * @author Rohit Terry Kisto
 * @version 2016/9/30
 */
public class Bloodstain extends Actor
{
    protected World world;        // World this object belongs to
    protected int x;              // x position
    protected int y;              // y position
    protected int timer = 0;      // The timer before the bloodstain despawns
    
    /**
     * Constructs a new bloodstain
     * @param World world
     * @param int x position
     * @param int y position
     */
    public Bloodstain(World world, int x, int y)
    {
        this.world = world;
        this.x = x;
        this.y = y;
    }
    
    /**
     * Act - do whatever the Bloodstain wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        timer++;
        if(timer > 100) destroy();
    }
    
    /**
     * Removes this object from the world
     * @return void
     */
    protected void destroy()
    {
        world.removeObject(this);
    }
}
