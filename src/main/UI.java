package main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class UI {
    GamePanel gamePanel;
    Graphics2D g2;
    public int commandNumber;
    public int titleScreenNumber;
    private BufferedImage mainMenuImage;
    Font font;
    public UI(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        loadImages();
    }
    public void draw(Graphics2D g2) {
        this.g2 = g2;
        font = new Font("Arial", Font.PLAIN, 60);
        if (gamePanel.gameState == gamePanel.titleState) {
            if (titleScreenNumber == 0) {
                drawTitleScreen();
            } else if (titleScreenNumber == 1) {
                drawLevelSelection();
            } else if (titleScreenNumber == 99) {
                drawOptions();
            }
        } else if (gamePanel.gameState == gamePanel.playState) {
            if(gamePanel.keyHandler.debug) {
                debug();
            }
        }
    }

    public void drawTitleScreen() {
        BufferedImage image = null;
        image = mainMenuImage;
        g2.drawImage(image, 0, 0, gamePanel.screenWidth, gamePanel.screenHeight, null);
    }
    public void drawLevelSelection() {
        g2.setColor(Color.gray);
        g2.fillRect(0, 0, gamePanel.screenWidth, gamePanel.screenHeight);
        g2.setColor(Color.white);
        g2.fillRoundRect(70, 30, 260, 600, 30, 30);
        g2.fillRoundRect(370, 30, 260, 600, 30, 30);
        g2.fillRoundRect(670, 30, 260, 600, 30, 30);
        g2.setStroke(new BasicStroke(3));
        g2.setColor(Color.black);
        g2.drawRoundRect(70, 30, 260, 600, 30, 30);
        g2.drawRoundRect(370, 30, 260, 600, 30, 30);
        g2.drawRoundRect(670, 30, 260, 600, 30, 30);

        String text = "Level";
        g2.setFont(font);
        g2.drawString(text + " 1", 100, 100);
        g2.drawString(text + " 2", 400, 100);
        g2.drawString(text + " 3", 700, 100);
    }
    public int getXforCenteredText(String text) {
        int lenght = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gamePanel.screenWidth/2 - lenght/2;

        return x;
    }
    public void drawRectangle(int x, int y, int width, int height) {
        g2.setStroke(new BasicStroke(10));
        g2.setColor(Color.lightGray);
        g2.fillRoundRect(x, y, width, height, 10, 10);
        g2.setColor(new Color(0, 0, 0, 100));
        g2.drawRoundRect(x, y, width, height, 10, 10);
    }
    public void debug() {
        g2.setColor(Color.BLACK);
        g2.setFont(g2.getFont().deriveFont(50f));
        g2.drawString("Debug", 50, 100);
    }
    public void loadImages() {
        try {
            mainMenuImage = ImageIO.read(getClass().getResourceAsStream("/main_menu/emerald_escape_menu.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void drawOptions() {
        g2.setColor(Color.green);
        g2.drawOval(100,100,300,300);
    }

}
