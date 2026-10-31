package level;

import main.GamePanel;

public class Level {
    GamePanel gamePanel;
    public Level(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void changeRoom(int levelNumber, int roomNumber) {
        gamePanel.player.controllable = false;
        gamePanel.gameState = gamePanel.playState;
        gamePanel.roomNumber = roomNumber;
        gamePanel.levelNumber = levelNumber;
        gamePanel.walls.clear();
        gamePanel.ladders.clear();
        gamePanel.spikes.clear();
        gamePanel.doors.clear();
        gamePanel.tileManager.loadRoom("/maps/level" + levelNumber + "/level0" + levelNumber + "_" + roomNumber + ".txt");
        gamePanel.makeWalls();
        gamePanel.levelAssets.place();
        getSpawnPositions();
        gamePanel.player.spawn();
    }
    public void getSpawnPositions() {
        if (gamePanel.levelNumber == 1) {
            if (gamePanel.roomNumber == 1) {
               position(2, 18);
            } else if (gamePanel.roomNumber == 2) {
                position(1, 18);
            } else if (gamePanel.roomNumber == 3) {
                position(1, 1);
            }
        } else if (gamePanel.levelNumber == 2) {

        }
    }
    public void position(int spawnX, int spawnY) {
        gamePanel.player.worldX = gamePanel.tileSize * spawnX;
        gamePanel.player.worldY = gamePanel.tileSize * spawnY;
        gamePanel.player.hitBox.x = (int)gamePanel.player.worldX;
        gamePanel.player.hitBox.y = (int)gamePanel.player.worldY;
    }
}
