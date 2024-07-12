import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The main world, which spawns the player and periodically spawns enemies.
 * 
 * @author Ryan 
 * @version 1.1
 */
public class MyWorld extends World
{
    private static final int ENEMIES_PER_LEVEL = 5;
    private static final int MAX_SPEED = 35;
    private static final int ENDLESS_SPEED = 57; // speed for endless mode
    private int currentLevel;
    private int nextEnemy;
    private int spawnTimer;
    private int spawnSpeed;
    private boolean endless;


    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 650, 1); 
        currentLevel = 0;
        spawnTimer = 50; //initial enemy delay
        spawnSpeed = 150;
        nextEnemy = 0;
        Ground g = new Ground(getWidth());
        addObject(g, getWidth()/2, getHeight()-g.getImage().getHeight()/2);
        Player p = new Player();
        addObject(p, getWidth()/2, getHeight()-g.getImage().getHeight()-p.getImage().getHeight()/2);
        HealthBar h = new HealthBar(p);
        addObject(h, getWidth()/2, g.getY());
        PowerUp pu = new PowerUp();
        addObject(pu, getWidth()/2, getHeight()/2);
        endless = false;
    }
    
    public MyWorld(boolean isEndless){
        this();
        if(isEndless){
            spawnSpeed = ENDLESS_SPEED;
            endless = isEndless;
        }
    }
    
    public void act(){
        if(getObjects(Player.class).size() == 0){
            return;
        }
        if(endless){
            endlessEnemies();
        }
        else{
            spawnEnemies();
        }
    }
    
    private void endlessEnemies(){
        spawnTimer--;
        if(spawnTimer <= 0){
            spawnEnemy(Greenfoot.getRandomNumber(3)+1);
            nextEnemy++;
            spawnTimer = spawnSpeed;
        }
    }
    
    private void spawnEnemies(){
        if(spawnSpeed <= MAX_SPEED){
            java.util.List enemies = getObjects(Enemy.class);
            if(enemies.size() <= 0){
                showText("You win", getWidth()/2, getHeight()/2);
            }
            return;
        }
        spawnTimer--;
        if(spawnTimer <= 0){
            spawnEnemy(Greenfoot.getRandomNumber(3)+1);
            nextEnemy++;
            if(nextEnemy%ENEMIES_PER_LEVEL == 0){
                spawnSpeed *= 0.9;
            }
            spawnTimer = spawnSpeed;
        }
    }
    
    /**
     * Method spawnEnemy
     *
     * @param type 1 for Joe(long range), 2 for John(fast), 3 for Matt(tank)
     */
    private void spawnEnemy(int type){
        Enemy e;
        switch(type){
            default:
            case 1:
                e = new Joe();
                break;
            case 2:
                e = new John();
                break;
            case 3:
                e = new Matt();
                break;
        }
        
        int x;
        if(Greenfoot.getRandomNumber(2) == 1){
            x = getWidth();
        }
        else{
            x = 0;
        }
        
        int y;
        java.util.List<Ground> g = getObjects(Ground.class);
        if(g.size() != 0){
            y = g.get(0).getY() -g.get(0).getImage().getHeight()/2 -
                e.getImage().getHeight()/2;
        }
        else{
            y = getHeight()/2;
        }
        addObject(e,x,y);
    }
}
