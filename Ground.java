import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootImage;

/**
 * Write a description of class Ground here.
 * 
 * @author Ryan 
 * @version 1.1
 */
public class Ground extends Actor
{
    public Ground(int width){
        GreenfootImage i = new GreenfootImage(width, 145);
        i.setColor(new Color(40,200,20));
        i.fill();
        setImage(i);
    }
}
