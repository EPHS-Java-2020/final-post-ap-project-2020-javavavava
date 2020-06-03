package gamesAllTogether;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainClass implements ActionListener {
	
	private static JButton nextButton;
	private static JPanel panel;

	public static void main(String[] args) {
		
		TitlePage titlePage = new TitlePage();
		MemoryGame memoryGame = new MemoryGame();
		RiddleGame riddleGame = new RiddleGame();
		TicTacToe ticTacToe = new TicTacToe();

		panel = new JPanel();
		JFrame frame = new JFrame();
		frame.setSize(1400, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);

		panel.setLayout(null);
		
		nextButton = new JButton("Next");
		nextButton.setBounds(245, 345, 250, 35);
		nextButton.addActionListener(new MainClass());
		panel.add(nextButton);
		
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == nextButton) {
			
		}
	}

}
