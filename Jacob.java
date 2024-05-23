import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jacob here.
 * 
 * @author Ryan 
 * @version 1.1
 */
public class Jacob extends Actor
{
    private static final int LIFE = 100;
    private static final int DAMAGE = 2;
    private boolean inWorld = false;
    private double dx;
    private double dy;
    private int timer;
    public Jacob(double dx, double dy){
        timer = LIFE;
        this.dx = dx;
        this.dy = dy;
    }
    
    public Jacob(double dx, double dy, double speed){
        this(dx, dy);
        setSpeed(speed);
    }
    
    /**
     * Method setSpeed
     * Changes speed but keeps direction
     *
     * @param speed The speed it should move at
     */
    public void setSpeed(double speed){
        double oldSpeed = Math.sqrt(dx * dx + dy * dy);
        dx *= speed/oldSpeed;
        dy *= speed/oldSpeed;
    }
    
    
    /**
     * Act - do whatever the Jacob wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        timer --;
        if(isAtEdge() || timer <= 0){
            getWorld().removeObject(this);
            return;
        }
        setLocation(getX()+ (int)Math.round(dx), getY()+ (int)Math.round(dy));
        checkAttack();
    }
    
    private void checkAttack(){
        Player p = (Player)getOneIntersectingObject(Player.class);
        if(p == null){
            return;
        }
        else{
            p.hit(DAMAGE);
            getWorld().removeObject(this);
        }
    }
}
