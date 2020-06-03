package snakeGame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SecondPage  extends JFrame {
	
	private static JFrame secondFrame;
	private static JPanel secondPanel;

	public SecondPage() {
		
		secondPanel = new JPanel();
		secondFrame = new JFrame();
		secondFrame.setSize(800, 800);
		secondFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		secondFrame.add(secondPanel);
		
		secondPanel.setLayout(null);
		
		secondFrame.setVisible(true);

	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					SecondUI frame = new SecondUI();
					frame.setVisible(true);
				} catch (Exception e){
					e.printStackTrace();
				}
				
			}
			
		});
	}

}
