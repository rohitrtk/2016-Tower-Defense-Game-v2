import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * This class will be used as a label to display the current HP of the player
 * 
 * @author Rohit Terry Kisto
 * @version 2016/9/30
 */
public class HP extends GUI
{
    private int hp;
    private GreenfootImage image;                   // A greenfoot image to display text
    private Color colour;                           // Colour object for the background
    
    /**
     * Constructs a new HP label
     * @param World world
     * @param int x position
     * @param int y position
     * @param int hp
     */
    public HP(World world, int x, int y, int hp)
    {
        super(world, x, y);
        
        this.hp = hp;
        colour = new Color(0f, 0f, 0f ,0f);         // Transparent colour!
        image = new GreenfootImage("HP: " + hp, 30, Color.RED, colour); // Makes the image a string with a transparent background
        
        setImage(image);
        
        world.addObject(this, x, y);
    }
    
    /**
     * Act - do whatever the HP wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        image = new GreenfootImage("HP: " + hp, 30, Color.RED, colour);
        
        setImage(image);
    }   
    
    /**
     * Sets the current hp to the parameter
     * @param int hp
     * @return void
     */
    public void setHp(int hp)
    {
        this.hp = hp;
    }
    
    /**
     * Gets the current round 
     * @return int hp
     */
    public int getHp()
    {
        return hp;
    }
}
