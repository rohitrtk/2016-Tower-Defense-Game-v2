import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.util.ArrayList;

/**
 * Will be used to spawn a basic tower in to the game
 * 
 * @author Rohit Terry Kisto
 * @version 2016/9/30
 */
public class TowerButton extends GUI
{
    protected final int WIDTH = 30;                     // The width of the button
    protected final int HEIGHT = 30;                    // The height of the button
    
    protected World world;                              // The world this object belongs to
    protected Tower tempTower;                          // Temporary tower to spawn to before added to the array list of towers
    protected ArrayList<Tower> towers;                  // Array list of towers, each type of tower in the game will be stored by its relative button
    
    protected boolean isSelected;                       // Is the button selected?
    
    protected GreenfootImage costImage;
    protected Color colour;                           // Colour object for the background
    
    /**
     * Constructs a new tower button
     * @param World world
     * @param int x position
     * @param int y position
     */
    public TowerButton(World world, int x, int y)
    {
        super(world, x, y);
        this.world = world;
        
        towers = new ArrayList<Tower>();
        
        colour = new Color(0f, 0f, 0f ,0f);         // Transparent colour!
        
        if(!(this instanceof BlackTowerButton || this instanceof FireTowerButton ||
            this instanceof PsychoTowerButton || this instanceof WaterTowerButton))
        {
            new Money(this.world, this.x + 60, this.y, Tower.cost);
        }
        
		isSelected = true;

        world.addObject(this, x, y);
    }
    
    /**
     * Act - do whatever the TowerButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       super.act();
       MouseInfo mouse = Greenfoot.getMouseInfo();
       
       // If the mouse is doing something
       if(mouse != null)
       {
          if(world instanceof Map1)
          {
              
              if(Greenfoot.mouseClicked(this) && Map1.getMoney() >= Tower.cost)
              {
                  tempTower = new Tower(this.world, mouse.getX(), mouse.getY());
                  towers.add(tempTower);            // Add the temp tower to the array list of towers
                  Map1.setMoney(Map1.getMoney() - Tower.cost);
                }
          } else if(world instanceof Map2)
          {
              
              if(Greenfoot.mouseClicked(this) && Map2.getMoney() >= Tower.cost)
              {
                  tempTower = new Tower(this.world, mouse.getX(), mouse.getY());
                  towers.add(tempTower);            // Add the temp tower to the array list of towers
                  Map2.setMoney(Map2.getMoney() - Tower.cost);
              }
          } else if(world instanceof Map3)
          {
              
              if(Greenfoot.mouseClicked(this) && Map3.getMoney() >= Tower.cost)
              {
                  tempTower = new Tower(this.world, mouse.getX(), mouse.getY());
                  towers.add(tempTower);            // Add the temp tower to the array list of towers
                  Map3.setMoney(Map3.getMoney() - Tower.cost);
              }
          }

          // If the mouse is dragged on top of the temp tower that was just spawned
          if(tempTower == null) return;
          if(Greenfoot.mouseDragged(tempTower) && (towers != null) && tempTower.isPlaced == false)
          {
			  isSelected = false;
              //System.out.println(towers.size());
              if(towers.size() - 1 < 0) return;
              else towers.get(towers.size() - 1).setLocation(mouse.getX(), mouse.getY());
          }

	 	  if(Greenfoot.mouseDragEnded(tempTower) && !isSelected) 	
		  {
		  	 tempTower.isPlaced = true;
 		  }
       }
    }
    
    /**
     * Destroys this objects
     * @return void
     */
    protected void destroy()
    {
        this.world.removeObject(this);
    }
}
