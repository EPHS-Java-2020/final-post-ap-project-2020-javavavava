package gamesAllTogether;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
//import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import gamesAllTogether.TitlePage.StartScreenHandler;



public class somethingWeird implements ActionListener {

	public static void main(String[] args) throws FileNotFoundException, InterruptedException {

		memoryGame();


		//		titlePage();
	}

	private static int sec = 01;
	private static int min = 02;
	private static JLabel time;
	private static Timer timer = new Timer();
	private static TimerTask task = new TimerTask() {
		public void run() {

			sec--;
			if (min >= 1 && sec == 0) {
				min--;
				sec = 59;
			}

			if (sec < 10) {// check this part
				time.setText("Timer: 0" + min + ":0" + sec);
			} else {
				time.setText("Timer: 0" + min + ":" + sec);
			}

			//					time.setText("Timer: "+ System.out.format("%02d", min)+":"+ System.out.format("%02d", sec));
			//					
			if (sec <= 5 && min == 0) {
				panel.setBackground(Color.red);
			}
			if (min == 0 && sec == 0) {
				timer.cancel();

				time.setText("SORRY, YOU LOST THE GAME");
				userText.setVisible(false);
				success.setVisible(false);
				getIt.setVisible(false);
				startTheGameButton.setVisible(false);
				checkButton.setVisible(false);
				listOfWords.setVisible(false);
				panel.setVisible(false);
				typeLabel.setVisible(false);
				doneMemorizing.setVisible(false);
				done.setVisible(false);
				finalSay1.setVisible(false);
				finalSay2.setVisible(false);
				finalSay3.setVisible(false);

			}

			//					if(sec>=10) {
			//						time.setText("Timer: 0"+min +":"+sec);
			//					}else {
			//						time.setText("Timer: 0"+min +":0"+sec);
			//					}
			//					sec++;
			//					if(sec%60==0) {
			//						sec = 0;
			//						min++;
			//					}
			//					

		}
	};

	private static ArrayList<String> allWords;
	private static ArrayList<String> words;
	private static int count = 0;
	private static ArrayList<String> repeat;

	private static JTextField userText; 
	private static JLabel success;
	private static JLabel getIt;
	private static JButton startTheGameButton;
	private static JButton checkButton;
	private static JLabel listOfWords;
	private static JPanel panel;
	private static JLabel typeLabel;
	private static JButton doneMemorizing;
	private static JButton done;
	private static JLabel finalSay1;
	private static JLabel finalSay2;
	private static JLabel finalSay3;

