package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.Random;

import mino.Block;
import mino.Mino;
import mino.Mino_Bar;
import mino.Mino_L1;
import mino.Mino_L2;
import mino.Mino_Square;
import mino.Mino_T;
import mino.Mino_Z1;
import mino.Mino_Z2;

public class PlayManager {
	
	//main play area
	final int WIDTH = 360;
	final int HEIGHT = 600;
	
	public static int left_x;
	public static int right_x;
	public static int top_y;
	public static int bottom_y;
	
	
	// Mino
	Mino currentMino;
	final int MINO_START_X;
	final int MINO_START_Y;
	
	Mino nextMino;
	final int NEXTMINO_X;
	final int NEXTMINO_Y;
	public static ArrayList<Block> staticBlocks = new ArrayList<>();
	
	//auto drop
	public static int dropinterval = 60;
	
	boolean gameOver;
	
	boolean effectCounterOn;
	int effectCounter;
	ArrayList<Integer> effectY = new ArrayList<>();
	
	int level =1;
	int lines;
	int score;
	
	public PlayManager() {
		//main play area
		
		left_x = (GamePanel.WIDTH/2) - (WIDTH/2);
		right_x = left_x + WIDTH;
		top_y = 50;
		bottom_y = top_y + HEIGHT;
		
		MINO_START_X = left_x + (WIDTH/2) - Block.SIZE;
		MINO_START_Y = top_y + Block.SIZE;
		
		NEXTMINO_X = right_x + 175;
		NEXTMINO_Y = top_y + 500;
		
		//setting start mino
		currentMino = pickMino();
		currentMino.setXY(MINO_START_X, MINO_START_Y);
		nextMino = pickMino();
		nextMino.setXY(NEXTMINO_X, NEXTMINO_Y);
		 
	}
	
	private Mino pickMino() {
		Mino mino = null;
		int i = new Random().nextInt(7);
		switch(i) {
		case 0: mino = new Mino_L1();break;
		case 1: mino = new Mino_L2();break;
		case 2 : mino = new Mino_Square();break;
		case 3 : mino = new Mino_Bar();break;
		case 4 : mino = new Mino_T();break;
		case 5 : mino = new Mino_Z1();break;
		case 6 : mino = new Mino_Z2();break;
		}
		return mino;
		
	}
	
	public void update() {
		
		if(currentMino.active == false) {
			staticBlocks.add(currentMino.b[0]);
			staticBlocks.add(currentMino.b[1]);
			staticBlocks.add(currentMino.b[2]);
			staticBlocks.add(currentMino.b[3]);
			
			
			if(currentMino.b[0].x == MINO_START_X && currentMino.b[0].y == MINO_START_Y) {
				gameOver = true;
			}
				
			currentMino.deactivating = false;
			
			
			currentMino = nextMino;
			currentMino.setXY(MINO_START_X, MINO_START_Y);
			nextMino = pickMino();
			nextMino.setXY(NEXTMINO_X, NEXTMINO_Y);
			
			checkDelete();
		}
		else {
			currentMino.update();
		}
	}
	
