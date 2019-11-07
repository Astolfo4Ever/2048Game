package newnumbergame;

import static java.lang.Math.random;

/**
 *
 * @author mikper222
 */
public class Tiles {
    
    Tile tile = new Tile();

    void add2or4() {
        int xPos, yPos;
        int value;
        do {
            xPos = (int) (random() * 4);
            yPos = (int) (random() * 4);
        } while (yPos != 0 && xPos != 0);

        if (random() < 0.5) {
            value = 2;
            addTile(xPos, yPos, value);
        } else {
            value = 4;
            addTile(xPos, yPos, value);
        }
    }

    private void addTile(int xPos, int yPos, int value) {
        
    }
    

}
