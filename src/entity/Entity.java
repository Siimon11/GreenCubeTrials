package entity;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    public Rectangle hitBox;
    GamePanel gamePanel;
    public double worldX;
    public double worldY;
    public double xSpeed = 0;
    public double ySpeed = 0;
    public boolean collisionOn = false;
    public boolean controllable = false;

    public BufferedImage idle1,idle2,idle3,idle4,idle5,idle6;
    public BufferedImage run1,run2,run3,run4,run5,run6,run7,run8;
    public BufferedImage down1,down2,up1,up2;
    public BufferedImage land1,land2,land3,duck1;
    public BufferedImage hurt1,hurt2;
    public BufferedImage death1,death2,death3,death4,death5,death6,death7,death8;
    public BufferedImage spawn1,spawn2,spawn3,spawn4;
    public int spriteNum = 0;
    public int spriteTick = 0;
    public int lastBlink = 0;
    public int idleTick = 0;

    public Entity(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }


}
