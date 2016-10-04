import greenfoot.*;

/**
 * This class will store an x position and y position, the map the scene is on will have an arraylist of waypoints,
 * each enemy will have to move towards a waypoint to get to the other side of the map.
 * 
 * @author Rohit Terry Kisto
 * @version 2016/9/19
 */

public class Waypoint extends Actor
{
    private World world;
    private int x;
    private int y;
    private final String imagePath = "waypoint.png";
    
    /**
     * Constructs a Waypoint
     * @param World world
     * @param int x position
     * @param int y position
     */
    public Waypoint(World world, int x, int y)
    {
        this.world = world;
        this.x = x;
        this.y = y;
        setImage(imagePath);
        world.addObject(this, getX(), getY());
    }

    /**
     * This method returns the x position of the waypoint
     * @param int x position
     * @return void 
     */
    public void setX(int x)
    {
        this.x = x;
    }
    
    /**
     * This method returns the x position of the waypoint
     * @return x position
     */
    public int getX()
    {
        return x;
    }
    
    /**
     * This method returns the x position of the waypoint
     * @param int y position
     * @return void
     */
    public void setY(int y)
    {
        this.y = y;
    }
    
    /**
     * This method returns the x position of the waypoint
     * @return void
     */
    public int getY()
    {
        return y;
    }
}
