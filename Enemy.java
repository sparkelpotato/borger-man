import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    private final double gravity = 0.5;
    private double dy = 0;
    private double dx = 0;
    private int hitCounter = 0;
    protected boolean onGround = false;
    protected int speed;
    protected double acceleration = 0.1;
    protected double deceleration = 0.2;
    protected int damage;
    protected int hitCooldown = 50;
    
    protected void gravity(){
        dy += gravity;
        setLocation(getX(), getY()+(int)Math.ceil(dy));
        if(getIntersectingObjects(Ground.class).size() > 0){
            setLocation(getX(), getY()-(int)Math.ceil(dy));
            dy = 0;
            onGround = true;
        }
        else{
            onGround = false;
        }
    }
    
    protected void checkAttack(){
        Player p = (Player)getOneIntersectingObject(Player.class);
        if(p == null){
            return;
        }
        else{
            //getWorld().removeObject(p);
            hitCounter++;
            if(hitCounter >= hitCooldown){
                hitCounter = 0;
                p.hit(damage);
            }
        }
    }

    protected void moveToPlayer(){
       java.util.List<Player> players = getWorld().getObjects(Player.class);
        if(onGround && !players.isEmpty()){
            Player p = players.get(0);
            if(getX() > p.getX()){
                //accelerate left
                if(dx > 0){
                    dx -= deceleration;
                }
                else{
                    dx -= acceleration; 
                }
                dx = Math.max(-speed, dx); //limit the speed
            }
            else{
                //accelerate right
                if(dx < 0){
                    dx += deceleration;
                }
                else{
                    dx += acceleration; 
                }
                dx = Math.min(speed, dx); //limit the speed
            }
        }
        else if(onGround){
            if(dx >= deceleration){
                dx -= deceleration;
            }
            else if(dx <= deceleration){
                dx += deceleration;
            }
            else{
                dx = 0;
            }
        }
        //if(onGround)
        setLocation(getX()+(int)dx, getY());
    }
}
