import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Slow firing yet powerful tower
 *
 * @author Rohit Terry Kisto
 * @version 2016/9/30
 */
public class BlackTower extends Tower
{
    public static final int cost = 5000;                   // The cost for the tower
    
    private String[] imagePaths =                          // Array of strings which are the path to leveld up towers 
    {
        "blackhole_tower.png",
        "blackhole_tower_1.png",
        "blackhole_tower_2.png",
        "blackhole_tower_3.png"
    };
    
     /**
     * Constructs a Tower
     * @param World world
     * @param int x position
     * @param int y position
     * @Override
     */
    public BlackTower(World world, int x, int y)
    {
        super(world, x, y);
        
        cooldownTime = 256;
        range = 350;                                                            // 'Default' range for tower, will be overriden
        world.addObject(this, x, y);                                  // Add this to object to the world
        isAbleToShoot = true;                                                   // This tower can shoot right now
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
