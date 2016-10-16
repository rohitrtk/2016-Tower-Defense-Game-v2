import greenfoot.*; 
import java.util.ArrayList;
import java.awt.Color;

/**
 * This class displays map #1, for whatever reason greenfoot launches this class first so
 * a new titlescreen is called from this class
 * 
 * @author Rohit Terry Kisto
 * @version 13/10/2016
 */
public class Map1 extends World
{    
    private Tile tiles[][];                             // 2D array of tiles, will be used to draw tiles on to the screen
    private static ArrayList<Waypoint> waypoints;       // Array list of waypoints, enemies will move towards waypoints
    
    private int round;                                  // The current round the player is on
    private ArrayList<Enemy> enemies;                   // Array list of enemies currently in round
    
    private int enemNumber;                             // The max number of enemies in the round        
    private int timer;                                  // Timer for enemies spawning
    private boolean spawn;                              // Can the enemies spawn?
    private int chance;
    private boolean stop;
    private boolean challenge;
    public static boolean restart;
    public static boolean pause;
    
    private boolean spawnEgg;                           // Can the easter egg spawn?
    private EasterEgg map1eg;                           // Map 1's easter egg
    
    private static int money;
    private static int hp;                              // The players hp
    
    private Backdrop backDrop;
    private Round roundGUI;                             // Round counter
    private PlayButton playButton;                      // Play button 
    private TowerButton[] towerButtons;                 // Tower Buttons
    private HP hpGUI;
    private Money moneyGUI;
    private UpgradeButton upgradeButton;
    
    private Button backButton;
    
    private boolean win;
    private boolean loss;
    
    private Castle castle;
    
    private GreenfootSound bgm;
    // IF YOU WANT TO TURN THE BGM ON OR OFF, CHANGE THE BOOLEAN BELOW!
    //private boolean mute = true;
    private boolean mute = false;
    
    private boolean menu = true;
    
    /**
     * This method constructs Map1 and initializes the world, the tiles on the world
     * the arraylist of waypoints and any enemies/towers
     */
    public Map1()
    {    
        // Create a new world with 780, 540 cells with a cell size of 1x1 pixels.
        // Cell width is 60 pixels each
        super(840, 540, 1); 
        
        // Background music mute option
        bgm = new GreenfootSound("bgm.mp3");
        if(!mute) bgm.playLoop();
        
        if(menu)
        {
            TitleScreen.firstLaunch = false;
            menu = false;
            Greenfoot.setWorld(new TitleScreen(this));
        }

        // Init variables
        restart = false;
        pause = false;
        chance = 1;
        stop = false;
        enemies = new ArrayList<Enemy>();
        enemNumber = 0;
        win = false;
        loss = false;
        round = 0;
        hp = 100;
        money = 100;
        timer = 0;
        spawn = true;
        spawnEgg = true;
        challenge = false;
        
        guiHandler();                                   // Loads up the GUI on the right side of the screen
        
        tiles = new Tile[10][14];                       // Sets width and height of tile map
        for(int i = 0;i < 10;i++)                       // Draws either a wall or dirt tile depending on its index number
        {
            for(int j = 0;j < tiles[i].length;j++)
            {
                if(((i == 0 || i == 1 || i == 2) && (j == 1)) || ((i == 2) && (j > 1 && j < 11)) ||
                (i == 3 || i == 4 || i == 5 || i == 5) && (j == 10) || (i == 6) && (j > 1 && j < 11) ||
                (i == 6 || i == 7 || i == 8 || i == 9) && (j == 1))
                {
                    tiles[i][j] = new Dirt(this, j * 60, i * 60);
                } else if(j < 11) {
                    tiles[i][j] = new Wall(this, j * 60, i * 60);
                }
            }
        }
        
        waypoints = new ArrayList<Waypoint>();          // Waypoint array list
        for(int i = 0;i < 6;i++)
        {
            switch(i)
            {
                case 0:
                    waypoints.add(i, new Waypoint(this, 1 * 60, -2 * 60));
                    break;
                case 1:
                    waypoints.add(i, new Waypoint(this, 1 * 60, 2 * 60));
                    break;
                case 2:
                    waypoints.add(i, new Waypoint(this, 10 * 60, 2 * 60));
                    break;
                case 3:
                    waypoints.add(i, new Waypoint(this, 10 * 60, 6 * 60));
                    break;
                case 4:
                    waypoints.add(i, new Waypoint(this, 1 * 60, 6 * 60));
                    break;    
                case 5:
                    waypoints.add(i, new Waypoint(this, 1 * 60, 9 * 60));
                    break;
            }
        }
        
        castle = new Castle(this, 60, 540);
        if(EasterEggHandler.killedSatan) money = 1000000;
    }
    
