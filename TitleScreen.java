import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * This class will be displayed when the uesr first launches the game, will display 
 * 3 buttons, play, help and quit.
 * 
 * @author Rohit Kisto 
 * @version 13/10/2016
 */
public class TitleScreen extends World
{

    //Map1 map1;
    String strings[];
    Button buttons[];
    
    public static Map1 map1;
    public static boolean firstLaunch = true;
    
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        super(840, 540, 1); 
        
        strings = new String[3];
        buttons = new Button[3];
        
        for(int i = 0;i < buttons.length;i++)
        {
            if(i == 0) strings[i] = "PLAY";
            else if(i == 1) strings[i] = "HELP";
            else if(i == 2) strings[i] = "QUIT";
            /*if(i == 0) 
            {
                buttons[i] = new Button(this, 275 + (i * 150), getHeight() / 2, strings[i],
                   map1);
            } else {
                buttons[i] = new Button(this, 275 + (i * 150), getHeight() / 2, strings[i]);
            }*/
            buttons[i] = new Button(this, 275 + (i * 150), getHeight() / 2, strings[i]);
        }      
    }
    
    /**
     * Constructor for objects of class TitleScreen.
     * @param Map1 map1
     */
    public TitleScreen(Map1 map1)
    {    
        super(840, 540, 1); 
        
        TitleScreen.map1 = map1;
        
        strings = new String[3];
        buttons = new Button[3];
        
        for(int i = 0;i < buttons.length;i++)
        {
            if(i == 0) strings[i] = "PLAY";
            else if(i == 1) strings[i] = "HELP";
            else if(i == 2) strings[i] = "QUIT";
            /*if(i == 0) 
            {
                buttons[i] = new Button(this, 275 + (i * 150), getHeight() / 2, strings[i],
                   map1);
            } else {
                buttons[i] = new Button(this, 275 + (i * 150), getHeight() / 2, strings[i]);
            }*/
            buttons[i] = new Button(this, 275 + (i * 150), getHeight() / 2, strings[i]);
        }      
    }
    
    public void act()
    {
        
    }
}