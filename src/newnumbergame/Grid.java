package newnumbergame;

import java.awt.Graphics;
import static java.lang.Math.random;
import java.util.ArrayList;

/**
 *
 * @author mikper222
 */
class Grid {
    
    ArrayList<Tile> list = new ArrayList();
    
    void drawGrid(Graphics g) {
        
        for (Tile t : list) {
            t.draw(g);
        }
    }
    
    void add2or4(){
        int ix, iy;
        do {
            ix = (int) (random() * 4);
            iy = (int) (random() * 4);
        } while (occupied( ix, iy));
                
        int value = 2;
        if(random()>03) value = 4;
        list.add(new Tile(ix * 100, iy * 100, value));
    }
    
    private boolean occupied (int ix, int iy) {
        boolean ans;
        if (ix == 0) {
            ans = true;
        } else {
            ans = false;
        }
        return ans;
    } 
    
    void nextFrame(){
        for (Tile t : list) {
            t.move();
        }
    }
    
    void setDirection(int dx, int dy){
        for (Tile t : list) {
            t.setDirection(dx,dy);
        }
    }
    
}
