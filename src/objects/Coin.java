package objects;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Coin extends Collectible{
    BufferedImage coinImage;
    public Coin(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        hitBox = new Rectangle(x, y, width, height);
        getImage();
    }

    @Override
    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        image = coinImage;
        g2.drawImage(image, x, y, width, height, null);
    }

    private void getImage() {
        try {
            coinImage = ImageIO.read(getClass().getResourceAsStream("/objects/coin.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
