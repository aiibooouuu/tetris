package mino;

import java.awt.Color;

public class Mino_Square extends Mino {

    public Mino_Square() {
        create(Color.yellow);
    }

    public void setXY(int x, int y) {
        // Corrected Square Layout:
        // o o
        // o o

        b[0].x = x;
        b[0].y = y;
        b[1].x = x + Block.SIZE;
        b[1].y = y;
        b[2].x = x;
        b[2].y = y + Block.SIZE;
        b[3].x = x + Block.SIZE;
        b[3].y = y + Block.SIZE;
    }

    public void getDirection1() { /* No rotation needed for a square */ }
    public void getDirection2() { /* No rotation needed for a square */ }
    public void getDirection3() { /* No rotation needed for a square */ }
    public void getDirection4() { /* No rotation needed for a square */ }

}
