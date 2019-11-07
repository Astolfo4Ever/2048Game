/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newnumbergame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.Serializable;
import javax.swing.JPanel;

/**
 *
 * @author G.I Buttwipere
 */
class GamePanel extends JPanel implements MouseListener, MouseMotionListener, Serializable {
    
    boolean keys;

    Game game = new Game(keys);
    Point mouse = new Point();

    public GamePanel() {
        setPreferredSize(new Dimension(400, 400));
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    void nextFrame() {
        game.nextFrame(mouse);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        game.draw(g);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        game.mousePressed(e.getX(), e.getY());
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        game.mouseReleased(e.getX(), e.getY());
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }

}
