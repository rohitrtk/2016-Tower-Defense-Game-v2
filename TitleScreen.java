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

    String[] names = {"PLAY, HELP, QUIT"};
    GreenfootImage[] buttons;
    
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        super(840, 540, 1); 
        
        buttons = new GreenfootImage[3];
        for(int i = 0;i < buttons.length;i++)
        {
            buttons[i] = new GreenfootImage(names[i], 30, Color.BLACK, Color.WHITE);
        }
    }
    
    public void act()
    {
        
    }
}
