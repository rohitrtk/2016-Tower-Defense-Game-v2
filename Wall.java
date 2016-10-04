import greenfoot.*;  

/**
 * Tile of type 'Wall', towers CAN be placed on this tile
 * 
 * @author Rohit Terry Kisto 
 * @version 2016/9/19
 */
public class Wall extends Tile
{    
    /**
     * Constructor for Wall, used as a test object for the scene 
     * @param int x position
     * @param int y position
     */
    public Wall(int x, int y)
    {
        super(x, y);
        this.x = x;
        this.y = y;
        
        setImage("png_files/wall.png");
    }
    
    /**
     * Constructor for Wall 
     * @param World world
     * @param int x position
     * @param int y position
     */
    public Wall(World world, int x, int y)
    {
        super(world, x, y);
        this.world = world;
        this.x = x;
        this.y = y;
    }
    
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
    }    
}
