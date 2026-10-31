package main;

import entity.Entity;
import entity.Player;
import level.Level;
import level.LevelAssets;
import objects.*;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable {

    public final int tileSize = 32;
    public final int maxScreenCol = 32;
    public final int maxScreenRow = 20;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;
    public final int FPS = 60;

    // LEVEL SETTINGS
    public final int maxWorldCol = 32;
    public final int maxWorldRow = 20;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;
    public int levelNumber;
    public int roomNumber;

    // GAME STATE
    public int gameState;
    public int titleState = 1;
    public int playState = 2;


    //
    public TileManager tileManager = new TileManager(this);
    public AssetSetter assetSetter = new AssetSetter(this);
    public LevelAssets levelAssets = new LevelAssets(this);
    public CollisionChecker collisionChecker = new CollisionChecker(this);
    public KeyHandler keyHandler = new KeyHandler(this);
    public MouseHandler mouseHandler = new MouseHandler(this);
    public UI ui = new UI(this);
    public Level level = new Level(this);
    public Entity[][][] object = new Entity[3][10][100];

    // ARRAYLIST
    public ArrayList<Wall> walls = new ArrayList<>();
    public ArrayList<Ladder> ladders = new ArrayList<>();
    public ArrayList<Spike> spikes = new ArrayList<>();
    public ArrayList<Slime> slimes = new ArrayList<>();
    public ArrayList<Door> doors = new ArrayList<>();
    public ArrayList<Collectible> collectibles = new ArrayList<>();

    // PLAYER
    public Player player = new Player(this, keyHandler);

    Thread gameThread;


    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.addMouseListener(mouseHandler);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void setupGame() {
        reset();
        gameState = titleState;
        levelAssets.place();
    }

    public void reset() {
        player.hitBox.x = (int)player.worldX;
        player.hitBox.y = (int)player.worldY;
        player.xSpeed = 0;
        player.ySpeed = 0;
    }



    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (gameThread != null) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if (timer >= 1000000000) {
                //System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }
    public void update() {
        if (gameState == playState) {
            player.update();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        Graphics2D g2 = (Graphics2D)g;

        if (gameState == titleState) {
            ui.draw(g2);
        } else if (gameState == playState) {
            tileManager.draw(g2);
            levelAssets.draw(g2);
            player.draw(g2);
            if (keyHandler.debug) {
                ui.draw(g2);
            }
        }
        /*
        for(Wall wall: walls) {
            wall.draw(g2);
        }
         */
        g2.dispose();
    }
    public void makeWalls() {
        int worldCol = 0;
        int worldRow = 0;

        while (worldCol < maxWorldCol && worldRow < maxWorldRow) {
            int tileNumber = tileManager.mapTileNumber[worldCol][worldRow];

            int worldX = worldCol * tileSize;
            int worldY = worldRow * tileSize;

            if (tileManager.tile[tileNumber].collision) {
                walls.add(new Wall(worldX, worldY, 32, 32));
            }

            worldCol++;
            if (worldCol == maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }
        }
    }
}
