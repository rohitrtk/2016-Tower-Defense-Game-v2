import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class will be a button so the user can press this to start the round
 * 
 * @author Rohit Terry Kisto
 * @version 2016/9/30
 */
public class PlayButton extends GUI
{
    private final int WIDTH = 120;                      // The width of the play button
    private final int HEIGHT = 40;                      // The height of the play button
    
    private boolean isPlaying;                          // Are enemies spawning right now?
    
    private boolean pause;
    
    private String imagePathDis = "playbutton_disabled.png";    // The current image to display
    /**
     * Constructs a new PlayButton where the user can press it to play the game
     * @param World world
     * @param int x position
     * @param int y position
     * @param boolean isPlaying
     */
    public PlayButton(World world, int x, int y, boolean isPlaying)
    {
        super(world, x, y);
        
        this.isPlaying = isPlaying;
        
        imagePath = "playbutton.png";
        setImage(imagePath);
        
        world.addObject(this, x, y);
    }
    
    /**
     * Act - do whatever the PlayButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(world instanceof Map1) this.pause = Map1.pause;
        else if(world instanceof Map2) this.pause = Map2.pause;
        else if(world instanceof Map3) this.pause = Map3.pause;
        
        if(!pause)
        {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            super.act();
            // If the mouse is clicked and within the button bounds
            if(mouse != null && Greenfoot.mousePressed(this))
            {
                if((mouse.getX() > (x - WIDTH/2)) && mouse.getX() < (x + WIDTH/2) &&
                (mouse.getY() > (y - HEIGHT/2)) && (mouse.getY() < (y + HEIGHT/2)))
                {
                    if(isPlaying) return;       // If isPlaying, do nothing
                    isPlaying = true;
                    setImage(imagePathDis);
                }
            }
        }
    } 
    
    /**
     * Sets the boolean isPlaying to parameter and based on that parameter, change the image displayed
     * @param boolean isPlaying
     * @reutrn void
     */
    public void setIsPlaying(boolean isPlaying)
    {
        this.isPlaying = isPlaying;
        if(!isPlaying) setImage(imagePath);
    }
    
    /**
     * Gets the boolean isPlaying
     * @return boolean isPlaying
     */
    public boolean getIsPlaying()
    {
        return isPlaying;
    }
    
    
}
