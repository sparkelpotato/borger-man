import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Draws a healthbar for the player.
 * 
 * @author Ryan 
 * @version 1.1
 */
public class HealthBar extends Actor
{
    private static final int HEIGHT = 5;
    private static final int BUFFER = 20;
    private Player player;
    public HealthBar(Player player){
        this.player = player;
        setImage(new GreenfootImage(1,1));
    }
    
    public void act()
    {
        setImage(makeHealthBar(player.getHealth()));
    }
    
    private GreenfootImage makeHealthBar(int health){
        double multiplier = (getWorld().getWidth() - BUFFER)/100.0;
        GreenfootImage image = new GreenfootImage(getWorld().getWidth()-(BUFFER*2), HEIGHT);
        image.setColor(Color.RED);
        image.fillRect(0,0,(int)(health*multiplier),HEIGHT);
        return image;
    }
}
