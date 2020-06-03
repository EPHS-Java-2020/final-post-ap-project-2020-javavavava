package gamesAllTogether;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainClass implements ActionListener {
	
	private static JButton nextButton;
	private static JPanel panel;
	
	private static int currLevel = 0;

	public static void main(String[] args) {
		
		TitlePage titlePage = new TitlePage();
		MemoryGame memoryGame = new MemoryGame();
		RiddleGame riddleGame = new RiddleGame();
		TicTacToeGame ticTacToe = new TicTacToeGame();
		TileGame tileGame = new TileGame();

		panel = new JPanel();
		JFrame frame = new JFrame();
		frame.setSize(2000, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);

		panel.setLayout(null);
		
		if (currLevel == 0) {
			titlePage.setVisible(true);
		} else if (currLevel == 1 && !(titlePage.isRunning())) {
			titlePage.dispose();
		}
		
		nextButton = new JButton("Next");
		nextButton.setBounds(245, 345, 250, 35);
		nextButton.addActionListener(new MainClass());
		panel.add(nextButton);
		
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == nextButton) {
			currLevel++;
		}
	}

}
