package level;

import main.GamePanel;
import objects.*;

import java.awt.*;

public class LevelAssets {
    GamePanel gamePanel;
    public LevelAssets(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }
    public void place() {
        placeSpikes();
    }
    public void placeSpikes() {
        if (gamePanel.levelNumber == 1) {
            if (gamePanel.roomNumber == 1) {
                level1room1();
            } else if (gamePanel.roomNumber == 2) {
                level1room2();
            } else if (gamePanel.roomNumber == 3) {
                level1room3();
            }
        } else if (gamePanel.levelNumber == 2) {
            /*
            if (gamePanel.roomNumber == 1) {
                level2room1();
            } else if (gamePanel.roomNumber == 2) {
                level2room2();
            } else if (gamePanel.roomNumber == 3) {
                level2room3();
            }

             */
        }
    }
    public void draw(Graphics2D g2) {
        for (Spike spike: gamePanel.spikes) {
            spike.draw(g2);
        }
        for (Ladder ladder: gamePanel.ladders) {
            ladder.draw(g2);
        }
        for (Slime slime: gamePanel.slimes) {
            slime.draw(g2);
        }
        for(Collectible collectible: gamePanel.collectibles) {
            if (collectible.amount > 0) {
                collectible.draw(g2);
            }
        }
        /*
        for (Door door: gamePanel.doors) {
            door.draw(g2);
        }
         */
    }
    public void level1room1() {

        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*4, gamePanel.tileSize*18, 32, 32, "down"));
        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*5, gamePanel.tileSize*18, 32, 32, "down"));
        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*6, gamePanel.tileSize*18, 32, 32, "down"));

        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*11, gamePanel.tileSize*17, 32, 32, "down"));

        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*9, gamePanel.tileSize*16, 32, 32, "up"));
        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*10, gamePanel.tileSize*15, 32, 32, "left"));
        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*9, gamePanel.tileSize*14, 32, 32, "down"));
        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*8, gamePanel.tileSize*15, 32, 32, "right"));

        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*14, gamePanel.tileSize*18, 32, 32, "right"));
        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*15, gamePanel.tileSize*17, 32, 32, "down"));
        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*16, gamePanel.tileSize*18, 32, 32, "left"));
        
        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*21, gamePanel.tileSize*18, 32, 32, "down"));
        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*22, gamePanel.tileSize*18, 32, 32, "down"));
        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*23, gamePanel.tileSize*18, 32, 32, "down"));

        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*24, gamePanel.tileSize*15, 32, 32, "up"));
        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*24, gamePanel.tileSize*13, 32, 32, "down"));
        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*25, gamePanel.tileSize*15, 32, 32, "up"));
        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*26, gamePanel.tileSize*15, 32, 32, "up"));


        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*16, gamePanel.tileSize*10, 32, 32, "down"));

        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*6, gamePanel.tileSize*10, 32, 32, "up"));
        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*7, gamePanel.tileSize*8, 32, 32, "right"));

        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*21, gamePanel.tileSize*5, 32, 32, "down"));

        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*26, gamePanel.tileSize*5, 32, 32, "up"));
        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*26, gamePanel.tileSize*3, 32, 32, "down"));

        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*4, gamePanel.tileSize*2, 32, 32, "down"));
        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*7, gamePanel.tileSize*2, 32, 32, "down"));

        gamePanel.doors.add(new Door(gamePanel.tileSize*1, gamePanel.tileSize*2, 32, 32));

        //gamePanel.collectibles.add(new Coin(gamePanel.tileSize*2, gamePanel.tileSize*15, 32, 32));

    }
    public void level1room2() {
        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*3, gamePanel.tileSize*18, 32, 32, "down"));
        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*6, gamePanel.tileSize*18, 32, 32, "down"));
        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*9, gamePanel.tileSize*18, 32, 32, "down"));
        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*10, gamePanel.tileSize*18, 32, 32, "down"));

        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*12, gamePanel.tileSize*14, 32, 32, "up"));

        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*5, gamePanel.tileSize*15, 32, 32, "down"));

        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*21, gamePanel.tileSize*10, 32, 32, "right"));
        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*21, gamePanel.tileSize*11, 32, 32, "right"));
        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*21, gamePanel.tileSize*12, 32, 32, "right"));
        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*22, gamePanel.tileSize*13, 32, 32, "right"));
        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*22, gamePanel.tileSize*14, 32, 32, "right"));
        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*22, gamePanel.tileSize*15, 32, 32, "right"));
        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*22, gamePanel.tileSize*16, 32, 32, "right"));
        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*22, gamePanel.tileSize*17, 32, 32, "right"));

        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*19, gamePanel.tileSize*12, 32, 32, "left"));
        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*19, gamePanel.tileSize*13, 32, 32, "left"));
        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*19, gamePanel.tileSize*14, 32, 32, "left"));

        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*20, gamePanel.tileSize*15, 32, 32, "down"));

        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*22, gamePanel.tileSize*20, 32, 32, "down"));

        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*13, gamePanel.tileSize*3, 32, 32, "down"));
        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*14, gamePanel.tileSize*3, 32, 32, "down"));
        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*15, gamePanel.tileSize*3, 32, 32, "down"));
        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*16, gamePanel.tileSize*3, 32, 32, "down"));
        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*17, gamePanel.tileSize*3, 32, 32, "down"));
        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*18, gamePanel.tileSize*3, 32, 32, "down"));

        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*20, gamePanel.tileSize*5, 32, 32, "down"));
        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*21, gamePanel.tileSize*4, 32, 32, "down"));
        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*22, gamePanel.tileSize*4, 32, 32, "down"));
        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*23, gamePanel.tileSize*4, 32, 32, "down"));
        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*24, gamePanel.tileSize*4, 32, 32, "down"));
        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*25, gamePanel.tileSize*5, 32, 32, "down"));
        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*26, gamePanel.tileSize*6, 32, 32, "down"));
        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*27, gamePanel.tileSize*7, 32, 32, "left"));
        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*27, gamePanel.tileSize*8, 32, 32, "left"));
        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*27, gamePanel.tileSize*9, 32, 32, "left"));
        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*27, gamePanel.tileSize*10, 32, 32, "left"));

        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*30, gamePanel.tileSize*6, 32, 32, "right"));
        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*30, gamePanel.tileSize*7, 32, 32, "right"));
        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*30, gamePanel.tileSize*8, 32, 32, "right"));
        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*30, gamePanel.tileSize*9, 32, 32, "right"));
        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*30, gamePanel.tileSize*10, 32, 32, "right"));
        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*30, gamePanel.tileSize*11, 32, 32, "right"));
        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*29, gamePanel.tileSize*12, 32, 32, "right"));
        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*29, gamePanel.tileSize*13, 32, 32, "right"));
        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*28, gamePanel.tileSize*14, 32, 32, "right"));

        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*27, gamePanel.tileSize*20, 32, 32, "down"));





        // VINES
        gamePanel.ladders.add(new Vine(gamePanel.tileSize*14, gamePanel.tileSize*15, 32, 32));
        gamePanel.ladders.add(new Vine(gamePanel.tileSize*14, gamePanel.tileSize*16, 32, 32));

        gamePanel.ladders.add(new Vine(gamePanel.tileSize*5, gamePanel.tileSize*11, 32, 32));

        gamePanel.ladders.add(new Vine(gamePanel.tileSize*19, gamePanel.tileSize*7, 32, 32));
        gamePanel.ladders.add(new Vine(gamePanel.tileSize*19, gamePanel.tileSize*8, 32, 32));

        gamePanel.ladders.add(new Vine(gamePanel.tileSize*7, gamePanel.tileSize*3, 32, 32));
        gamePanel.ladders.add(new Vine(gamePanel.tileSize*7, gamePanel.tileSize*4, 32, 32));
        gamePanel.ladders.add(new Vine(gamePanel.tileSize*7, gamePanel.tileSize*5, 32, 32));
        gamePanel.ladders.add(new Vine(gamePanel.tileSize*7, gamePanel.tileSize*6, 32, 32));
        gamePanel.ladders.add(new Vine(gamePanel.tileSize*7, gamePanel.tileSize*1, 32, 32));
        gamePanel.ladders.add(new Vine(gamePanel.tileSize*7, gamePanel.tileSize*2, 32, 32));

        // DOOR
        gamePanel.doors.add(new Door(gamePanel.tileSize*30, gamePanel.tileSize*18, 32, 32));


    }
    public void level1room3() {
        // SPIKES
        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*4, gamePanel.tileSize*1, 32, 32, "right"));
        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*4, gamePanel.tileSize*2, 32, 32, "right"));
        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*4, gamePanel.tileSize*2, 32, 32, "down"));
        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*3, gamePanel.tileSize*3, 32, 32, "right"));
        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*3, gamePanel.tileSize*4, 32, 32, "right"));
        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*4, gamePanel.tileSize*5, 32, 32, "up"));
        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*6, gamePanel.tileSize*7, 32, 32, "up"));
        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*7, gamePanel.tileSize*7, 32, 32, "up"));
        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*8, gamePanel.tileSize*7, 32, 32, "up"));
        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*9, gamePanel.tileSize*7, 32, 32, "up"));

        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*1, gamePanel.tileSize*3, 32, 32, "left"));

        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*1, gamePanel.tileSize*6, 32, 32, "left"));
        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*1, gamePanel.tileSize*7, 32, 32, "left"));
        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*1, gamePanel.tileSize*8, 32, 32, "left"));
        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*1, gamePanel.tileSize*9, 32, 32, "left"));
        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*1, gamePanel.tileSize*10, 32, 32, "down"));
        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*2, gamePanel.tileSize*12, 32, 32, "down"));
        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*3, gamePanel.tileSize*13, 32, 32, "left"));
        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*3, gamePanel.tileSize*14, 32, 32, "left"));
        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*3, gamePanel.tileSize*15, 32, 32, "left"));
        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*3, gamePanel.tileSize*16, 32, 32, "down"));

        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*6, gamePanel.tileSize*10, 32, 32, "down"));
        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*5, gamePanel.tileSize*13, 32, 32, "right"));
        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*5, gamePanel.tileSize*14, 32, 32, "right"));
        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*5, gamePanel.tileSize*15, 32, 32, "right"));
        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*5, gamePanel.tileSize*16, 32, 32, "right"));
        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*5, gamePanel.tileSize*17, 32, 32, "right"));
        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*7, gamePanel.tileSize*11, 32, 32, "left"));
        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*7, gamePanel.tileSize*12, 32, 32, "left"));
        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*7, gamePanel.tileSize*13, 32, 32, "left"));
        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*7, gamePanel.tileSize*14, 32, 32, "left"));

        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*11, gamePanel.tileSize*9, 32, 32, "up"));
        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*12, gamePanel.tileSize*9, 32, 32, "up"));
        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*13, gamePanel.tileSize*9, 32, 32, "up"));
        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*11, gamePanel.tileSize*12, 32, 32, "down"));
        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*12, gamePanel.tileSize*12, 32, 32, "down"));
        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*13, gamePanel.tileSize*12, 32, 32, "down"));
        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*10, gamePanel.tileSize*13, 32, 32, "right"));
        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*10, gamePanel.tileSize*14, 32, 32, "right"));
        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*10, gamePanel.tileSize*15, 32, 32, "right"));
        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*10, gamePanel.tileSize*16, 32, 32, "right"));
        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*10, gamePanel.tileSize*17, 32, 32, "right"));

        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*8, gamePanel.tileSize*18, 32, 32, "down"));
        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*9, gamePanel.tileSize*18, 32, 32, "down"));
        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*10, gamePanel.tileSize*18, 32, 32, "down"));

        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*16, gamePanel.tileSize*18, 32, 32, "down"));
        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*17, gamePanel.tileSize*18, 32, 32, "down"));
        gamePanel.spikes.add(new SingleSpike(gamePanel.tileSize*18, gamePanel.tileSize*18, 32, 32, "down"));

        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*14, gamePanel.tileSize*6, 32, 32, "left"));
        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*15, gamePanel.tileSize*6, 32, 32, "right"));

        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*17, gamePanel.tileSize*13, 32, 32, "left"));
        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*17, gamePanel.tileSize*12, 32, 32, "left"));
        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*17, gamePanel.tileSize*11, 32, 32, "left"));
        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*17, gamePanel.tileSize*9, 32, 32, "left"));
        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*17, gamePanel.tileSize*8, 32, 32, "left"));
        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*17, gamePanel.tileSize*7, 32, 32, "left"));

        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*20, gamePanel.tileSize*15, 32, 32, "right"));
        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*20, gamePanel.tileSize*14, 32, 32, "right"));
        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*20, gamePanel.tileSize*13, 32, 32, "right"));
        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*20, gamePanel.tileSize*11, 32, 32, "right"));
        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*20, gamePanel.tileSize*10, 32, 32, "right"));
        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*20, gamePanel.tileSize*9, 32, 32, "right"));
        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*20, gamePanel.tileSize*7, 32, 32, "right"));
        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*20, gamePanel.tileSize*6, 32, 32, "right"));
        gamePanel.spikes.add(new LowSpike(gamePanel.tileSize*20, gamePanel.tileSize*5, 32, 32, "right"));

        // SLIMES
        gamePanel.slimes.add(new Slime(gamePanel.tileSize*4, gamePanel.tileSize*17, 32, 32));
        gamePanel.slimes.add(new Slime(gamePanel.tileSize*7, gamePanel.tileSize*18, 32, 32));

        // DOOR
        gamePanel.doors.add(new Door(gamePanel.tileSize*30, gamePanel.tileSize*5, 32, 32));
    }

}
