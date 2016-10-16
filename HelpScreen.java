import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class will display information helpful to the player when the player
 * clicks the help button
 * 
 * @author Rohit Kisto
 * @version 13/10/2016
 */
public class HelpScreen extends World
{
    
    private Button back;
    
    /**
     * Constructor for objects of class HelpScreen.
     * 
     */
    public HelpScreen()
    {    
        super(840, 540, 1); 
        
        back = new Button(this, 100, 100, "BACK");
    }    
}
