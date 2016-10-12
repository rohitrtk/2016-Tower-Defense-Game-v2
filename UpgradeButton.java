import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class UpgradeButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UpgradeButton extends GUI
{
    private final String notSelectedPath = "wrench.png";
    private final String selectedPath = "wrench_selected.png";
    public static boolean selected;
    
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
        MouseInfo mouse = Greenfoot.getMouseInfo();

        if(mouse != null)
        {
            if(Greenfoot.mouseClicked(this))
            {
                if(selected) selected = false;
                else if(!selected) selected = true;
            }
        }
        
        if(selected) 
        {
            setImage(selectedPath);
        } else {
            setImage(notSelectedPath);
        }
    } 
}
