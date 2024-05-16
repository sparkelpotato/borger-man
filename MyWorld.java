import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private static final int[] enemyOrder = {3,3,3,1,3,2,1,1,3,3,2,2,1,2,1,3,2};
    private static final int ENEMIES_PER_LEVEL = 5;
    private int currentLevel;
    private int nextEnemy;
    private int spawnTimer;
    private int spawnSpeed;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
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
        addObject(p, getWidth()/2, getHeight()/2);
        healthBar h = new healthBar(p);
        addObject(h, getWidth()/2, g.getY());
    }
    
    public void act(){
        //last enemy has already spawned
        
        if(nextEnemy >= enemyOrder.length){
            if(getObjects(Enemy.class).size() == 0){
                //win goes here
            }
            return;
        }
        spawnTimer--;
        if(spawnTimer <= 0){
            spawnEnemy(enemyOrder[nextEnemy]);
            nextEnemy++;
            if(nextEnemy%ENEMIES_PER_LEVEL == 0){
                spawnSpeed *= 5.0/6;
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
