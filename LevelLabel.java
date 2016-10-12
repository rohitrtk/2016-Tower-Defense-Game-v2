import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class LevelLabel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelLabel extends GUI
{
    private GreenfootImage image;
    private String label;
    
    public LevelLabel(World world, int x, int y, String label)
    {
        super(world, x, y);
        this.label = label;
        image = new GreenfootImage(label, 35, Color.YELLOW, new Color(0f, 0f, 0f ,0f));
        setImage(image);
        world.addObject(this, x, y);
    }
    
    /**
     * Act - do whatever the LevelLabel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(image);
    }    
    
    public void setLabel(String label)
    {
        this.label = label;
    }
}
