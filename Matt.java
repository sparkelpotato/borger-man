import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Matt here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Matt extends Enemy
{
    public Matt(){
        speed = 2;
        damage = 4;
    }
    /**
     * Act - do whatever the Matt wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        gravity();
        moveToPlayer();
        checkAttack();
    }
}
