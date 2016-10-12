import greenfoot.*; 
import java.util.List;
import java.util.Collections;

/**
 * This class will be the basic tower of the game and will be extended upon for all towers in the game
 * 
 * @author Rohit Terry Kisto 
 * @version 2016/9/19
 */
public class Tower extends Actor
{
    protected World world;                // The world the tower belongs to
    protected int x;                      // The towers x position
    protected int y;                      // The towers y position
    protected int timer;                  // Time between shots (TIMER GOES UP BY 2'S?)
    protected float range;                // How far the tower can shoot
    protected float cooldownTime;         // The cooldown time in seconds between each shot (Mutiply original time by 36 until FPS is established)
    protected String imagePath;           // Image path
    protected boolean isAbleToShoot;      // Is the tower able to shoot right now
    protected boolean isPlaced;
    protected boolean isDestroyed;
    protected static int level;
    protected GreenfootImage[] images;
    private String[] imagePaths = 
    {
        "arcane_tower.png",
        "arcane_tower_0.png",
        "arcane_tower_1.png",
        "arcane_tower_2.png"
    };
    
    protected final GreenfootSound fireSound = new GreenfootSound("fire.wav");
    
    public static final int cost = 100;                   // The cost for the tower
    
    /**
     * Constructs a Tower, used as a test object for scene
     * @param int x position
     * @param int y position
     */
    public Tower(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.isPlaced = true;
        
        level = 1;
        cooldownTime = 72;
        range = 100;                                                            // 'Default' range for tower, will be overriden
        isAbleToShoot = true;
        timer = 0;
        isDestroyed = false;
        //fireSound.setVolume(50);
        world.setActOrder(GUI.class, Tile.class, Waypoint.class, Tower.class, Bloodstain.class, 
            AbstEnemy.class, Bullet.class);
    }
    
    /**
     * Constructs a Tower
     * @param World world
     * @param int x position
     * @param int y position
     * @Override
     */
    public Tower(World world, int x, int y)
    {
        this.world = world;
        this.x = x;
        this.y = y;
        this.isPlaced = true;

        images = new GreenfootImage[4];
        if(!(this instanceof FireTower || this instanceof WaterTower || this instanceof
            BlackTower || this instanceof PsychoTower))
        {
            for(int i = 0;i < images.length;i++)
            {
                images[i] = new GreenfootImage(imagePaths[i]);
            }
        }
        
        level = 1;
        cooldownTime = 72;
        range = 150;                                                            // 'Default' range for tower, will be overriden
        world.addObject(this, x, y);                                  // Add this to object to the world
        isAbleToShoot = true;                                                   // This tower can shoot right now
        timer = 0;                 
        isDestroyed = false;
        //fireSound.setVolume(100);
        world.setActOrder(GUI.class, Tile.class, Waypoint.class, Tower.class, Bloodstain.class, 
            AbstEnemy.class, Bullet.class);
    }
    
