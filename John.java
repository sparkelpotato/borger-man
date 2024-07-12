import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Fast melee enemy.
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
    
    public void act()
    {
        gravity();
        moveToPlayer();
        checkAttack();
    }
}
