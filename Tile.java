import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class will be extended upon for all 'Tiles' in the game
 * Override the act method!
 * 
 * @author Rohit Terry Kisto 
 * @version 2016/9/30
 */
public class Tile extends Actor
{
    protected World world;          // World this tile belonds to
    protected int x;                // x position of the tile
    protected int y;                // y position of the tile
    
    /**
     * Constructs a Tile, used as a test object in the world
     * @param int x position
     * @param int y position
     */
    public Tile(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Constructs a Tile
     * @param World world
     * @param int x position
     * @param int y position
     */
    public Tile(World world, int x, int y)
    {
        this.world = world;
        this.x = x;
        this.y = y;
        
        world.addObject(this, getX(), getY());
    }
  
    /**
     * Act - do whatever the Tile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * @Override
     */
    public void act() 
    {
        
    }   
    
    /**
     * This method sets the x postion of a Tile
     * @param int x
     * @return void
     */
    public void setX(int x)
    {
        this.x = x;
    }
    
    /**
     * This method returns the x position of a Tile
     * @return int x position
     */
    public int getX()
    {
        return x;
    }
    
    /**
     * This method sets the y position of a Tile
     * @param int y position
     * @return void
     */
    public void setY(int y)
    {
        this.y = y;
    }
    
    /**
     * This method returns the y position of a Tile
     * @return void
     */
    public int getY()
    {
        return y;
    }
}
