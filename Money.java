import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * This class will be used as a label to display the money the player has
 * 
 * @author Rohit Terry Kisto
 * @version 2016/9/30
 */
public class Money extends GUI
{
    int money;                              // The amount of money the player has
    GreenfootImage image;                   // A greenfoot image to display text
    Color colour;                           // Colour object for the background
    
    /**
     * Constructs a new money label for the user to view
     * @param World world
     * @param int x position
     * @param int y position
     * @param int money
     */
    public Money(World world, int x, int y, int money)
    {
        super(world, x, y);
        
        this.money = money;
        colour = new Color(0f, 0f, 0f ,0f);         // Transparent colour!
        image = new GreenfootImage("$$$: " + money, 30, Color.GREEN, colour); // Makes the image a string with a transparent background
        
        setImage(image);
        
        world.addObject(this, x, y);
    }
    
    /**
     * Act - do whatever the Money wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        image = new GreenfootImage("$$$: " + money, 30, Color.GREEN, colour);
        
        setImage(image);
    }   
    
    /**
     * Sets the current money to the parameter
     * @param int money
     * @return void
     */
    public void setMoney(int money)
    {
        this.money = money;
    }
    
    /**
     * Gets the current round 
     * @return int money
     */
    public int getMoney()
    {
        return money;
    }  
}
