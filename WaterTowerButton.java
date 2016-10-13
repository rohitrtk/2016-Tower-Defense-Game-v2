import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A tower the user can place down, this tower will shoot a bullet but may be more in accurate than the basic tower
 * 
 * @author Rohit Terry Kisto
 * @version 2016/9/30
 */
public class WaterTowerButton extends TowerButton
{
    /**
     * Constructs a new tower button
     * @param World world
     * @param int x position
     * @param int y position
     */
    public WaterTowerButton(World world, int x, int y)
    {
        super(world, x, y);
        
        new Money(this.world, this.x + 60, this.y, WaterTower.cost);
    }
    
    /**
     * Act - do whatever the TowerButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {       
        
       MouseInfo mouse = Greenfoot.getMouseInfo();
      
       // If the mouse is doing something
       if(mouse != null)
       {
          if(world instanceof Map1)
          {
              // If the mouse is clicked on top of the button, spawn a new tower
              if(Greenfoot.mouseClicked(this) && Map1.getMoney() >= WaterTower.cost)
              {
                  tempTower = new WaterTower(this.world, mouse.getX(), mouse.getY());
                  towers.add(tempTower);            // Add the temp tower to the array list of towers
                  Map1.setMoney(Map1.getMoney() - WaterTower.cost);
                }
          } else if(world instanceof Map2)
          {
              // If the mouse is clicked on top of the button, spawn a new tower
              if(Greenfoot.mouseClicked(this) && Map2.getMoney() >= WaterTower.cost)
              {
                  tempTower = new WaterTower(this.world, mouse.getX(), mouse.getY());
                  towers.add(tempTower);            // Add the temp tower to the array list of towers
                  Map2.setMoney(Map2.getMoney() - WaterTower.cost);
              }
          } else if(world instanceof Map3)
          {
              // If the mouse is clicked on top of the button, spawn a new tower
              if(Greenfoot.mouseClicked(this) && Map3.getMoney() >= WaterTower.cost)
              {
                  tempTower = new WaterTower(this.world, mouse.getX(), mouse.getY());
                  towers.add(tempTower);            // Add the temp tower to the array list of towers
                  Map3.setMoney(Map3.getMoney() - WaterTower.cost);
              }
          }
          
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
}
