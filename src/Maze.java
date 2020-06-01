//ROUGH DRAFT

package mazeFinalAP;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Maze extends JFrame {
	
	private int m = 10;
	private int[][] maze1 = new int[m][m];
	
	private int[][] maze = { {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
						 	 {0, 0, 0, 1, 0, 0, 0, 0, 1, 1},
						 	 {1, 1, 0, 1, 1, 0, 1, 0, 0, 1},
						 	 {1, 1, 0, 1, 1, 0, 1, 1, 0, 1},
						 	 {1, 0, 0, 1, 0, 0, 0, 1, 0, 1},
						 	 {1, 0, 1, 1, 0, 1, 0, 1, 0, 1},
						 	 {1, 0, 0, 0, 0, 1, 0, 0, 0, 1},
						 	 {1, 1, 1, 1, 0, 1, 0, 1, 1, 1},
						 	 {1, 0, 0, 0, 0, 1, 0, 0, 0, 0},
						 	 {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};

	private JLabel directions1;
	private JLabel directions2;
	private JFrame frame;
	private JPanel panel;
	private Rectangle rect;

	public Maze() {
		/**
		 * frame = new JFrame(); panel = new JPanel(); rect = new Rectangle(700, 480);
		 * directions1 = new JLabel("You need to escape your sinking submarine!");
		 * directions2= new JLabel("You must first retrieve a divesuit and then GET OUT
		 * OF THE SUBMARINE USBIJDKOLP");
		 **/

		setTitle("Maze");
		setSize(350, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/**
		 * panel.setLayout(null); panel.add(directions1); panel.add(directions2);
		 * frame.add(panel); frame.setBounds(rect); directions1.setBounds(10, 10, 700,
		 * 25); directions2.setBounds(10, 20, 700, 25); frame.setVisible(true);
		 **/
	}
	
	public void paint(Graphics g) {
		/**
		// Sets maze values
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				if (i - 1 < 0 || i + 1 >= m || j - 1 < 0 || j + 1 >= m) {
					maze[i][j] = 1;
				} else {
					maze[i][j] = (int) (Math.random() * 2);
				}
			}
		}
		maze[1][0] = 0;
		maze[m - 2][m - 1] = 9;
		maze[1][1] = 0;
		maze[m - 2][m - 2] = 0;
		*/
		super.paint(g);

		g.translate(25, 25);

		// draw the maze
		for (int row = 0; row < maze.length; row++) {
			for (int col = 0; col < maze[0].length; col++) {
				Color color;

				if (maze[row][col] == 1) {
					color = Color.GRAY;
				} else if (maze[row][col] == 0) {
					color = Color.WHITE;
				} else {
					color = Color.CYAN;
				}
				
				g.setColor(color);
				g.fillRect(30 * col, 30 * row, 30, 30);
				g.setColor(Color.BLACK);
				g.drawRect(30 * col, 30 * row, 30, 30);
			}
		}

	}

	public void processKeyEvent(KeyEvent ke) {

		if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {

		} else if (ke.getKeyCode() == KeyEvent.VK_LEFT) {

		} else if (ke.getKeyCode() == KeyEvent.VK_UP) {

		} else if (ke.getKeyCode() == KeyEvent.VK_DOWN) {

		}

	}

}