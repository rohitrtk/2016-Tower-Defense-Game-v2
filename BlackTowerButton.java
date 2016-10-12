import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A tower the user can place down, this tower will shoot a slow black bullet that deals a ton of damage
 * 
 * @author Rohit Terry Kisto
 * @version 2016/9/30
 */
public class BlackTowerButton extends TowerButton
{
    /**
     * Constructs a new black tower button
     * @param World world
     * @param int x position
     * @param int y position
     */
    public BlackTowerButton(World world, int x, int y)
    {
        super(world, x, y);
        
        new Money(this.world, this.x + 67, this.y, BlackTower.cost);
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
              // If the mouse is clicked on top of the button, spawn a new tower
              if(Greenfoot.mouseClicked(this) && Map1.getMoney() >= BlackTower.cost)
              {
                  tempTower = new BlackTower(this.world, mouse.getX(), mouse.getY());
                  towers.add(tempTower);            // Add the temp tower to the array list of towers
                  Map1.setMoney(Map1.getMoney() - BlackTower.cost);
                }
          } else if(world instanceof Map2)
          {
              // If the mouse is clicked on top of the button, spawn a new tower
              if(Greenfoot.mouseClicked(this) && Map2.getMoney() >= BlackTower.cost)
              {
                  tempTower = new BlackTower(this.world, mouse.getX(), mouse.getY());
                  towers.add(tempTower);            // Add the temp tower to the array list of towers
                  Map2.setMoney(Map2.getMoney() - BlackTower.cost);
              }
          } else if(world instanceof Map3)
          {
              // If the mouse is clicked on top of the button, spawn a new tower
              if(Greenfoot.mouseClicked(this) && Map3.getMoney() >= BlackTower.cost)
              {
                  tempTower = new BlackTower(this.world, mouse.getX(), mouse.getY());
                  towers.add(tempTower);            // Add the temp tower to the array list of towers
                  Map3.setMoney(Map3.getMoney() - BlackTower.cost);
              }
          }
          // If the mouse is dragged on top of the temp tower that was just spawned
          if(Greenfoot.mouseDragged(tempTower) && (towers != null))
          {
              if(towers.size() - 1 < 0) return;
              else towers.get(towers.size() - 1).setLocation(mouse.getX(), mouse.getY());
            }
       }
    }
}
