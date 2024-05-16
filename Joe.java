import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Joe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Joe extends Enemy
{
    private static final double BULLET_SPEED = 10;
    private static final int RELOAD_TIME = 50;
    private int counter = 0;
    
    public Joe(){
        speed = 3;
        damage = 2;
    }
    
    /**
     * Act - do whatever the Joe wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        counter++;
        
        gravity();
        moveToPlayer();
        if(counter >= RELOAD_TIME){
            counter = 0;
            shoot();
        }
        //checkAttack();
    }
    
    private void shoot(){
        java.util.List<Player> players = getWorld().getObjects(Player.class);
        if(players.size() == 0){
            return;
        }
        int x = players.get(0).getX() - getX();
        int y = players.get(0).getY() - getY();
        Jacob j = new Jacob(x,y,BULLET_SPEED);
        getWorld().addObject(j, getX(), getY());
    }
}
