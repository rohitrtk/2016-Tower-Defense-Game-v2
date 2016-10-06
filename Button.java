import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * This class will act as a general button class depending on what the string is
 */
public class Button extends GUI
{
    GreenfootImage greenfootImage;
    private String string;
    
    /**
     * Constructs a GUI object, must be called as super by subclasses
     * @param World world
     * @param int x position
     * @param int y position
     */
    public Button(World world, int x, int y, String string)
    {
        super(world, x, y);
        
        this.string = string;
        
        greenfootImage = new GreenfootImage(string, 50, Color.BLACK, Color.WHITE);
        setImage(greenfootImage);
        
        world.addObject(this, x, y);
    }
    
    /**
     * Act - do whatever the GUI wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {    
        MouseInfo mouse = Greenfoot.getMouseInfo();
        
        greenfootImage = new GreenfootImage(string, 30, Color.BLACK, Color.WHITE);
        setImage(greenfootImage);
        
        if(mouse != null)
        {
            if(Greenfoot.mouseClicked(this))
            {
                if(string.equals("PLAY")) Greenfoot.setWorld(new Map1());
                else if(string.equals("HELP")) ;
                else if(string.equals("QUIT")) System.exit(0);
            }
        }
    }
}