	public static void memoryGame() throws InterruptedException, FileNotFoundException {

		allWords = new ArrayList<String>();

		Scanner input = new Scanner(new File("wordList.txt"));
		while (input.hasNext()) {
			String word = input.next();
			allWords.add(word);
		}

		repeat = new ArrayList<String>();

		words = new ArrayList<String>();

		panel = new JPanel();
		JFrame frame = new JFrame();
		frame.setSize(1400, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);

		panel.setLayout(null);

		JLabel dialog12 = new JLabel("The LAST Game you need to do is: A Memory Game");
		dialog12.setBounds(10, 60, 500, 25);
		panel.add(dialog12);

		//		JLabel dialog13 = new JLabel("You are given 30 seconds to memorize a list of words");
		//		dialog13.setBounds(10, 60, 500, 25);
		//		panel.add(dialog13);

		JLabel dialog14 = new JLabel("Type one word in the box below, then click the button to see if the word is in the list");
		dialog14.setBounds(10, 85, 1000, 25);
		panel.add(dialog14);

		JLabel dialog15 = new JLabel("ONE AT A TIME");
		dialog15.setBounds(10, 110, 500, 25);
		panel.add(dialog15);

		JLabel dialog16 = new JLabel("If you get at least 8 words correct, you will get the shell");
		dialog16.setBounds(10, 135, 500, 25);
		panel.add(dialog16);

		JLabel dialog17= new JLabel("Remember! The list of words will appear when you click \"Start the Game\" button and disappear once you click \"Done Memorizing\" button!");
		dialog17.setBounds(10, 160, 1000, 25);
		panel.add(dialog17);

		JLabel dialog18= new JLabel("You are running out of time! The timer at the end won't stop until you finish the game");
		dialog18.setBounds(10, 185, 1000, 25);
		panel.add(dialog18);

		JLabel dialog13 = new JLabel("If you are still playing the game after the timer has ended, you fail. Hurry up!");
		dialog13.setBounds(10, 210, 1000, 25);
		panel.add(dialog13);

		startTheGameButton = new JButton("Start the Game");
		startTheGameButton.setBounds(9, 235, 160, 35);
		startTheGameButton.addActionListener(new somethingWeird());
		panel.add(startTheGameButton);

		listOfWords = new JLabel("");
		listOfWords.setBounds(10, 270, 2000, 30);
		panel.add(listOfWords);
		listOfWords.setVisible(false);

		doneMemorizing = new JButton("Done Memorizing");
		doneMemorizing.setBounds(9, 235, 160, 35);
		doneMemorizing.addActionListener(new somethingWeird());
		panel.add(doneMemorizing);
		doneMemorizing.setVisible(false);


		typeLabel = new JLabel("Type");
		typeLabel.setBounds(10, 345, 60, 25);
		panel.add(typeLabel);
		typeLabel.show(false);

		userText = new JTextField(20);
		userText.setBounds(80, 345, 165, 35);
		panel.add(userText);
		userText.show(false);

		checkButton = new JButton("Check if I memorized correctly");
		checkButton.setBounds(245, 345, 250, 35);
		checkButton.addActionListener(new MemoryGame());
		panel.add(checkButton);
		checkButton.show(false);

		done = new JButton("Done spitting out what I have in my brain");
		done.setBounds(495, 345, 300, 35);
		done.addActionListener(new MemoryGame());
		panel.add(done);
		done.show(false);

		success = new JLabel("Number of correct things : 0");
		success.setBounds(10, 380, 300, 25);
		panel.add(success);
		success.show(false);

		getIt = new JLabel("");
		getIt.setBounds(10, 405, 300, 25);
		panel.add(getIt);
		getIt.show(false);

		finalSay1 = new JLabel("");
		finalSay1.setBounds(10, 405, 600, 25);
		panel.add(finalSay1);
		finalSay1.show(false);

		finalSay2 = new JLabel("");
		finalSay2.setBounds(10, 430, 600, 25);
		panel.add(finalSay2);
		finalSay2.show(false);

		finalSay3 = new JLabel("");
		finalSay3.setBounds(10, 455, 600, 25);
		panel.add(finalSay3);
		finalSay3.show(false);

		time = new JLabel("hey");
		time.setBounds(25, 410, 600, 175);
		panel.add(time);
		timer.schedule(task, 1000, 1000);

		frame.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == startTheGameButton) {
			int[] indexes = new int[15];
			indexes[0] = (int)(Math.random() * 10000) + 1;
			for (int i = 1; i < indexes.length; i++) {
				indexes[i] = (int)(Math.random() * 10000) + 1;
				for (int j = 0; j < i; j++) {
					if (indexes[i] == indexes[j]) {
						indexes[i] = (int)(Math.random() * 10000) + 1;
						j--;
					}
				}
			}

			for (int i = 0; i < 15; i++) {
				words.add(allWords.get(indexes[i]));
			}
			listOfWords.setText(Arrays.toString(words.toArray()));

			listOfWords.setVisible(true);

			startTheGameButton.setVisible(false);
			doneMemorizing.setVisible(true);
		} else if (e.getSource() == checkButton) {
			String user = userText.getText();

			for (String repeatedWord : repeat) {
				if (user.equals(repeatedWord)) {
					getIt.setText("You literally typed the word before. Failed");
					return;
				}
			}
			for (String word : words) {
				if (user.equals(word)) {
					count++;
					success.setText("Number of correct things: " + count);
					words.remove(word);
					getIt.setText("Successful!");
					repeat.add(user);
					return;
				}
			}
			repeat.add(user);
			getIt.setText("Failed!");
		} else if (e.getSource() == doneMemorizing) {
			listOfWords.setVisible(false);
			doneMemorizing.show(false);

			startTheGameButton.show(false);
			typeLabel.show(true);
			userText.show(true);
			checkButton.show(true);
			success.show(true);
			getIt.show(true);
			done.show(true);
		} else if (e.getSource() == done) {
			task.cancel();

			checkButton.show(false);
			done.show(false);
			success.show(false);
			getIt.show(false);
			typeLabel.show(false);
			userText.show(false);

			finalSay1.setText("So, you got " + count + " correct, which means . . .");
			finalSay1.show(true);

			if (count >= 8) {
				finalSay2.setText("YOU EARNED THE SHELL AFTER ALL!");
				finalSay3.setText("Here's your shell. You will be able to breathe underwater forever.");
			} else {
				finalSay2.setText("you are not worthy of the shell!");
				finalSay3.setText("You need to go back to the first game to try again. Bye");
			}
			finalSay2.show(true);
			finalSay3.show(true);
		}

	}
























	//	
	//	public static JLabel L1;
	//
	//	public static JFrame frame;
	//	public static Container con;
	//	public static JPanel panel, titleNamePanel, startButtonPanel, startScreenPanel, goButtonPanel  ;
	//	public static JLabel titleNameLabel;
	//	public static JLabel blahblahblah;
	//	public static Font titleButtonFont = new Font("Times New Roman", Font.BOLD, 100);
	//	public static Font startButtonFont = new Font("Times New Roman", Font.BOLD, 30);
	//	public static Font startScreenFont = new Font("Times New Roman", Font.BOLD, 24);
	//	public static JButton startButton, exitButton, goButton;
	//	public static JTextArea startScreenText;
	//	public static JTextField jt = new JTextField();
	////	StartScreenHandler a = new StartScreenHandler(); 
	//	
	//	public static void titlePage() {
	//		panel = new JPanel();
	//		frame = new JFrame();
	//		frame.setTitle("Jumanjee 5");
	//		frame.setSize(800, 600);
	//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	////		frame.setContentPane(new JLabel(new ImageIcon("Game.jpg")));
	//		frame.setLayout(new FlowLayout());
	//		L1 = new JLabel();
	//		frame.add(L1);
	//		frame.setLayout(null);
	//		frame.setVisible(true);
	//		frame.add(panel);
	////		con = frame.getContentPane();
	//		
	//		panel.setLayout(null);
	//		
	////		titleNamePanel = new JPanel();
	////		titleNamePanel.setBounds(385, 100, 575, 150);
	////		titleNamePanel.setBackground(Color.YELLOW);
	//		
	//		titleNameLabel = new JLabel("Jumanjee 5");
	//		titleNameLabel.setForeground(Color.RED);
	//		titleNameLabel.setFont(titleButtonFont);
	//		panel.add(titleNameLabel);
	//		
	////		startButtonPanel = new JPanel();
	////		startButtonPanel.setBounds(575, 500 , 215, 55);
	////		startButtonPanel.setBackground(Color.YELLOW);
	//		
	//		startButton = new JButton("Start");
	//		startButton.setBackground(Color.YELLOW);
	//		startButton.setForeground(Color.RED);
	//		startButton.setFont(startButtonFont);
	//		startButton.addActionListener(new somethingWeird());
	//		panel.add(startButton);
	//		
	////		titleNamePanel.add(titleNameLabel);
	////		con.add(titleNamePanel);
	////		startButtonPanel.add(startButton);
	////		con.add(startButtonPanel);
	//		frame.setVisible(true);
	//		
	//	}
	//	
	//	public void startScreen( ) {
	//		
	////		titleNamePanel.setVisible(false);
	////		startButtonPanel.setVisible(false); 
	//		
	//		startScreenPanel = new JPanel();
	//		startScreenPanel.setBounds(100, 100, 800, 250);
	//		startScreenPanel.setBackground(Color.yellow );
	//		con.add(startScreenPanel);
	//		
	//		startScreenText = new JTextArea("\"Hello There\" Welcome to Jumanjee 5 where this time it is underwater\n"
	//				+ "You were going to a trip and then now you are stuck in an ocean because your submarine has sunk.\n"
	//				+ "In order to escape the ocean you need to complete a series of tasks given.\n"
	//				+ "	- If you fail a task you have to start from the beginning\n"
	//				+ "	- If you run out of Oxygen you die\n"
	//				+ "	- If you get eaten by sharks in the maze you die");
	//		startScreenText.setBounds(100, 100, 800, 250);
	//		startScreenText.setBackground(new Color(0, 105, 148));
	//		startScreenText.setForeground(Color.white);
	//		startScreenText.setFont(startScreenFont);
	//		startScreenText.setLineWrap(true);
	//		startScreenPanel.add(startScreenText);
	//		startScreenText.setEditable(false);
	//		
	//		goButton = new JButton("Let's Go");
	//		goButton.setBounds(685, 400, 215, 55);
	//		goButton.setBackground(Color.YELLOW);
	//		goButton.setForeground(Color.RED);
	//		goButton.setFont(startButtonFont);
	//		panel.add(goButton);
	//	}
	//	
	////	public class StartScreenHandler implements ActionListener {
	////		public void actionPerformed(ActionEvent event) {
	////			startScreen();
	////			
	////		}
	////	}
	//
	//	@Override
	//	public void actionPerformed(ActionEvent e) {
	//		if (e.getSource() == startButton) {
	//			startScreen();
	//		} else if (e.getSource() == goButton) {
	//			frame.removeAll();
	//		}
	//		
	//	}

}
