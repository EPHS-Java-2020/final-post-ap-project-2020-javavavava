package snakeGame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.*;

public class SecondUI extends JFrame {
	
//	private static JFrame secondFrame;
	private static JPanel secondPanel;
	
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
	
	public SecondUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		secondPanel = new JPanel();
		secondPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		secondPanel.setLayout(new BorderLayout(0, 0));
		setContentPane(secondPanel);
	}

//	public static void main(String[] args) {
//		
//		secondPanel = new JPanel();
//		secondFrame = new JFrame();
//		secondFrame.setSize(1400, 800);
//		secondFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		secondFrame.add(secondPanel);
//		
//		secondPanel.setLayout(null);
//		
//		secondFrame.setVisible(true);
//
//	}

}