	private void checkDelete() {
		
		int x = left_x;
		int y = top_y;
		int blockCount = 0;
		int lineCount = 0;
		
		
		while(x < right_x && y < bottom_y) {
			
			for(int i = 0; i < staticBlocks.size(); i++) {
				if(staticBlocks.get(i).x == x && staticBlocks.get(i).y == y) {
					blockCount++;
				}
			}
			
			x += Block.SIZE;
			
			if(x == right_x) {
				
				if(blockCount == 12) {
					
					effectCounterOn = true;
					effectY.add(y);
					
					for(int i = staticBlocks.size()-1; i > -1; i--) {
						if(staticBlocks.get(i).y == y) {
							staticBlocks.remove(i);
						}
					}
					
					lineCount++;
					lines++;
					
					if(lines % 10 == 0 && dropinterval > 1) {
						level++;
						if(dropinterval > 10) {
							dropinterval -= 10;
						}
						else {
							dropinterval -= 1;
						}
					}
					
					for(int i = 0; i < staticBlocks.size(); i++) {
						if(staticBlocks.get(i).y < y) {
							staticBlocks.get(i).y += Block.SIZE;
						}
					}
				}
				
				blockCount = 0;
				x = left_x;
				y += Block.SIZE;
			}
		}
		
		if(lineCount > 0) {
			int singleLineScore = 10 * level;
			score += singleLineScore * lineCount;
		}
	}
	
	
	public void draw(Graphics2D g2) {
	    // Draw main play area border
	    g2.setColor(Color.WHITE); 
	    g2.setStroke(new BasicStroke(2f)); // Thicker stroke for the outer border
	    g2.drawRect(left_x - 4, top_y - 4, WIDTH + 8, HEIGHT + 8);
	    
	    // Draw the grid
	    g2.setColor(Color.LIGHT_GRAY); // Set grid color
	    g2.setStroke(new BasicStroke(1f)); // Thinner stroke for the grid
	    for (int i = 0; i <= WIDTH; i += Block.SIZE) {
	        g2.drawLine(left_x + i, top_y, left_x + i, bottom_y); // Vertical lines
	    }
	    for (int i = 0; i <= HEIGHT; i += Block.SIZE) {
	        g2.drawLine(left_x, top_y + i, right_x, top_y + i); // Horizontal lines
	    }

	    // Mini-frame
	    int x = right_x + 100;
	    int y = bottom_y - 200;
	    g2.drawRect(x, y, 200, 200);
	    g2.setFont(new Font("Monospaced", Font.PLAIN, 35));
	    g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	    g2.drawString("NEXT", x + 60, y + 60);
	    
	    g2.drawRect(x, top_y, 250, 300);
	    x += 40;
	    y = top_y + 90;
	    g2.drawString("LEVEL: " + level, x, y); y += 70;
	    g2.drawString("LINES: " + lines, x, y); y += 70;
	    g2.drawString("SCORE: " + score, x, y);
	    
	    
	    if (currentMino != null) {
	        currentMino.draw(g2);
	    }
	    
	     nextMino.draw(g2);
	     
	     for(int i = 0; i < staticBlocks.size(); i++) {
	    	 staticBlocks.get(i).draw(g2);
	     }
	     
	     if(effectCounterOn) {
	    	 effectCounter++;
	    	 
	    	 g2.setColor(Color.WHITE);
	    	 for(int i = 0; i < effectY.size(); i++) {
	    		 g2.fillRect(left_x, effectY.get(i), WIDTH, Block.SIZE);
	    	 }
	    	 
	    	 if(effectCounter == 10) {
	    		 effectCounterOn = false;
	    		 effectCounter = 0;
	    		 effectY.clear();
	    	 }
	     }
	     
	     
	    g2.setColor(Color.PINK);
	    g2.setFont(g2.getFont().deriveFont(75f));
	    if(gameOver) {
	    	x = left_x - 10;
	    	y = top_y + 320;
	    	g2.drawString("GAME OVER", x, y);
	    }
	    
	    else if (KeyHandler.pausePressed) {
	        x = left_x + 85;
	        y = top_y + 320;
	        g2.drawString("PAUSED", x, y);
	    }
	    
	    x = 35;
	    y = top_y + 320;
	    g2.setColor(Color.WHITE);
	    g2.setFont(new Font("ALGERIAN", Font.BOLD, 55));
	    g2.drawString("Simple Tetris", x, y);

	    // Detailed Description
	    g2.setFont(new Font("SansSerif", Font.PLAIN, 18)); 
	    y += 30; 
	    g2.drawString("Tetris is a classic puzzle game where players rotate", x, y + 20);
	    g2.drawString("and arrange falling blocks called 'minos' to form", x, y + 40);
	    g2.drawString("complete lines, which then disappear. The goal is to", x, y + 60);
	    g2.drawString("keep the play area clear and score points.", x, y + 80);

	    // Additional lines for more detail
	    g2.drawString("As the game progresses, the blocks fall faster,", x, y + 100);
	    g2.drawString("increasing the challenge and testing players' skills.", x, y + 120);
	    g2.drawString("Strategic placement is crucial to clearing multiple", x, y + 140);
	    g2.drawString("lines at once, rewarding players with higher scores.", x, y + 160);
	    g2.drawString("Mastering Tetris requires quick thinking and", x, y + 180);
	    g2.drawString("precision, making it one of the most beloved games.", x, y + 200);

	}

}
	

