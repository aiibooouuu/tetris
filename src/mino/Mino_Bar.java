package mino;

import java.awt.Color;

public class Mino_Bar extends Mino {

    public Mino_Bar() {
        create(Color.cyan);
    }

    public void setXY(int x, int y) {
        //
        // o o o o
        //

        // Set the coordinates for each block in the bar
        b[0].x = x;
        b[0].y = y;
        b[1].x = x - Block.SIZE;
        b[1].y = y;
        b[2].x = x + Block.SIZE;
        b[2].y = y;
        b[3].x = x + Block.SIZE * 2; // Fixed this to spread 4 blocks horizontally
        b[3].y = y; 
    }

    public void getDirection1() {
        //
        // o o o o
        //

        // Update the tempB coordinates for the horizontal orientation
        tempB[0].x = b[0].x;
        tempB[0].y = b[0].y;
        tempB[1].x = b[0].x - Block.SIZE;
        tempB[1].y = b[0].y;
        tempB[2].x = b[0].x + Block.SIZE;
        tempB[2].y = b[0].y;
        tempB[3].x = b[0].x + Block.SIZE * 2; // Corrected to make it horizontal
        tempB[3].y = b[0].y;

        updateXY(1);
    }

    public void getDirection2() {
        // o
        // o
        // o
        // o

        // Update the tempB coordinates for the vertical orientation
        tempB[0].x = b[0].x;
        tempB[0].y = b[0].y;
        tempB[1].x = b[0].x;
        tempB[1].y = b[0].y - Block.SIZE;
        tempB[2].x = b[0].x;
        tempB[2].y = b[0].y + Block.SIZE;
        tempB[3].x = b[0].x;
        tempB[3].y = b[0].y + Block.SIZE * 2;

        updateXY(2);
    }

    // Simplify getDirection3 and getDirection4 by reusing previous directions
    public void getDirection3() {
        getDirection1();
    }

    public void getDirection4() {
        getDirection2();
    }
}
