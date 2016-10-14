import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class will allow the player to click this object which willl then enable the
 * player to upgrade their towers depending on how much money they have
 * 
 * @author Rohit Kisto
 * @version 13/10/2016
 */
public class UpgradeButton extends GUI
{
    private final String notSelectedPath = "wrench.png";            // Not selected image
    private final String selectedPath = "wrench_selected.png";      // Selected image
    public static boolean selected;                                 // Selected boolean
    
    public UpgradeButton(World world, int x, int y)
    {
        super(world, x, y);
        selected = false;
        
        world.addObject(this, x, y);
    }
    
    /**
     * Act - do whatever the UpgradeButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(!Map1.pause || !Map2.pause || !Map3.pause)
        {
            MouseInfo mouse = Greenfoot.getMouseInfo();

            if(mouse != null)
            {
                if(Greenfoot.mouseClicked(this))
                {
                    // If this button is selected and clicked, set selected to false
                    if(selected) selected = false;
                    // Vice Versa
                    else if(!selected) selected = true;
                }
            }
        
            // Set image depending on boolean
            if(selected) 
            {
                setImage(selectedPath);
            } else {
                setImage(notSelectedPath);
            }
        }
    } 
}
