package main;
 
import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			JFrame window = new JFrame("SSimple Tetris");
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window.setResizable(false);
			
			GamePanel gp = new GamePanel();  //add gamepanel to main class
			window.add(gp);
			window.pack();
			
			//gamepanel becomes size of the window 
			window.setLocationRelativeTo(null);
			window.setVisible(true);
			
			gp.launchGame();
	}

}
