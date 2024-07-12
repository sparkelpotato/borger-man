    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Ranged Enemy
 * 
 * @author Ryan 
 * @version 1.1
 */
public class Joe extends Enemy
{
    private static final double BULLET_SPEED = 10;
    private static final int RELOAD_TIME = 50;
    private int counter = 0;
    
    public Joe(){
        speed = 3;
        damage = 2;
        health = 5;
    }
    
    public void act()
    {
        counter++;
        
        gravity();
        moveToPlayer();
        if(counter >= RELOAD_TIME){
            counter = 0;
            shoot();
        }
    }
    
    private void shoot(){
        java.util.List<Player> players = getWorld().getObjects(Player.class);
        if(players.size() == 0){
            return;
        }
        int dx = players.get(0).getX() - getX();
        int dy = players.get(0).getY() - getY();
        Jacob j = new Jacob(dx,dy,BULLET_SPEED);
        getWorld().addObject(j, getX(), getY());
    }
}
