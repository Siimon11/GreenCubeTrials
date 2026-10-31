package objects;

import java.awt.*;

public abstract class Collectible {
    public Rectangle hitBox;
    public int amount = 1;
    int x, y;
    int width, height;
    public Collectible() {

    }
    public void reduceAmount() {
        if(amount > 0) amount--;
    }
    public void draw(Graphics2D g2) {

    }
}