    /**
     * This method constructs Map1 and initializes the world, the tiles on the world
     * the arraylist of waypoints and any enemies/towers
     */
    public Map1(boolean pass)
    {    
        // Create a new world with 780, 540 cells with a cell size of 1x1 pixels.
        // Cell width is 60 pixels each
        super(840, 540, 1); 
        
        // Background music mute option
        bgm = new GreenfootSound("bgm.mp3");
        if(!mute) bgm.playLoop();

        // Init variables
        restart = false;
        pause = false;
        chance = 1;
        stop = false;
        enemies = new ArrayList<Enemy>();
        enemNumber = 0;
        win = false;
        loss = false;
        round = 0;
        hp = 100;
        money = 100;
        timer = 0;
        spawn = true;
        spawnEgg = true;
        challenge = false;
        pause = false;
        
        guiHandler();                                   // Loads up the GUI on the right side of the screen
        
        tiles = new Tile[10][14];                       // Sets width and height of tile map
        for(int i = 0;i < 10;i++)                       // Draws either a wall or dirt tile depending on its index number
        {
            for(int j = 0;j < tiles[i].length;j++)
            {
                if(((i == 0 || i == 1 || i == 2) && (j == 1)) || ((i == 2) && (j > 1 && j < 11)) ||
                (i == 3 || i == 4 || i == 5 || i == 5) && (j == 10) || (i == 6) && (j > 1 && j < 11) ||
                (i == 6 || i == 7 || i == 8 || i == 9) && (j == 1))
                {
                    tiles[i][j] = new Dirt(this, j * 60, i * 60);
                } else if(j < 11) {
                    tiles[i][j] = new Wall(this, j * 60, i * 60);
                }
            }
        }
        
        waypoints = new ArrayList<Waypoint>();          // Waypoint array list
        for(int i = 0;i < 6;i++)
        {
            switch(i)
            {
                case 0:
                    waypoints.add(i, new Waypoint(this, 1 * 60, -2 * 60));
                    break;
                case 1:
                    waypoints.add(i, new Waypoint(this, 1 * 60, 2 * 60));
                    break;
                case 2:
                    waypoints.add(i, new Waypoint(this, 10 * 60, 2 * 60));
                    break;
                case 3:
                    waypoints.add(i, new Waypoint(this, 10 * 60, 6 * 60));
                    break;
                case 4:
                    waypoints.add(i, new Waypoint(this, 1 * 60, 6 * 60));
                    break;    
                case 5:
                    waypoints.add(i, new Waypoint(this, 1 * 60, 9 * 60));
                    break;
            }
        }
        
        castle = new Castle(this, 60, 540);
        if(EasterEggHandler.killedSatan) money = 1000000;
    }
    
    /**
     * This method is called when the Run button is pressed
     */
    public void act()
    {    
        String myKey = Greenfoot.getKey();
        
        if(myKey != null)
        {
            if("p".equals(myKey))
            {
                //System.out.println("PAUSED");
                if(!pause)  pause = true;
                else pause = false;
            } else if ("r".equals(myKey))
            {
                reset();
            } else if("escape".equals(myKey))
            {
                Greenfoot.setWorld(new TitleScreen());
            }
        }
            
        if(pause) return;
            
            //System.out.println(Map1.pause);
            if(EasterEggHandler.counter == 3)
            {
                EasterEggHandler.spawnSatan = true;
            }
        
            if(EasterEggHandler.spawnSatan)
            {
                enemies.add(new Satan(this, waypoints.get(0).getX(), waypoints.get(0).getY()));
            }
        
            if(round % 10 == 0)
            {
                if(!stop)
                {
                    chance++;
                    //System.out.println("Upped");
                    stop = true;
                    challenge = true;
                }
            } else {
                stop = false;
                challenge = false;
            }
                         
            if(win) Greenfoot.setWorld(new WinScreen());
        
            if(hp < 1) 
            {
                loss = true;
                Greenfoot.setWorld(new LossScreen());
            }
            spawnEnemy();
            roundGUI.setRound(round);
            hpGUI.setHp(hp);
            moneyGUI.setMoney(money);
        
    }
    
