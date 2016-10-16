import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * This class will act as a general button class depending on what the string is
 */
public class Button extends GUI
{
    GreenfootImage greenfootImage;
    private String string;
    
    private Map1 map1;
    
    /**
     * Constructs a GUI object, must be called as super by subclasses
     * @param World world
     * @param int x position
     * @param int y position
     * @param String string
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
     * Constructs a GUI object, must be called as super by subclasses
     * @param World world
     * @param int x position
     * @param int y position
     * @param String string
     * @param World world
     */
    public Button(World world, int x, int y, String string, Map1 map1)
    {
        super(world, x, y);
        
        this.string = string;
        
        greenfootImage = new GreenfootImage(string, 50, Color.BLACK, Color.WHITE);
        setImage(greenfootImage);
        
        this.map1 = map1;
        
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
                if(string.equals("PLAY")) Greenfoot.setWorld(new WorldSelectScreen());
                else if(string.equals("HELP")) Greenfoot.setWorld(new HelpScreen());
                else if(string.equals("QUIT")) System.exit(0);
                else if(string.equals("MAP1")) 
                {
                    if(TitleScreen.firstLaunch) Greenfoot.setWorld(TitleScreen.map1);
                    else Greenfoot.setWorld(new Map1());
                }
                else if(string.equals("MAP2")) Greenfoot.setWorld(new Map2());
                else if(string.equals("MAP3")) Greenfoot.setWorld(new Map3());
                else if(string.equals("BACK")) Greenfoot.setWorld(new TitleScreen());
            }
        }
    }
    
    /**
     * Removes this object from the world
     * @return void
     */
    public void destroy()
    {
        world.removeObject(this);
    }
}
