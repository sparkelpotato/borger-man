import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private final double gravity = 0.7;
    protected int speed = 5;
    private boolean onGround = false;
    protected double acceleration = 0.2;
    private final int JUMP_SPEED = 15;
    private double dy;
    private double dx;
    private int health;
    
    public Player(){
        dy = 0;
        dx = 0;
        health = 100;
    }
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.        
        gravity();
        checkControls();
        checkPowerUp();
    }
    
    public void hit(int damage){
        health -= damage;
        if(health <= 0){
            Greenfoot.stop();
        }
    }
    
    public int getHealth(){
        return health;
    }
    
    private void checkControls(){
        boolean moved = false;
        if(Greenfoot.isKeyDown("left")){
            dx -= acceleration; //accelerate left
            dx = Math.max(-speed, dx); //limit the speed
            moved = true;
        }
        if(Greenfoot.isKeyDown("right")){
            dx += acceleration; //accelerate right
            dx = Math.min(speed, dx); //limit the speed
            moved = true;
        }
        if(Greenfoot.isKeyDown("up") && onGround){
            dy = -JUMP_SPEED;
        }
        if(!moved && onGround){
            //decelerate
            if(dx >= acceleration){
                dx -= acceleration;
            }
            else if(dx <= acceleration){
                dx += acceleration;
            }
            else{
                dx = 0;
            }
        }
        setLocation(getX()+(int)dx, getY());
    }
    
    private void checkPowerUp(){
        PowerUp p = (PowerUp)getOneIntersectingObject(PowerUp.class);
        if(p == null){
            return;
        }
        else{
            getWorld().removeObject(p);
            health = 100;
        }
    }
    
    private void gravity(){
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
    
}
