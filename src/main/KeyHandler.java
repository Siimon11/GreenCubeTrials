package main;

import entity.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    GamePanel gamePanel;
    public boolean debug = false;
    public boolean wPressed, aPressed, sPressed, dPressed, spacePressed, enterPressed, idle;

    public KeyHandler(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (gamePanel.gameState == gamePanel.titleState) {
            //titleKeys(code);
        } else if (gamePanel.gameState == gamePanel.playState) {
            playKeys(code);
        }

    }
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (gamePanel.gameState == gamePanel.titleState) {

        } else if (gamePanel.gameState == gamePanel.playState) {
            checkMovement(false, code);
            debug(code);
        }
    }
    public void playKeys(int code) {
        checkMovement(true, code);
        if (code == KeyEvent.VK_M) {
            gamePanel.levelNumber = 1;
            gamePanel.roomNumber = 2;
            gamePanel.level.changeRoom(1, 2);
        }
        if (code == KeyEvent.VK_G) {
            gamePanel.player.dead();
        }
        if (code == KeyEvent.VK_C) {
            System.out.println(gamePanel.player.playerState);
            System.out.println(gamePanel.player.spriteNum);
            System.out.println(gamePanel.player.spriteTick);
            System.out.println(gamePanel.player.onGround);
        }
    }
    public void titleKeys(int code) {
        if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
            if (gamePanel.ui.commandNumber == 0) {
                gamePanel.ui.commandNumber = 1;
            } else if (gamePanel.ui.commandNumber == 1) {
                gamePanel.ui.commandNumber = 0;
            }
        } else if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
            if (gamePanel.ui.commandNumber == 0) {
                gamePanel.ui.commandNumber = 1;
            } else if (gamePanel.ui.commandNumber == 1) {
                gamePanel.ui.commandNumber = 0;
            }
        }
        if (code == KeyEvent.VK_ENTER) {
            if (gamePanel.ui.commandNumber == 0) {
                gamePanel.ui.titleScreenNumber = 1;
            } else if (gamePanel.ui.commandNumber == 1) {
                System.exit(0);
            }
        }
    }
    public void checkMovement(boolean a, int code) {
        if (code == KeyEvent.VK_A) {
            aPressed = a;
        }
        if (code == KeyEvent.VK_D) {
            dPressed = a;
        }
        if (code == KeyEvent.VK_W) {
            wPressed = a;
        }
        if (code == KeyEvent.VK_S) {
            sPressed = a;
        }
        if (code == KeyEvent.VK_SPACE) {
            spacePressed = a;
        }
        if (code == KeyEvent.VK_ENTER) {
            enterPressed = a;
        }
    }
    public void debug(int code) {
        if (code == KeyEvent.VK_P && !debug) {
            debug = true;
        } else if (code  == KeyEvent.VK_P) {
            debug = false;
        }
    }
}
