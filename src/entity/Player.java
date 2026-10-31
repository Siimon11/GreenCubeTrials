package entity;

import main.GamePanel;
import main.KeyHandler;
import objects.Wall;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.random.RandomGenerator;

public class Player extends Entity{

    GamePanel gamePanel;
    KeyHandler keyHandler;
    BufferedImage playerLeft, playerRight, playerDefault;
    public final int playerWidth = 32;
    public final int playerHeight = 32;
    private boolean onGround = false;
    public String direction = "right";
    public String playerState = "idle";
    public static int coins = 0;
    public Point lastPos;

    public Player(GamePanel gamePanel, KeyHandler keyHandler) {
        super(gamePanel);
        this.keyHandler = keyHandler;
        this.gamePanel = gamePanel;


        hitBox = new Rectangle(0, 0, playerWidth, playerHeight);
        getPlayerImage();
        getDefaultValues();
    }
    public void draw(Graphics2D g2) {
        BufferedImage image = switch (direction) {
            case "right" -> playerRight;
            case "left" -> playerLeft;
            default -> null;
        };
        if(Objects.equals(playerState, "spawning")) {
            if(spriteTick == 20) {
                spriteNum++;
                spriteTick = 0;
            }
            assert image != null;
            image = image.getSubimage(spriteNum*gamePanel.tileSize, 3*gamePanel.tileSize, playerWidth, playerHeight);
        } else {

        }
        if(Objects.equals(playerState, "idle")) {
            if(spriteTick == 18) {
                spriteNum++;
                spriteTick = 0;
                if(spriteNum == 3) {
                    if(lastBlink != 3) {
                        spriteNum = 4;
                        lastBlink++;
                    } else {
                        lastBlink = 0;
                    }
                }
            }
            if(spriteNum > 5) spriteNum = 0;
            assert image != null;
            image = image.getSubimage(spriteNum*gamePanel.tileSize, 0, playerWidth, playerHeight);
        } else if (Objects.equals(playerState, "running")) {

        }
        g2.drawImage(image, (int)worldX, (int)worldY, playerWidth, playerHeight, null);
        spriteTick++;
    }
    public void update() {
        if(controllable) {
            if (gamePanel.keyHandler.aPressed && gamePanel.keyHandler.dPressed || !gamePanel.keyHandler.aPressed && !gamePanel.keyHandler.dPressed) {
                xSpeed *= 0.8;
            } else if (gamePanel.keyHandler.aPressed && !gamePanel.keyHandler.dPressed) {
                xSpeed--;
                direction = "left";
            } else if (gamePanel.keyHandler.dPressed && !gamePanel.keyHandler.aPressed) {
                xSpeed++;
                direction = "right";
            }

            if (xSpeed > 0 && xSpeed < 0.75) {
                xSpeed = 0;
            }
            if (xSpeed < 0 && xSpeed > -0.75) {
                xSpeed = 0;
            }

            if (xSpeed > 5) {
                xSpeed = 5;
            } else if (xSpeed < -5) {
                xSpeed = -5;
            }
            hitBox.y++;
            for (Wall wall: gamePanel.walls) {
                if (wall.hitBox.intersects(hitBox)) {
                    onGround = true;
                }
            }
            hitBox.y--;


            if (gamePanel.keyHandler.spacePressed) {
                hitBox.y++;
                for (Wall wall: gamePanel.walls) {
                    if (wall.hitBox.intersects(hitBox)) {
                        ySpeed = -7.0;
                        onGround = false;
                    }
                }
                hitBox.y--;
            }
            if(!onGround) {
                xSpeed *= 0.83;
            }

            gamePanel.collisionChecker.checkPlayerCollision();

            worldX += xSpeed;
            worldY += (int)ySpeed;

            hitBox.x = (int)worldX;
            hitBox.y = (int)worldY;
        }
    }

    public void getDefaultValues() {

    }

    public void getPlayerImage() {
        try {
            playerRight = ImageIO.read(getClass().getResourceAsStream("/player/player_sheet_right.png"));
            playerLeft = ImageIO.read(getClass().getResourceAsStream("/player/player_sheet_left.png"));
            playerDefault = ImageIO.read(getClass().getResourceAsStream("/player/playerImage.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void dead() {
        gamePanel.level.changeRoom(gamePanel.levelNumber, gamePanel.roomNumber);
//        worldX = gamePanel.level.returnSpawnX() * gamePanel.tileSize;
//        worldY = gamePanel.level.returnSpawnY() * gamePanel.tileSize;

        hitBox.x = (int)worldX;
        hitBox.y = (int)worldY;
        xSpeed = 0;
        ySpeed = 0;
    }
    public void spawn() {
        spriteNum = 0;
        playerState = "spawning";
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                controllable = true;
                spriteNum = 0;
                playerState = "idle";
                timer.cancel();
            }
        };
        timer.schedule(task, 1000);
    }
}
