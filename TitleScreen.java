import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{

    Map1 map1;
    String strings[];
    Button buttons[];
    
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen(Map1 map1)
    {    
        super(840, 540, 1); 
        
        this.map1 = map1;
        
        strings = new String[3];
        buttons = new Button[3];
        
        for(int i = 0;i < buttons.length;i++)
        {
            if(i == 0) strings[i] = "PLAY";
            else if(i == 1) strings[i] = "HELP";
            else strings[i] = "QUIT";
            
            if(i == 0) 
            {
                buttons[i] = new Button(this, 275 + (i * 150), getHeight() / 2, strings[i],
                   map1);
            } else {
                buttons[i] = new Button(this, 275 + (i * 150), getHeight() / 2, strings[i]);
            }
        }      
    }
    
    public void act()
    {
        
    }
}
