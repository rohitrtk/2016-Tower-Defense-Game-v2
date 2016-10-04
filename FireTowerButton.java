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
     * Constructs a new tower button
     * @param World world
     * @param int x position
     * @param int y position
     */
    public FireTowerButton(World world, int x, int y)
    {
        super(world, x, y);
        
        new Money(this.world, this.x + 60, this.y, FireTower.cost);
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
          // If the mouse is doing something
          if(Greenfoot.mouseClicked(this) && Map1.getMoney() >= FireTower.cost)
          {
              // If the mouse is clicked on top of the button, spawn a new tower
              tempTower = new FireTower(this.world, mouse.getX(), mouse.getY());
              towers.add(tempTower);
              Map1.setMoney(Map1.getMoney() - FireTower.cost);
          }
          
          if(Greenfoot.mouseDragged(tempTower) && (towers != null))
          {
              // If the mouse is dragged on top of the temp tower that was just spawned
              //System.out.println(towers.size());
              if(towers.size() - 1 < 0) return;
              else towers.get(towers.size() - 1).setLocation(mouse.getX(), mouse.getY());
            }
       }
    } 
}
