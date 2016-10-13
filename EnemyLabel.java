import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * This class will attach a 'label' to an enemy object which will display to the user the hp 
 * of the enemy
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyLabel extends Actor
{
    private World world;
    private int x;
    private int y;
    private int hp;
    
    private GreenfootImage image;
    
    /**
     * Constructs a new EnemyLabel object
     * @param World world
     * @param int x position
     * @parma int y position
     * @param int hp of enemy
     */
    public EnemyLabel(World world, int x, int y, int hp)
    {
        this.world = world;
        this.x = x;
        this.y = y;
        this.hp = hp;
        
        image = new GreenfootImage(""+hp, 20, Color.YELLOW, new Color(0f, 0f, 0f, 0f));
        setImage(image);
        
        world.addObject(this, x, y);
    }
    
    /**
     * Act - do whatever the EnemyLabel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        image = new GreenfootImage(""+hp, 20, Color.YELLOW, new Color(0f, 0f, 0f, 0f));
        //image.drawString(""+hp, x, y);
        setImage(image);
    }    
    
    /**
     * This method will set the hp of the enemy label
     * @param int hp
     * @return void
     */
    public void setHp(int hp)
    {
        this.hp = hp;
    }
    
    public void destroy()
    {
        world.removeObject(this);
    }
}
