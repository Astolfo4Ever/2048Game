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

    private int x, y, vx, vy;
    private int value;

    public Tile(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    void setDirection(int dx, int dy) {
        if (abs(dx) > abs(dy)) {
            vx = signum(dx);
            vy = 0;
        } else {
            vx = 0;
            vy = signum(dy);
        }
    }

    void move() {
      x += vx;
      y += vy;
    }

    void draw(Graphics g) {
        g.setColor(new Color((int) value -  value/2, 100, value));
        g.fillRect(x , y , 100, 100);
        g.setColor(Color.WHITE);
        g.drawString("" + value, x + 50, y + 50);
        System.out.println("x = " + x);
        System.out.println("y = " + y);
    }
}
