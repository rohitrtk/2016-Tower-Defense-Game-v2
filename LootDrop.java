import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Will be dropped when an enemy dies
 * 
 * @author Rohit Terry Kisto 
 * @version 2016/9/30
 */
public class LootDrop extends Bloodstain
{
    private final int[] lootWorths = new int[3];    // Amoumnt of money that can be dropped
    private final String[] paths = new String[3];   // The paths to each image 
    
    /**
     * Constructs a new Loot Drop object
     * @param World world
     * @param int x position
     * @param int y postiion
     */
    public LootDrop(World world, int x, int y)
    {
        super(world, x, y);                         
        lootWorths[0] = 50;
        lootWorths[1] = 100;
        lootWorths[2] = 500;
        paths[0] = "50g.png";
        paths[1] =  "100g.png";
        paths[2] = "500g.png";
        
        /*
         * There are random chances for varying loot drops
         * 75% for a 50 gold drop
         * 24% for a 100 gold drop
         * 1% for a 500 gold drop
         */
        double random = Math.ceil(Math.random() * 100);
        if(random == 0) 
        {
            setImage(paths[2]);
            if(world instanceof Map1)Map1.setMoney(Map1.getMoney() + lootWorths[2]);
            else if(world instanceof Map2) Map2.setMoney(Map2.getMoney() + lootWorths[2]);
        } else if(random > 0 && random < 26) 
        {
            setImage(paths[1]);
            if(world instanceof Map1) Map1.setMoney(Map1.getMoney() + lootWorths[1]);
            else if(world instanceof Map2) Map2.setMoney(Map2.getMoney() + lootWorths[1]);
        } else 
        {
            setImage(paths[0]);
            if(world instanceof Map1) Map1.setMoney(Map1.getMoney() + lootWorths[0]);
            else if(world instanceof Map2) Map2.setMoney(Map2.getMoney() + lootWorths[0]);
            
        }
    }
    
    /**
     * Act - do whatever the Bloodstain wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        timer++;
        if(timer > 100) destroy();
    }
    
    /**
     * Removes this object from the world
     * @return void
     */
    public void destroy()
    {
        super.destroy();
    }
}
