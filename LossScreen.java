import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class will display the loss screen when the player has less than 1 health
 * 
 * @author Rohit Kisto
 * @version 13/10/2016
 */
public class LossScreen extends World
{
    private Button back;
    
    /**
     * Constructor for objects of class LossScreen.
     * 
     */
    public LossScreen()
    {    
        super(840, 540, 1); 
        
        back = new Button(this, 100, 100, "BACK");
    }
}
