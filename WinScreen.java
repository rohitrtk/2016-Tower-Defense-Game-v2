import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class will display the win screen when the player meets the map win condition
 * 
 * @author Rohit Kisto
 * @version 13/10/2016
 */
public class WinScreen extends World
{
    private Button back;
    /**
     * Constructor for objects of class WinScreen.
     * 
     */
    public WinScreen()
    {    
        super(840, 540, 1); 
        
        back = new Button(this, 100, 100, "BACK");
    }
}
