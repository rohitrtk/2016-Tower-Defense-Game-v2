import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This tower will shoot a bullet but may be more in accurate than the basic tower
 * 
 * @author Rohit Terry Kisto
 * @version 2016/9/30
 */
public class WaterTower extends Tower
{
    public static final int cost = 300;                   // The cost for the tower
    
    private String[] imagePaths = 
    {
        "water_tower.png",
        "water_tower_1.png",
        "water_tower_2.png",
        "water_tower_3.png"
    };
    
     /**
     * Constructs a Tower
     * @param World world
     * @param int x position
     * @param int y position
     * @Override
     */
    public WaterTower(World world, int x, int y)
    {
        super(world, x, y);
        
        cooldownTime = 62;
        range = 150;                                                            
        world.addObject(this, x, y);                                  // Add this to object to the world
        isAbleToShoot = true;                                         // This tower can shoot right now
        timer = 0;                 
        isDestroyed = false;
        
        for(int i = 0;i < images.length;i++)
        {
            images[i] = new GreenfootImage(imagePaths[i]);
        }
    }
    
    /**
     * Act - do whatever the FireTower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
    }     
}
