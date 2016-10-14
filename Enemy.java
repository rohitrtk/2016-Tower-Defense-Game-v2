import greenfoot.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class will be extended upon for all enemies in the game.
 * 
 * @author Rohit Terry Kisto
 * @version 13/10/2016
 */
public class Enemy extends AbstEnemy
{
    protected World world;                                  // The world this object belongs to
    protected int x;                                        // x position of this objcet
    protected int y;                                        // y position of this object
    protected int currentWaypoint;                          // The current waypoint this object is looking towards
    protected int moveSpeed;                                // Movement speed of this object
    protected int hp = 160;                                 // Default hit points of this object
    protected int damage = 1;                               // Damage dealt to player if this object reaches the end
    protected final GreenfootSound death = new GreenfootSound("ratdead.wav");   // Death sound for all enemies
    protected EnemyLabel thisLabel;                         // Enemylabel to display health to user
    
    protected static ArrayList<Waypoint> waypoints;         // Array of waypoints the enemy will access
    
    protected List<Actor> touching;                         // List of objects this enemy is touching                          
    
    /**
     * Constructor for Enemy
     * @param World world
     * @param int x position
     * @param int y position
     */
    public Enemy(World world, int x, int y)
    {
        this.world = world;
        this.x = x;
        this.y = y;
        
        //currentWaypoint = 0;
        if(world instanceof Map1) waypoints = Map1.getWaypoints();
        else if(world instanceof Map2) waypoints = Map2.waypoints;
        else if(world instanceof Map3) waypoints = Map3.waypoints;
        
        world.addObject(this, x, y);                                               
        turnTowards(waypoints.get(currentWaypoint+1).getX(), waypoints.get(currentWaypoint+1).getY());
        
        moveSpeed = 1;
        death.setVolume(100);
        
        thisLabel = new EnemyLabel(this.world, getX(), getY(), hp);
    }
    
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * @return void
     */
     public void act() 
     {
        touching = getIntersectingObjects(Actor.class);
      
        move(moveSpeed);
        x = getX();
        y = getY();
        
        thisLabel.setHp(hp);
        thisLabel.setLocation(x, y);
        
        // For each actor this enemy is touching
        int i = 0;
        for(Actor a : touching)
        {          
            // If touching a waypoint, turn to next waypoint
            
            if(x == (waypoints.get(currentWaypoint+1).getX()) &&
                y == waypoints.get(currentWaypoint+1).getY())
            {
                currentWaypoint++;
                if(currentWaypoint >= waypoints.size() - 1) return;
                turnTowards(waypoints.get(currentWaypoint+1).getX(), waypoints.get(currentWaypoint+1).getY());
            }
            
            // If touching a bullet, subtract hp by bullet damage and destroy the bullet
            if(a instanceof Bullet) {
                Bullet bullet = (Bullet)touching.get(i);              
                
                hp -= bullet.getBulletDamage();
                bullet.destroy();
            }
            i++;
        }
        
        // If hp is less than 1 or is at the end of the course, destroy this object
        if(hp < 1)
        {
            if(this instanceof Satan) 
            {
                EasterEggHandler.killedSatan = true;
            }
            destroy();
            Greenfoot.playSound("ratdead.wav");
            thisLabel.destroy();
            //death.play();

            } else if (((isAtEdge()) && currentWaypoint < waypoints.size()) || currentWaypoint == waypoints.size() ||
            ( world instanceof Map3 && x >= 599)){
            if(this instanceof Satan)
            {
                System.exit(0);
            }
            destroy();
            if(world instanceof Map1) Map1.setHp(Map1.getHp() - damage);
            else if(world instanceof Map2) Map2.setHp(Map2.getHp() - damage);
            else if(world instanceof Map3) Map3.setHp(Map3.getHp() - damage);
            thisLabel.destroy();
        } else if(isTouching(Castle.class))
        {
            if(this instanceof Satan)
            {
                System.exit(0);
            }
            if(world instanceof Map1) Map1.setHp(Map1.getHp() - damage);
            else if(world instanceof Map2) Map2.setHp(Map2.getHp() - damage);
            else if(world instanceof Map3) Map3.setHp(Map3.getHp() - damage);
            world.removeObject(this);
            thisLabel.destroy();
        }
    }    
    
    
    /**
     * This method will remove the enemy from the scene
     * @return void
     */
    public void destroy()
    {
        //System.out.println("IM DEAD");
        world.addObject(new Bloodstain(this.world, getX(), getY()), getX(), getY());
        world.addObject(new LootDrop(this.world, getX(), getY()), getX(), getY());
        world.removeObject(this);                                                   // Destroy this object
    }
    
    /**
     * This method will move the enemy based on user input with arrow keys,
     * primarily used for testing range of towers
     * @return void
     */
    private void moveEnemyWithArrowKeys()
    {
        if(Greenfoot.isKeyDown("left"))
       {
           x-=5;
       }
       
       if(Greenfoot.isKeyDown("right"))
       {
           x+=5;
       }
       
       if(Greenfoot.isKeyDown("up"))
       {
           y-=5;
       }
       
       if(Greenfoot.isKeyDown("down"))
       {
           y+=5;
       }
    }
    
    /**
     * This method sets the move speed of an enemy
     * @param int moveSpeed
     */
    protected void setMoveSpeed(int moveSpeed) 
    {
        this.moveSpeed = moveSpeed;
    }
    
    /**
     * This method returns the move speed of an enemy
     * @return int moveSpeed
     */
    protected int getMoveSpeed()
    {
        return moveSpeed;
    }
    
    //Misc function that aren'y really used 
    public void takeDamage()
    {
    }
    
    public boolean checkHit()
    {
        return false;
    }
    
    protected void setWaypoint(int i)
    {
        this.currentWaypoint = currentWaypoint;
    }
    
    protected int getWaypoint()
    {
        return currentWaypoint;
    }
}
