package main;

import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener {
    GamePanel gamePanel;
    public boolean mouseInLvl1, mouseInLvl2, mouseInLvl3;
    public MouseHandler(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int clickX = e.getX();
        int clickY = e.getY();
        if (gamePanel.gameState == gamePanel.titleState) {
            if (gamePanel.ui.titleScreenNumber == 0) {
                if (clickX > 400 && clickX < 623 && clickY > 210 && clickY < 258) {
                    gamePanel.ui.titleScreenNumber = 1;
                } else if (clickX > 400 && clickX < 623 && clickY > 270 && clickY < 318) {
                    gamePanel.ui.titleScreenNumber = 99; 
                }
            }
            else if (gamePanel.ui.titleScreenNumber == 1) {
                if (clickX > 70 && clickX < 330 && clickY > 70 && clickY < 670) {
                    gamePanel.level.changeRoom(1, 1);
                }
            }
        } else if (gamePanel.gameState == gamePanel.playState) {
            if (gamePanel.keyHandler.debug) {
                gamePanel.player.worldX = clickX - 16;
                gamePanel.player.worldY = clickY - 16;
                gamePanel.player.hitBox.x = (int)gamePanel.player.worldX;
                gamePanel.player.hitBox.y = (int)gamePanel.player.worldY;
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int clickX = e.getX();
        int clickY = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int clickX = e.getX();
        int clickY = e.getY();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
        int clickX = e.getX();
        int clickY = e.getY();
    }
}
