import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A tower the user can place down, this tower will shoot a powerful bullet but has the chance to go 'out' upon launch
 * 
 * @author Rohit Terry Kisto
 * @version 2016/9/30
 */
public class FireTowerButton extends TowerButton
{
    /**
     * Constructs a new fire tower button
     * @param World world
     * @param int x position
     * @param int y position
     */
    public FireTowerButton(World world, int x, int y)
    {
        super(world, x, y);
        
        new Money(this.world, this.x + 68, this.y, FireTower.cost);
    }
    
    /**
     * Act - do whatever the TowerButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       
       MouseInfo mouse = Greenfoot.getMouseInfo();
      
       if(mouse != null)
       {
          if(world instanceof Map1)
          {
              
              if(Greenfoot.mouseClicked(this) && Map1.getMoney() >= FireTower.cost)
              {
                  tempTower = new FireTower(this.world, mouse.getX(), mouse.getY());
                  towers.add(tempTower);            // Add the temp tower to the array list of towers
                  Map1.setMoney(Map1.getMoney() - FireTower.cost);
                }
          } else if(world instanceof Map2)
          {
              
              if(Greenfoot.mouseClicked(this) && Map2.getMoney() >= FireTower.cost)
              {
                  tempTower = new FireTower(this.world, mouse.getX(), mouse.getY());
                  towers.add(tempTower);            // Add the temp tower to the array list of towers
                  Map2.setMoney(Map2.getMoney() - FireTower.cost);
              }
          } else if(world instanceof Map3)
          {
              
              if(Greenfoot.mouseClicked(this) && Map3.getMoney() >= FireTower.cost)
              {
                  tempTower = new FireTower(this.world, mouse.getX(), mouse.getY());
                  towers.add(tempTower);            // Add the temp tower to the array list of towers
                  Map3.setMoney(Map3.getMoney() - FireTower.cost);
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
