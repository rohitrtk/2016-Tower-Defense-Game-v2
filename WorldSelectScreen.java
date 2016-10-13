import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class displays a screen after the player clicks play on the title screen,
 * will display 4 buttons, the back button and 3 map selecte buttons
 * 
 * @author Rohit Kisto
 * @version 13/10/2016
 */
public class WorldSelectScreen extends World
{
    private String[] strings;
    Button[] buttons;
    
    /**
     * Constructor for objects of class WorldSelectScreen.
     * 
     */
    public WorldSelectScreen()
    {    
        super(840, 540, 1); 
        
        strings = new String[4];
        strings[0] = "MAP1";
        strings[1] = "MAP2";
        strings[2] = "MAP3";
        strings[3] = "BACK";
        
        buttons = new Button[4];
        for(int i = 0;i < strings.length;i++)
        {
            if(i != 3) 
            {
                buttons[i] = new Button(this, 275 + (i * 150), getHeight() / 2, strings[i]);
            } else {
                buttons[i] = new Button(this, 100, 100, strings[i]);
            }
        }
    }
}
