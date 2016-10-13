import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class will be the bullet for the Psycho Tower
 * 
 * @author Rohit Terry Kisto
 * @version 2016/9/30
 */
public class PsychoBullet extends Bullet
{
    /**
     * Constructs the Psycho Bullet
     * @param World world
     * @param int x position
     * @param int y position
     * @param double enemy x position
     * @param double enemy y position
     */
    public PsychoBullet(World world, int x, int y, double ex, double ey, int towerLevel)
    {
        super(world, x, y, ex, ey, towerLevel);
        
        velocity = 20;
        
        //turnTowards(ex, ey);
        double angle = Math.atan2(ey - y, ex - x);                  // Angle is the same as the inverse tangent of the difference between
                                                                    // the enemies position and the towers position
        setRotation((int)(Math.toDegrees((angle))));                // Aim towards x angle
        
        //System.out.println((int)(-1 * Math.toDegrees((angle))));
        world.addObject(this, x, y);                                // Add this object to the world
    }
    
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * @return void
     */
    public void act() 
    {
        super.act();
    }    
    
    /**
     * This method will remove the bullet from the scene
     * @return void
     */
    public void destroy()
    {
        super.destroy();
    }
    
    /**
     * Sets the bullet damage of this bullet
     * @param int damage
     * @return void
     */
    public void setBulletDamage(int damage)
    {
        super.setBulletDamage(damage);
    }
    
    /**
     * Gets the damage of this bullet
     * @return int damage
     */
    public int getBulletDamage()
    {
        return super.getBulletDamage();
    }
}