    /**
     * This method returns an arraylist of waypoints which will be used each enemy to determine where
     * they go
     * @return ArrayList<Waypoint> waypoints
     */
    public static ArrayList<Waypoint> getWaypoints()
    {
        return waypoints;
    }
    
    /**
     * This method sets the hp of the world, based on difficulty, the world will has an x amount of
     * hp
     * @param int hp
     * @return void
     */
    public static void setHp(int hp)
    {
        Map1.hp = hp;
    }
    
    /**
     * This method returns the hp of the world
     * @return int hp
     */
    public static int getHp()
    {
        return hp;
    }
    
    /**
     * This method sets the money of the player
     * @param int hp
     * @return void
     */
    public static void setMoney(int money)
    {
        Map1.money = money;
    }
    
    /**
     * This method returns the money of the player
     * @return int money
     */
    public static int getMoney()
    {
        return money;
    }
    
    /**
     * This method handles all of the gui for the map
     * @return void
     */
    private void guiHandler()
    {
        backDrop = new Backdrop(this, 12 * 60, 4 * 60);
        playButton = new PlayButton(this, 12 * 60 + 18, 8 * 60, false);
        roundGUI = new Round(this, 12 * 60, 20, round);
        hpGUI = new HP(this, 12 * 60, 400, hp);
        moneyGUI = new Money(this, 12 * 60, 300, money);
        upgradeButton = new UpgradeButton(this, 12 * 60, 350);
        
        towerButtons = new TowerButton[5];
        towerButtons[0] = new TowerButton(this, 12 * 60 - 30, 50);
        towerButtons[1] = new WaterTowerButton(this, 12 * 60 - 30, 90);
        towerButtons[2] = new FireTowerButton(this, 12 * 60 - 30, 130);
        towerButtons[3] = new BlackTowerButton(this, 12 * 60 - 30, 170);
        towerButtons[4] = new PsychoTowerButton(this, 12 * 60 - 30, 210);
    }

    /**
     * This method is responsible for spawning enenmies into the world
     * @return void
     */
    private void spawnEnemy()
    {
        //If the map isn't paused
        if(!pause)
        {
            if (enemies == null) return; 
        
            //Victory condition
            if(round > 50)
            {
                win = true;
            }
        
            if(spawn)
            {   
                // Challenege every 10 levels
                if(challenge)
                {
                    for(int i = 0;i < round / 10;i++)
                    {
                        enemies.add(new Rat5(this, waypoints.get(0).getX(), waypoints.get(0).getY()));
                    }
                    challenge = false;
            }
            
            if(enemNumber < (2 * round) + 3 && round != 0)
            {
               //System.out.println(chance);
               double random = Math.ceil(Math.random() * chance);
                  
               // Weird bug that causes an index out of bounds exception
               try 
               {
                   if(random == 1)
                   {
                       enemies.add(enemNumber, new Rat1(this, waypoints.get(0).getX(), waypoints.get(0).getY()));
                    } else if(random == 2)
                    {
                        enemies.add(enemNumber, new Rat2(this, waypoints.get(0).getX(), waypoints.get(0).getY()));
                    } else if(random == 3)
                    {
                        enemies.add(enemNumber, new Rat3(this, waypoints.get(0).getX(), waypoints.get(0).getY()));
                    } else if(random == 4)
                    {
                        enemies.add(enemNumber, new Rat4(this, waypoints.get(0).getX(), waypoints.get(0).getY()));
                    }
                    enemNumber++;
               } catch (IndexOutOfBoundsException iob)
               {
               }
               
               // If we can spawn the egg and the random number between 1 and 1000 is 5
               // Spawn the egg then make sure it cant spawn again
               if(spawnEgg && (int)(Math.ceil(Math.random() * 1000) + 1) == 5)
               {
                   map1eg = new EasterEgg(this, (int)(((Math.random() * 10) + 1) * 60), (int)((Math.random() * 10) + 1) * 60);
                   spawnEgg = false;
               }
            } else if(!enemies.isEmpty()){
               enemies.removeAll(enemies);
               playButton.setIsPlaying(false);
            } else if(playButton.getIsPlaying())
            {
               round++;
               enemNumber = 0;
            }
            spawn = false;
            timer = 0;
            } else {
               timer++;
               //if(round == 0) return;
               if(timer % 60 == 0)
               {  
                   spawn = true;
               }
            }
        }
    }
    
    /**
     * Resets the map to its starting state
     * @return void
     */
    private void reset()
    {
        Greenfoot.setWorld(new Map1(true));
    }
}