package snakeGame;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import memoryGame.MemoryGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;

import java.awt.*;

import javax.swing.*;

public class SnakeGame implements ActionListener {

	private static JFrame frame;
	private static JPanel panel;
	private static JButton startTheGameButton;
	
//	private static JFrame secondFrame;
//	private static JPanel secondPanel;

	public static void main(String[] args) {
		
		panel = new JPanel();
		frame = new JFrame();
		frame.setSize(1400, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);

		panel.setLayout(null);

		JLabel dialog1 = new JLabel("Mermaids: Thank you! It was a pleasure doing business with you!");
		dialog1.setBounds(10, 15, 500, 25);
		panel.add(dialog1);

		JLabel dialog2 = new JLabel("You: The pleasure is all mine. Thank yo-");
		dialog2.setBounds(10, 40, 1000, 25);
		panel.add(dialog2);

		JLabel dialog3 = new JLabel("King: You may have pleased the mermaids, but not me. You are a mere human. You cannot trick me.");
		dialog3.setBounds(10, 65, 1500, 25);
		panel.add(dialog3);

		JLabel dialog4 = new JLabel("You: Uhm.. I'm sorry. I thought we had a deal.");
		dialog4.setBounds(10, 90, 500, 25);
		panel.add(dialog4);

		JLabel dialog5 = new JLabel("King: You had a deal with the sneaky mermaids.");
		dialog5.setBounds(10, 115, 1000, 25);
		panel.add(dialog5);

		JLabel dialog6 = new JLabel("You: Oh come on. You filthy starfish");
		dialog6.setBounds(10, 140, 500, 25);
		panel.add(dialog6);

		JLabel dialog7 = new JLabel("King: You need to go through me if you wish to go home");
		dialog7.setBounds(10, 165, 500, 25);
		panel.add(dialog7);

		JLabel dialog8 = new JLabel("King: We will play the infamous Snake game");
		dialog8.setBounds(10, 190, 500, 25);
		panel.add(dialog8);

		JLabel dialog9 = new JLabel("King: You will be the snake. I will be the dot");
		dialog9.setBounds(10, 215, 500, 25);
		panel.add(dialog9);

		JLabel dialog10 = new JLabel("*If you wish to start the game, click the \"Start the Game\" button*");
		dialog10.setBounds(10, 240, 500, 25);
		panel.add(dialog10);

		JLabel dialog11 = new JLabel("---------------------");
		dialog11.setBounds(10, 265, 500, 25);
		panel.add(dialog11);
		
		startTheGameButton = new JButton("Start the Game");
		startTheGameButton.setBounds(9, 290, 160, 35);
		startTheGameButton.addActionListener(new MemoryGame());
		panel.add(startTheGameButton);

		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == startTheGameButton) {
			startTheGameButton.setVisible(false);
			
		}
		
	}

}
