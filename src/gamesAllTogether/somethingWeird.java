package gamesAllTogether;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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



public class somethingWeird implements ActionListener, KeyListener {

	public static void main(String[] args) throws FileNotFoundException, InterruptedException {
		titlePage();
	}
	public static boolean isMemoryGameRunning = false;
	public static boolean isMRiddleGameRunning = false;
	public static JButton nextButton;
	public static int currLevel = 0;

	public static JLabel L1;
	public static JFrame window;
	public static Container con;
	public static JPanel titleNamePanel, startButtonPanel, startScreenPanel, goButtonPanel  ;
	public static JLabel titleNameLabel;
	public static Font titleButtonFont = new Font("Times New Roman", Font.BOLD, 100);
	public static Font startButtonFont = new Font("Times New Roman", Font.BOLD, 30);
	public static Font startScreenFont = new Font("Times New Roman", Font.BOLD, 24);
	public static JButton startButton, goButton;
	public static JTextArea startScreenText;
	public static JTextField jt = new JTextField();
//	StartScreenHandler a = new StartScreenHandler(); 
	

	public static void titlePage() {
		
		window = new JFrame();
		window.setTitle("Jumanjee 5");
		window.setSize(1400, 800);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setContentPane(new JLabel(new ImageIcon("Game.jpg")));
		window.setLayout(new FlowLayout());
		L1 = new JLabel();
		window.add(L1);
		window.setLayout(null);
		window.setVisible(true);
		con = window.getContentPane();
		
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(385, 100, 575, 150);
		titleNamePanel.setBackground(Color.YELLOW);
		titleNameLabel = new JLabel("Jumanjee 5");
		titleNameLabel.setForeground(Color.RED);
		titleNameLabel.setFont(titleButtonFont);
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(575, 500 , 215, 55);
		startButtonPanel.setBackground(Color.YELLOW);
		
		startButton = new JButton("Start");
		startButton.setBackground(Color.YELLOW);
		startButton.setForeground(Color.RED);
		startButton.setFont(startButtonFont);
		startButton.addActionListener(new somethingWeird());
		
		titleNamePanel.add(titleNameLabel);
		con.add(titleNamePanel);
		startButtonPanel.add(startButton);
		con.add(startButtonPanel);
		window.setVisible(true);
	}
	
	public void startScreen( ) {
		
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false); 
		
		startScreenPanel = new JPanel();
		startScreenPanel.setBounds(100, 100, 800, 250);
		startScreenPanel.setBackground(Color.yellow );
		con.add(startScreenPanel);
		
		startScreenText = new JTextArea("\"Hello There\" Welcome to Jumanjee 5 where this time it is underwater\n"
				+ "You were going to a trip and then now you are stuck in an ocean because your submarine has sunk.\n"
				+ "In order to escape the ocean you need to complete a series of tasks given.\n"
				+ "	- If you fail a task you have to start from the beginning\n"
				+ "	- If you run out of Oxygen you die\n"
				+ "	- If you get eaten by sharks in the maze you die");
		startScreenText.setBounds(100, 100, 800, 250);
		startScreenText.setBackground(new Color(0, 105, 148));
		startScreenText.setForeground(Color.white);
		startScreenText.setFont(startScreenFont);
		startScreenText.setLineWrap(true);
		startScreenPanel.add(startScreenText);
		startScreenText.setEditable(false);
		
		goButtonPanel = new JPanel();
		goButtonPanel.setBounds(685, 400, 215, 55);
		goButtonPanel.setBackground(Color.YELLOW);
		con.add(goButtonPanel);
		
		goButton = new JButton("Let's Go");
		goButton.setBackground(Color.YELLOW);
		goButton.setForeground(Color.RED);
		goButton.setFont(startButtonFont);
		goButton.addActionListener(new somethingWeird());
		goButtonPanel.add(goButton);
	}
	
