package snakeGame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class sneakySnakegame extends JFrame{
	
	private static JPanel panel;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					sneakySnakegame frame = new sneakySnakegame();
					frame.setVisible(true);
				} catch (Exception e){
					e.printStackTrace();
				}
				
			}
			
		});
	}
	
	public sneakySnakegame() {
		panel = new JPanel();
		setSize(1400, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(panel);
		setLayout(null);
		setContentPane(panel);
		
		JLabel dialog1 = new JLabel("Mermaids: Thank you! It was a pleasure doing business with you!");
		dialog1.setBounds(1, 35, 500, 25);
		panel.add(dialog1);
		
		setVisible(true);
	}

}
