package newnumbergame;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;

/**
 *
 * @author mikper222
 */
public class Game {

    Grid grid = new Grid();
    private int x0, y0;

    Game() {
        grid.add2or4();
    }

    void nextFrame(Point mouse) {
        grid.nextFrame();
    }

    void draw(Graphics g) {
        grid.drawGrid(g);
    }

    void keyPressed(int key) {
        switch (key){
            case KeyEvent.VK_W:
                grid.setDirection(0, -1);
                break;
            case KeyEvent.VK_S:
                grid.setDirection(0, 1);
                break;
            case KeyEvent.VK_A:
                grid.setDirection(-1, 0);
                break;
            case KeyEvent.VK_D:
                grid.setDirection(1, 0);
                break;    
        }
    }

    void keyReleased(int key) {
        
    }

}