//	public class StartScreenHandler implements ActionListener {
//		public void actionPerformed(ActionEvent event) {
//			startScreen();
//			
//		}
//	}
	
	
	
	
	
	
	
	
	
	

	//timer 
	private static int secRiddle =01;
	private static int minRiddle = 02;
	private static JLabel timeRiddle;
	private static Timer timerRiddle = new Timer();
	private static TimerTask taskRiddle = new TimerTask() {
		public void run() {

			secRiddle--;
			if(minRiddle>=1&&secRiddle==0) {
				minRiddle--;
				secRiddle = 59;
			}
			if(secRiddle<10) {//check this part 
				timeRiddle.setText("Timer: 0"+minRiddle+":0"+secRiddle);
			}else {
				timeRiddle.setText("Timer: 0"+minRiddle+":"+secRiddle);
			}
			if(secRiddle<=5&&minRiddle==0) {
				panelRiddle.setBackground(Color.red);
			}
			if(minRiddle==0&&secRiddle==0) {
				timerRiddle.cancel();
				timeRiddle.setText("Timer done");
				submitbutton.setVisible(false);
				questionnolabel.setVisible(false);
				question.setVisible(false);
				scoreLabel.setVisible(false);
				answer.setVisible(false);
				answerlabel.setVisible(false);
				timeRiddle.setVisible(false);

				successRiddle.setText("SORRY, YOU LOST THE GAME");

			}



			//				if(sec>=10) {
			//					time.setText("Timer: 0"+min +":"+sec);
			//				}else {
			//					time.setText("Timer: 0"+min +":0"+sec);
			//				}
			//				sec++;
			//				if(sec%60==0) {
			//					sec = 0;
			//					min++;
			//				}
			//				

		}
	};

	//game 

	private static String[] Riddles;
	private static String[] answers;
	private static int score=0;
	private static int quesnumber =0;
	private static JFrame frameRiddle;
	private static JPanel panelRiddle;
	private static JLabel successRiddle;
	private static JLabel scoreLabel;
	private static JLabel question;
	private static JLabel questionnolabel;
	private static JLabel answerlabel;
	private static JTextField answer;
	private static JButton submitbutton;



	public static void riddleGame() {


		Riddles = new String[7];
		Riddles[0] = "What has many keys but can’t open a single lock?";
		Riddles[1] = "What has to be broken before you can use it?";
		Riddles[2] = "I’m tall when I’m young, and I’m short when I’m old. What am I?";
		Riddles[3] = "What is always in front of you but can’t be seen?";
		Riddles[4] = "What can you break, even if you never pick it up or touch it?";
		Riddles[5] = "What goes up but never comes down?";
		Riddles[6] = "I shave every day, but my beard stays the same. What am I?";	

		answers = new String[7];
		answers[0] = "keyboard";
		answers[1] = "egg";
		answers[2] = "candle";
		answers[3] = "future";
		answers[4] = "promise";
		answers[5] = "age";
		answers[6] = "barber";

		frameRiddle = new JFrame();
		panelRiddle = new JPanel();
		successRiddle = new JLabel("");
		successRiddle.setBounds(125, 30, 500, 200);
		panelRiddle.add(successRiddle);
		Rectangle rect = new Rectangle(500,175);
		frameRiddle.setBounds(rect);
		frameRiddle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameRiddle.add(panelRiddle);
		panelRiddle.setLayout(null);

		timeRiddle = new JLabel("hey");
		timeRiddle.setBounds(250, 55, 100, 175);
		panelRiddle.add(timeRiddle);

		questionnolabel= new JLabel("Question number: "+(quesnumber+1));
		questionnolabel.setBounds(200, 10, 200, 25);
		panelRiddle.add(questionnolabel);

		scoreLabel = new JLabel("Score: "+score);
		scoreLabel.setBounds(10, 10, 80, 25);
		panelRiddle.add(scoreLabel);

		question = new JLabel("Question: "+Riddles[0]);
		question.setBounds(10, 40, 500, 25);
		panelRiddle.add(question);

		answerlabel = new JLabel("Answer: ");
		answerlabel.setBounds(10,70,80,25);
		panelRiddle.add(answerlabel);

		answer = new JTextField(20);
		answer.setBounds(100,70,165,25);
		panelRiddle.add(answer);

		submitbutton = new JButton("Submit");
		submitbutton.setBounds(250, 100, 80, 25);
		submitbutton.addActionListener(new somethingWeird());
		answer.addKeyListener(new somethingWeird());
		panelRiddle.add(submitbutton);

		timerRiddle.schedule(taskRiddle, 1000, 1000);

		////////
		nextButton = new JButton("Next");
		nextButton.setBounds(10, 100, 100, 35);
		nextButton.addActionListener(new somethingWeird());
		panelRiddle.add(nextButton);
		nextButton.setVisible(false);
		////////

		frameRiddle.setVisible(true);	
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}



	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			checksubmit();
		}

	}
	@Override
	public void keyReleased(KeyEvent e) {


	}

	public static void checksubmit() {
		String text = answer.getText();

		if(text.toLowerCase().trim().equals(answers[quesnumber])) {
			score++;
			scoreLabel.setText("Score: "+score);
			successRiddle.setText("CORRECT!!");

		}else {
			successRiddle.setText("INCORRECT!!");
		}
		if(quesnumber==6) {
			submitbutton.setVisible(false);
			questionnolabel.setVisible(false);
			question.setVisible(false);
			scoreLabel.setVisible(false);
			answer.setVisible(false);
			answerlabel.setVisible(false);

			if(score>=5) {
				successRiddle.setText("YEAH, YOU WON THE GAME!!");
				timerRiddle.cancel();
				timeRiddle.setVisible(false);
			}else {
				successRiddle.setText("SORRY, YOU LOST THE GAME");
			}
			timerRiddle.cancel();
			nextButton.setVisible(true);
		}else {
			quesnumber++;	
		}
		questionnolabel.setText("Question number: "+(quesnumber+1));
		question.setText("Question: "+Riddles[quesnumber]);
		answer.setText("");
	}




	
	
	
	







	private static int secMemory = 01;
	private static int minMemory = 02;
	private static JLabel timeMemory;
	private static Timer timerMemory = new Timer();
	private static TimerTask taskMemory = new TimerTask() {
		public void run() {

			secMemory--;
			if (minMemory >= 1 && secMemory == 0) {
				minMemory--;
				secMemory = 59;
			}

			if (secMemory < 10) {// check this part
				timeMemory.setText("Timer: 0" + minMemory + ":0" + secMemory);
			} else {
				timeMemory.setText("Timer: 0" + minMemory + ":" + secMemory);
			}

			if (secMemory <= 5 && minMemory == 0) {
				panelMemory.setBackground(Color.red);
			}
			if (minMemory == 0 && secMemory == 0) {
				timerMemory.cancel();

				timeMemory.setText("SORRY, YOU LOST THE GAME");
				userText.setVisible(false);
				successMemory.setVisible(false);
				getIt.setVisible(false);
				startTheGameButton.setVisible(false);
				checkButton.setVisible(false);
				listOfWords.setVisible(false);
				panelMemory.setVisible(false);
				typeLabel.setVisible(false);
				doneMemorizing.setVisible(false);
				done.setVisible(false);
				finalSay1.setVisible(false);
				finalSay2.setVisible(false);
				finalSay3.setVisible(false);

			}				

		}
	};

	private static ArrayList<String> allWords;
	private static ArrayList<String> words;
	private static int count = 0;
	private static ArrayList<String> repeat;

	private static JTextField userText; 
	private static JLabel successMemory;
	private static JLabel getIt;
	private static JButton startTheGameButton;
	private static JButton checkButton;
	private static JLabel listOfWords;
	private static JPanel panelMemory;
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

		panelMemory = new JPanel();
		JFrame frameMemory = new JFrame();
		frameMemory.setSize(1400, 800);
		frameMemory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMemory.add(panelMemory);

		panelMemory.setLayout(null);

		JLabel dialog12 = new JLabel("The LAST Game you need to do is: A Memory Game");
		dialog12.setBounds(10, 60, 500, 25);
		panelMemory.add(dialog12);

		//		JLabel dialog13 = new JLabel("You are given 30 seconds to memorize a list of words");
		//		dialog13.setBounds(10, 60, 500, 25);
		//		panel.add(dialog13);

		JLabel dialog14 = new JLabel("Type one word in the box below, then click the button to see if the word is in the list");
		dialog14.setBounds(10, 85, 1000, 25);
		panelMemory.add(dialog14);

		JLabel dialog15 = new JLabel("ONE AT A TIME");
		dialog15.setBounds(10, 110, 500, 25);
		panelMemory.add(dialog15);

		JLabel dialog16 = new JLabel("If you get at least 8 words correct, you will get the shell");
		dialog16.setBounds(10, 135, 500, 25);
		panelMemory.add(dialog16);

		JLabel dialog17= new JLabel("Remember! The list of words will appear when you click \"Start the Game\" button and disappear once you click \"Done Memorizing\" button!");
		dialog17.setBounds(10, 160, 1000, 25);
		panelMemory.add(dialog17);

		JLabel dialog18= new JLabel("You are running out of time! The timer at the end won't stop until you finish the game");
		dialog18.setBounds(10, 185, 1000, 25);
		panelMemory.add(dialog18);

		JLabel dialog13 = new JLabel("If you are still playing the game after the timer has ended, you fail. Hurry up!");
		dialog13.setBounds(10, 210, 1000, 25);
		panelMemory.add(dialog13);

		startTheGameButton = new JButton("Start the Game");
		startTheGameButton.setBounds(9, 235, 160, 35);
		startTheGameButton.addActionListener(new somethingWeird());
		panelMemory.add(startTheGameButton);

		listOfWords = new JLabel("");
		listOfWords.setBounds(10, 270, 2000, 30);
		panelMemory.add(listOfWords);
		listOfWords.setVisible(false);

		doneMemorizing = new JButton("Done Memorizing");
		doneMemorizing.setBounds(9, 235, 160, 35);
		doneMemorizing.addActionListener(new somethingWeird());
		panelMemory.add(doneMemorizing);
		doneMemorizing.setVisible(false);


		typeLabel = new JLabel("Type");
		typeLabel.setBounds(10, 345, 60, 25);
		panelMemory.add(typeLabel);
		typeLabel.show(false);

		userText = new JTextField(20);
		userText.setBounds(80, 345, 165, 35);
		panelMemory.add(userText);
		userText.show(false);

		checkButton = new JButton("Check if I memorized correctly");
		checkButton.setBounds(245, 345, 250, 35);
		checkButton.addActionListener(new somethingWeird());
		panelMemory.add(checkButton);
		checkButton.show(false);

		done = new JButton("Done spitting out what I have in my brain");
		done.setBounds(495, 345, 300, 35);
		done.addActionListener(new somethingWeird());
		panelMemory.add(done);
		done.show(false);

		successMemory = new JLabel("Number of correct things : 0");
		successMemory.setBounds(10, 380, 300, 25);
		panelMemory.add(successMemory);
		successMemory.show(false);

		getIt = new JLabel("");
		getIt.setBounds(10, 405, 300, 25);
		panelMemory.add(getIt);
		getIt.show(false);

		finalSay1 = new JLabel("");
		finalSay1.setBounds(10, 405, 600, 25);
		panelMemory.add(finalSay1);
		finalSay1.show(false);

		finalSay2 = new JLabel("");
		finalSay2.setBounds(10, 430, 600, 25);
		panelMemory.add(finalSay2);
		finalSay2.show(false);

		finalSay3 = new JLabel("");
		finalSay3.setBounds(10, 455, 600, 25);
		panelMemory.add(finalSay3);
		finalSay3.show(false);

		timeMemory = new JLabel("hey");
		timeMemory.setBounds(25, 410, 600, 175);
		panelMemory.add(timeMemory);
		timerMemory.schedule(taskMemory, 1000, 1000);

		////////
		nextButton = new JButton("Next");
		nextButton.setBounds(10, 550, 150, 35);
		nextButton.addActionListener(new somethingWeird());
		panelMemory.add(nextButton);
		nextButton.setVisible(false);
		////////

		frameMemory.setVisible(true);

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
					successMemory.setText("Number of correct things: " + count);
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
			successMemory.show(true);
			getIt.show(true);
			done.show(true);
		} else if (e.getSource() == done) {
			taskMemory.cancel();

			checkButton.show(false);
			done.show(false);
			successMemory.show(false);
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
			nextButton.setVisible(true);
		} else if (e.getSource() == nextButton) {
			currLevel++;
			if (currLevel == 1) {
				try {
					memoryGame();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (currLevel == 2) {
				riddleGame();
			} else if (currLevel == 3) {
				
			} else if (currLevel == 4) {
				
			} else if (currLevel == 5) {
				
			}
		} else if (e.getSource() == submitbutton) {
			checksubmit();
		} else if (e.getSource() == goButton) {
			currLevel++;
			try {
				memoryGame();
			} catch (FileNotFoundException | InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getSource() == startButton) {
			startScreen();
		}

	}

}
