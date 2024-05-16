import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootImage;

/**
 * Write a description of class Ground here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ground extends Actor
{
    //I just exist
    public Ground(int width){
        GreenfootImage i = new GreenfootImage(width, 145);
        i.setColor(new Color(40,200,20));
        i.fill();
        setImage(i);
    }
}
