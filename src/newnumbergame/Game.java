package newnumbergame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author mikper222
 */
public class Game {

    Grid grid = new Grid();
    int x0, y0;

    Game(boolean keys) {
        grid.add2or4();
        grid.add2or4();
    }

    void nextFrame(Point mouse) {

    }

    void draw(Graphics g) {
        g.setColor(Color.black);
                for (int x = 100; x <= 300; x += 100) {
            g.drawLine(x, 0, x, 400);
            g.drawLine(0, x, 400, x);
        }
        grid.drawGrid(g);
    }


    void mousePressed(int x, int y) {
        x0 = x;
        y0 = y; 
    }

    void mouseReleased(int x, int y) {
       int dx = x - x0;
        int dy = y - y0;
        grid.setDirection(dx, dy);
    }



}
