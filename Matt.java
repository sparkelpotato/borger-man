import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Slow, tanky enemy.
 * 
 * @author Ryan 
 * @version 1.1
 */
public class Matt extends Enemy
{
    public Matt(){
        speed = 2;
        damage = 3;
        health = 20;
    }

    public void act()
    {
        gravity();
        moveToPlayer();
        checkAttack();
    }
}
