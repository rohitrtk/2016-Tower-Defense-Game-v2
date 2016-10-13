import greenfoot.*;  
import java.awt.Color;

/**
 * This class will be used as a label to display the current round the player is on
 * 
 * @author Rohit Terry Kisto
 * @version 2016/9/30
 */
public class Round extends GUI
{
    private int round;                              // Current round player is on
    private GreenfootImage image;                   // A greenfoot image to display text
    private Color colour;                           // Colour object for the background of the string ^
    
    /**
     * Constructs a new Round label to display to the user
     * @param World world
     * @param int x position
     * @param int y position
     * @param int round
     */
    public Round(World world, int x, int y, int round)
    {
        super(world, x, y);
        this.round = round;
        
        colour = new Color(0f, 0f, 0f ,0f);         // Transparent colour!
        image = new GreenfootImage(" Round: " + round, 30, Color.CYAN, colour); // Makes the image a string with a transparent background
        
        setImage(image);
        
        world.addObject(this, x, y);
    }
    
    /**
     * Act - do whatever the Round wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        image = new GreenfootImage(" Round: " + round, 30, Color.CYAN, colour);
        
        setImage(image);
    }
    
    /**
     * Sets the current round to the parameter
     * @param int round
     * @return void
     */
    public void setRound(int round)
    {
        this.round = round;
    }
    
    /**
     * Gets the current round 
     * @return int round
     */
    public int getRound()
    {
        return round;
    }
}
