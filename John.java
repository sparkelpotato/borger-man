import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class John here.
 * 
 * @author Ryan 
 * @version 1.1
 */
public class John extends Enemy
{
    public John(){
        speed = 7;
        damage = 6;
        health = 10;
    }
    
    /**
     * Act - do whatever the John wants to do. This method is called whenever
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
