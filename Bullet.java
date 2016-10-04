import greenfoot.*;

/**
 * This class will be used a bullet for the basic tower and extended upon for all bullets in the game.
 * 
 * @author Rohit Terry Kisto 
 * @version 2016/9/30
 */
public class Bullet extends Actor
{
    protected World world;                                            // World the bullet belonds to
    protected int x;                                                  // Bullets x position
    protected int y;                                                  // Bullets y position
    protected double ex;                                              // Enemies x position
    protected double ey;                                              // Enemies y position
    protected int velocity;                                           // Bullets velocity in all directions
    protected double angle;
    
    private final int baseDamage = 100;                               // The base damage of the tower
    protected int damage = baseDamage * 1;                              // The actual damage of the tower
    
    /**
     * Constructs the Bullet
     * @param World world
     * @param int x position
     * @param int y position
     * @param double enemy x position
     * @param double enemy y position
     */
    public Bullet(World world, int x, int y, double ex, double ey)
    {
        this.world = world;
        this.x = x;
        this.y = y;
        this.ex = ex;
        this.ey = ey;
        
        velocity = 10;                                              // Sets the move speed of the bullet
        
        angle = Math.atan2(ey - y, ex - x);                  // Angle is the same as the inverse tangent of the difference between
                                                                    // the enemies position and the towers position
        setRotation((int)(Math.toDegrees((angle))));                // Aim towards x angle
        
        world.addObject(this, x, y);                                // Add this object to the world
    }
    
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(velocity);
        if(isAtEdge() || getX() > 10 * 60)
        {
            destroy();                                              // If the bullet is on the edge of the screen, delete it
        }
    }    
    
    /**
     * This method will remove the bullet from the scene
     * @return void
     */
    public void destroy()
    {
        world.removeObject(this);                                   // Destroy this object
    }
    
    /**
     * Sets the bullet damage of this bullet
     * @param int damage
     * @return void
     */
    public void setBulletDamage(int damage)
    {
        this.damage = damage;
    }
    
    /**
     * Gets the damage of this bullet
     * @return int damage
     */
    public int getBulletDamage()
    {
        return damage;
    }
}
