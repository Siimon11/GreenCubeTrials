package main;

import entity.Entity;
import entity.Player;
import objects.*;

import java.util.ConcurrentModificationException;

public class CollisionChecker {
    GamePanel gamePanel;
    public CollisionChecker(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }


    public void checkPlayerCollision() {
        gamePanel.player.ySpeed += 0.28;

        // Horizontal
        gamePanel.player.hitBox.x += gamePanel.player.xSpeed;
        for (Wall wall: gamePanel.walls) {
            if (gamePanel.player.hitBox.intersects(wall.hitBox)){
                gamePanel.player.hitBox.x -= gamePanel.player.xSpeed;
                while (!wall.hitBox.intersects(gamePanel.player.hitBox)){
                    gamePanel.player.hitBox.x += Math.signum(gamePanel.player.xSpeed);
                }
                gamePanel.player.hitBox.x -= Math.signum(gamePanel.player.xSpeed);
                gamePanel.player.xSpeed = 0;
                gamePanel.player.worldX = gamePanel.player.hitBox.x;
            }
        }

        // Vertical
        gamePanel.player.hitBox.y += gamePanel.player.ySpeed;
        for (Wall wall: gamePanel.walls) {
            if (gamePanel.player.hitBox.intersects(wall.hitBox)){
                gamePanel.player.hitBox.y -= gamePanel.player.ySpeed;
                while (!wall.hitBox.intersects(gamePanel.player.hitBox)){
                    gamePanel.player.hitBox.y += Math.signum(gamePanel.player.ySpeed);
                }
                gamePanel.player.hitBox.y -= Math.signum(gamePanel.player.ySpeed);
                gamePanel.player.ySpeed = 0;
                gamePanel.player.worldY = gamePanel.player.hitBox.y;
            }
        }
        try {
            for (Spike spike: gamePanel.spikes) {
                if (gamePanel.player.hitBox.intersects(spike.hitBox)) {
                    gamePanel.player.dead();
                }
            }
        }catch (ConcurrentModificationException e) {

        }
        //gamePanel.player.hitBox.y += gamePanel.player.ySpeed;
        for (Ladder ladder: gamePanel.ladders) {
            if (gamePanel.player.hitBox.intersects(ladder.hitBox) && !gamePanel.keyHandler.spacePressed) {
                if (gamePanel.player.ySpeed > 1) {
                    gamePanel.player.ySpeed = 1;
                } else {
                    gamePanel.player.ySpeed += 0.3;
                }
            } else if (gamePanel.player.hitBox.intersects(ladder.hitBox) && gamePanel.keyHandler.spacePressed) {
                if (gamePanel.player.ySpeed < -2) {
                    gamePanel.player.ySpeed = -2;
                } else {
                    gamePanel.player.ySpeed -= 0.3;
                    gamePanel.player.hitBox.y += gamePanel.player.ySpeed;
                    for (Wall wall: gamePanel.walls) {
                        if (gamePanel.player.hitBox.intersects(wall.hitBox)){
                            gamePanel.player.hitBox.y -= gamePanel.player.ySpeed;
                            while (!wall.hitBox.intersects(gamePanel.player.hitBox)){
                                gamePanel.player.hitBox.y += Math.signum(gamePanel.player.ySpeed);
                            }
                            gamePanel.player.hitBox.y -= Math.signum(gamePanel.player.ySpeed);
                            gamePanel.player.ySpeed = 0;
                            gamePanel.player.worldY = gamePanel.player.hitBox.y;
                        }
                    }
                }
            }
        }
        for (Slime slime: gamePanel.slimes) {
            if (gamePanel.player.hitBox.intersects(slime.hitBox) && gamePanel.player.ySpeed > 1) {
                gamePanel.player.ySpeed -= gamePanel.player.ySpeed*1.5;
            }
        }
        for (Collectible collectible: gamePanel.collectibles) {
            if (gamePanel.player.hitBox.intersects(collectible.hitBox)) {
                Player.coins += collectible.amount;
                collectible.reduceAmount();
            }
        }
        try {
            for (Door door: gamePanel.doors) {
                if (gamePanel.player.hitBox.intersects(door.hitBox)) {
                    // PIIRRÄ ENTER
                    if (gamePanel.levelNumber == 1) {
                        if (gamePanel.roomNumber == 1) {
                            if (gamePanel.keyHandler.enterPressed) {
                                gamePanel.level.changeRoom(1, 2);
                            }
                        } else if (gamePanel.roomNumber == 2) {
                            if (gamePanel.keyHandler.enterPressed) {
                                gamePanel.level.changeRoom(1, 3);
                            }
                        } else if (gamePanel.roomNumber == 3) {
                            if (gamePanel.keyHandler.enterPressed) {
                                gamePanel.gameState = gamePanel.titleState;
                            }
                        }
                    }
                }
            }
        }catch (ConcurrentModificationException e) {
        }

    }
    public void checkTile(Entity entity) {

    }
}