    /**
     * Act - do whatever the Tower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //HERE
        
        if(level == 1) setImage(images[0]);
        else if(level == 2) setImage(images[1]);
        else if(level == 3) setImage(images[2]);
        else if(level == 4) setImage(images[3]);
        
        MouseInfo mouse = Greenfoot.getMouseInfo();
        
        if(mouse != null)
        {
            if(Greenfoot.mousePressed(this))
            {
                if(mouse.getButton() == 3)
                {
                    this.destroy();
                    if(world instanceof Map1)
                    {
                        if(this instanceof WaterTower) Map1.setMoney(Map1.getMoney() + WaterTower.cost);
                        else if(this instanceof FireTower) Map1.setMoney(Map1.getMoney() + FireTower.cost);
                        else if(this instanceof BlackTower) Map1.setMoney(Map1.getMoney() + BlackTower.cost);
                        else if(this instanceof PsychoTower) Map1.setMoney(Map1.getMoney() + PsychoTower.cost);
                        else Map1.setMoney(Map1.getMoney() + cost);
                    }else if(world instanceof Map2)
                    {
                        if(this instanceof WaterTower) Map2.setMoney(Map2.getMoney() + WaterTower.cost);
                        else if(this instanceof FireTower) Map2.setMoney(Map2.getMoney() + FireTower.cost);
                        else if(this instanceof BlackTower) Map2.setMoney(Map2.getMoney() + BlackTower.cost);
                        else if(this instanceof PsychoTower) Map2.setMoney(Map2.getMoney() + PsychoTower.cost);
                        else Map2.setMoney(Map2.getMoney() + cost);
                    } else if(world instanceof Map3)
                    {
                        if(this instanceof WaterTower) Map3.setMoney(Map3.getMoney() + WaterTower.cost);
                        else if(this instanceof FireTower) Map3.setMoney(Map3.getMoney() + FireTower.cost);
                        else if(this instanceof BlackTower) Map3.setMoney(Map3.getMoney() + BlackTower.cost);
                        else if(this instanceof PsychoTower) Map3.setMoney(Map3.getMoney() + PsychoTower.cost);
                        else Map3.setMoney(Map3.getMoney() + cost);
                    }
                    return;
                } else if(UpgradeButton.selected && level < 4) {
                    if(world instanceof Map1)
                    {
                        if(this instanceof WaterTower)
                        {
                            if(Map1.getMoney() >= WaterTower.cost * Tower.getLevel())
                            {
                                Map1.setMoney(Map1.getMoney() - WaterTower.cost * Tower.getLevel());
                            }
                        } else if(this instanceof FireTower) 
                        {
                            if(Map1.getMoney() >= FireTower.cost * Tower.getLevel())
                            {
                                Map1.setMoney(Map1.getMoney() - FireTower.cost * Tower.getLevel());
                            } 
                        } else if(this instanceof BlackTower)
                        {
                            if(Map1.getMoney() >= BlackTower.cost * Tower.getLevel())
                            {
                                Map1.setMoney(Map1.getMoney() - BlackTower.cost * Tower.getLevel());
                            }
                        } else if(this instanceof PsychoTower)
                        {
                            if(Map1.getMoney() >= PsychoTower.cost * Tower.getLevel())
                            {
                                Map1.setMoney(Map1.getMoney() - PsychoTower.cost * Tower.getLevel())
                            }
                        }
                    } else if(world instanceof Map2)
                    {
                        if(this instanceof WaterTower)
                        {
                            if(Map2.getMoney() >= WaterTower.cost * Tower.getLevel())
                            {
                                Map2.setMoney(Map2.getMoney() - WaterTower.cost * Tower.getLevel());
                            }
                        } else if(this instanceof FireTower) 
                        {
                            if(Map2.getMoney() >= FireTower.cost * Tower.getLevel())
                            {
                                Map2.setMoney(Map2.getMoney() - FireTower.cost * Tower.getLevel());
                            } 
                        } else if(this instanceof BlackTower)
                        {
                            if(Map2.getMoney() >= BlackTower.cost * Tower.getLevel())
                            {
                                Map2.setMoney(Map2.getMoney() - BlackTower.cost * Tower.getLevel());
                            }
                        } else if(this instanceof PsychoTower)
                        {
                            if(Map2.getMoney() >= PsychoTower.cost * Tower.getLevel())
                            {
                                .setMoney(Map1.getMoney() - PsychoTower.cost * Tower.getLevel())
                            }
                        }
                    } else if(world instanceof Map3)
                    {
                    }
                    
                    level++;
                    System.out.println("level up!");
                }
            }
        }
        
        if(isPlaced)
        {
            // Shooting algorithm
            if(isAbleToShoot)                                                       // If this tower can shoot...
            {
                findTarget();
            } 
            else
            {
                timer++;                                                            // Add one to cooldown time
                if(timer % cooldownTime == 0)                                       // If cooldown time is done...
                {
                    isAbleToShoot = true;                                           // Tower can shoot again
                    timer = 0;                                                      // Reset timer
                    //System.out.println(timer);
                }
            }
        }
        
        if(isDestroyed) 
        {
            destroy();
        }
    }   
    
    /**
     * Sets whether or not this tower has been placed
     * @param boolean isPlaced
     * @return void
     */
    public void setIsPlaced(boolean isPlaced)
    {
        this.isPlaced = isPlaced;
    }
    
    /**
     * Gets whether or not this tower has been placed
     * @return boolean isPlaced
     */
    public boolean getIsPlaced()
    {
        return isPlaced;
    }
    
    /**
     * Sets whether or not this tower has been destroyed
     * @param boolean isDestroyed
     * @return void
     */
    public void setDestroyed(boolean isDestroyed)
    {
        this.isDestroyed = isDestroyed;
    }
    
    /**
     * Gets whether or not this tower has been destroyed
     * @return boolean isDestroyed
     */
    public boolean getDestroyed()
    {
        return isDestroyed;
    }
    
    /**
     * Destroys this object
     * @return void
     */
    private void destroy()
    {
        world.removeObject(this);
    }
    
    /**
     * This method finds the closest target to this tower and fires a bullet at it
     * @return void
     */
    protected void findTarget()
    {
        List<Actor> list = getObjectsInRange((int)range, Actor.class);                              // List of all objects within range
        Collections.reverse(list);                                                                  // Reverse the list so it acts like a 'shoot first object' tower
        
        // If there is an enemy in the list of objects in range, fire at it
        int i = 0;                                                                                  // Counter for enhanced for loop
        for(Actor a : list)
        {
            if(a instanceof Enemy)                                                                  // If instance of enemy...
            {   
                if(this instanceof WaterTower)
                {
                    new WaterBullet(world, getX(), getY() - 20, list.get(i).getX(), list.get(i).getY());
                } else if(this instanceof FireTower) {
                    new FireBullet(world, getX(), getY() - 20, list.get(i).getX(), list.get(i).getY());
                } else if(this instanceof BlackTower) {
                    new BlackBullet(world, getX(), getY() - 20, list.get(i).getX(), list.get(i).getY());
                } else if(this instanceof PsychoTower) {
                    new PsychoBullet(world, getX(), getY() - 20, list.get(i).getX(), list.get(i).getY());
                } else {
                    new Bullet(world, getX(), getY() - 20, list.get(i).getX(), list.get(i).getY());
                }
                //fireSound.play();
                Greenfoot.playSound("fire.wav");        
                isAbleToShoot = false;                                                              // Tower can't shoot
                return;                                                                             // Stop any more code in this method from running
            }
            i++;                                                                                    // Add one to counter
        }
    }
    
    public static int getLevel()
    {
        return Tower.level;
    }
}
