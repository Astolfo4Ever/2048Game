package newnumbergame;

import java.awt.Color;
import java.awt.Graphics;
import static java.lang.Math.abs;
import static java.lang.Integer.signum;

/**
 *
 * @author mikper222
 */
class Tile {
    int x,y, vx, vy;
    int value;

    void setDirection(int dx, int dy) {
        if (abs(dx) > abs(dy)) {
            vx= signum(dx);
            vy = 0;        
        } else {
            vx = 0;
            vy= signum(dy);
        }
    }

    void move() {
        x += vx;
        y += vy;
    }
    
    void draw(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(x+2, y+2, 96, 96);
        g.setColor(Color.WHITE);
        g.drawString(""+value, x+50, y+50);
    }
}
