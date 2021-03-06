package ifYouAreNew_goHere;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.*;

import javax.swing.ImageIcon;
//import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import gamesAllTogether.TitlePage.StartScreenHandler;
//import something.TicTacToeGame;
//import something.threeByThreeTTT;
//import something.threeByThreeTTT.Board;
import scrambleHIII.Scramble;



public class TheGame extends JFrame implements ActionListener, KeyListener, ChangeListener {

	public static void main(String[] args) throws FileNotFoundException, InterruptedException {
		titlePage();
	}
	public static JButton nextButton;
	public static int currLevel = 0;

	// goodBye
	public static JFrame frameLast;
	public static JPanel panelLast;
	public static JLabel Last1;
	public static JLabel Last2;
	public static JLabel Last3;
	public static JButton lastRestartButton;
	
	public static void goodBye() {
		panelLast = new JPanel();
		frameLast = new JFrame("You made it!! Good Bye!");
		frameLast.setSize(300, 800);
		frameLast.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameLast.add(panelLast);

		panelLast.setLayout(null);
		
		JLabel Last1 = new JLabel("So, you've made it!!!!!!! Here's your shell!!");
		Last1.setBounds(10, 35, 500, 25);
		panelLast.add(Last1);
		
		JLabel Last2 = new JLabel("I wish you all the very best of luck!");
		Last2.setBounds(10, 60, 500, 25);
		panelLast.add(Last2);
		
		JLabel Last3 = new JLabel("If you wish to play the whole game again, click \"Restart\" button.");
		Last3.setBounds(10, 85, 500, 25);
		panelLast.add(Last3);
		
		lastRestartButton = new JButton("Restart");
		lastRestartButton.setBounds(9, 120, 160, 35);
		lastRestartButton.addActionListener(new TheGame());
		panelLast.add(lastRestartButton);
		
		frameLast.setVisible(true);
	}

	
	
	
	
	

	// AARUSHI's scramble game
	// arraylists
	private static ArrayList<String> allWordsSSS; // all words 4-5 letters in length
	private static ArrayList<String> scrambledWords; // The questions after scrambling
	private static ArrayList<String> unscrambledWords; // The answers

	// important numbers
	private int scoreNumber = 0;
	private int problemNumber = 1;
	private static int toWinScore = 7;

	// display base stuff
	private static JFrame frameSSS;
	private static JPanel panelSSS;
	private static Rectangle rectSSS;

	// display front page stuff
	private static JLabel title = new JLabel("ESCAPE");
	private static JLabel beginningDirectionsLabel1 = new JLabel("You go on a submarine ride to look at wild life. "
			+ "All is well until your fuel meter marks an empty tank.");

	private static JLabel beginningDirectionsLabel2 = new JLabel(
			"As you attempt to escape your sinking subamrine to avoid death, " + "you need to grab your dive suit.");

	private static JLabel beginningDirectionsLabel3 = new JLabel(
			"Your dive suit will allow you to breathe underwater until you reach "
					+ "the mermaids in Atlantis for help.");

	private static JLabel beginningDirectionsLabel4 = new JLabel(
			"Unfortunately, to get your dive suit, you need to input 12 passwords! While you have a sheet of paper");

	private static JLabel beginningDirectionsLabel5 = new JLabel(
			"with you, they are all scrambled for privacy reasons. You must unscramble these words to get the passwords.");

	private static JLabel beginningDirectionsLabel6 = new JLabel(
			"If you get at least " + toWinScore + " correct, you will be granted acccess to your dive suit.");

	// buttons 
	private static JButton startGameButton = new JButton("START GAME");; // literally start game
	private static JButton submitButton = new JButton("SUBMIT PASSWORD"); // submit your answer to the question/ submit your password
	private static JButton escapeButton = new JButton("ESCAPE SUBMARINE"); // escape the submarine with dive suit and go to mermaids. should take to next

	// graphics to display during game control
	private static JLabel scoreLabelSSS = new JLabel(""); // tells if you got right or wrong
	private static JLabel problemLabel = new JLabel("Unscramble this word: "); // asks you the actual question with the
	// scrambled word
	private static JLabel scoreNumberLabel = new JLabel("Your Score: "); // displays the number correct you got
	private static JLabel problemNumberLabel = new JLabel("Problem Number: "); // displays which questions you're on
	private static JTextField textbox = new JTextField(); // area where user can input their answer

	//end of game controls
	private static JLabel didEscape1 = new JLabel(""); // tells you if you failed of suceeded
	private static JLabel didEscape2 = new JLabel(""); // tells you if you failed of suceeded
	//		private static JButton nextButton = new JButton("NEXT"); // proceed onto next game
	private static JButton restartButton = new JButton("RESTART"); //restart entire game


	public static void scramble() throws InterruptedException, FileNotFoundException {
		initPanels();
		startScramble();
	}

	// Create questions and answers list(scrambled/ unscrambled)
	public static void startScramble() throws InterruptedException, FileNotFoundException {

		Scanner inputSSS = new Scanner(new File("wordsList.txt"));
		allWordsSSS = new ArrayList<String>();
		scrambledWords = new ArrayList<String>();
		unscrambledWords = new ArrayList<String>();

		// Make ArrayList of all words
		while (inputSSS.hasNextLine()) {
			String word = inputSSS.nextLine();
			if (word.length() <= 5 && word.length() > 3) {
				allWordsSSS.add(word);
			}
		}

		// Make ArrayList of words used in game; will also be the answers
		int countSSS = 0;
		while (countSSS < 12) {
			int r = (int) (Math.random() * allWordsSSS.size());
			String word = allWordsSSS.get(r);

			if (canAddWord(word)) {
				unscrambledWords.add(word);
				countSSS++;
				// System.out.println(word);
			}
		}
		System.out.println();

		// Make ArrayList of scrambled word used in game; will also be the questions
		for (int i = 0; i < unscrambledWords.size(); i++) {
			String scrambledWord = scramble(unscrambledWords.get(i));
			scrambledWords.add(scrambledWord);
			// System.out.println(scrambled);
		}

	}

	public static boolean canAddWord(String word) {
		for (int j = 0; j < scrambledWords.size(); j++) {
			if (word == scrambledWords.get(j)) {
				return false;
			}
		}
		return true;
	}

	public static String scramble(String word) {
		String scrambled = "";
		ArrayList<Character> letters = new ArrayList<Character>();

		// make array of letters
		for (int i = 0; i < word.length(); i++) {
			char letter = word.charAt(i);
			letters.add(letter);
		} // use letters in rand order
		while (scrambled.length() != word.length()) {
			int r = (int) (Math.random() * letters.size());
			scrambled += letters.get(r);
			letters.remove(r);
		}

		return scrambled;
	}

	// During game controls display
	public static void initPanels() {

		frameSSS = new JFrame();
		rectSSS = new Rectangle(800, 400);
		frameSSS.setBounds(rectSSS);
		panelSSS = new JPanel();
		frameSSS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameSSS.add(panelSSS);
		panelSSS.setLayout(null);

		// add in directions
		title.setBounds(10, 25, 650, 25);
		panelSSS.add(title);

		beginningDirectionsLabel1.setBounds(10, 50, 650, 25);
		panelSSS.add(beginningDirectionsLabel1);

		beginningDirectionsLabel2.setBounds(10, 70, 650, 25);
		panelSSS.add(beginningDirectionsLabel2);

		beginningDirectionsLabel3.setBounds(10, 90, 650, 25);
		panelSSS.add(beginningDirectionsLabel3);

		beginningDirectionsLabel4.setBounds(10, 110, 700, 25);
		panelSSS.add(beginningDirectionsLabel4);

		beginningDirectionsLabel5.setBounds(10, 130, 700, 25);
		panelSSS.add(beginningDirectionsLabel5);

		beginningDirectionsLabel6.setBounds(10, 150, 550, 25);
		panelSSS.add(beginningDirectionsLabel6);

		startGameButton.setBounds(10, 180, 150, 25);
		startGameButton.addActionListener(new TheGame());
		panelSSS.add(startGameButton);

		// after START GAME button clicked
		scoreNumberLabel.setBounds(10, 20, 140, 25);
		panelSSS.add(scoreNumberLabel);
		scoreNumberLabel.hide();

		problemNumberLabel.setBounds(150, 20, 300, 25);
		panelSSS.add(problemNumberLabel);
		problemNumberLabel.hide();

		scoreLabelSSS.setBounds(10, 65, 550, 25);
		panelSSS.add(scoreLabelSSS);
		scoreLabelSSS.hide();

		problemLabel.setBounds(10, 115, 290, 25);
		panelSSS.add(problemLabel);
		problemLabel.hide();

		textbox.setBounds(10, 135, 300, 25);
		panelSSS.add(textbox);
		textbox.hide();

		submitButton.setBounds(350, 135, 150, 25);
		submitButton.addActionListener(new TheGame());
		panelSSS.add(submitButton);
		submitButton.hide();

		//END of game controls
		escapeButton.setBounds(350, 135, 150, 25);
		escapeButton.addActionListener(new TheGame());
		panelSSS.add(escapeButton);
		escapeButton.hide();

		didEscape1.setBounds(10, 25, 500, 100);
		panelSSS.add(didEscape1);
		didEscape1.hide();

		didEscape2.setBounds(10, 80, 500, 25);
		panelSSS.add(didEscape2);
		didEscape2.hide();

		/////////
		nextButton.setBounds(10, 135, 150, 25);
		nextButton.addActionListener(new TheGame());
		panelSSS.add(nextButton);
		nextButton.setVisible(false);
		//////////

		restartButton.setBounds(10, 135, 150, 25);
		restartButton.addActionListener(new TheGame());
		panelSSS.add(restartButton);
		restartButton.hide();

		frameSSS.setVisible(true);

	}

	public void problemsDisplay(boolean isLastProblem) {

		scoreNumberLabel.show();
		problemNumberLabel.show();
		problemLabel.show();
		textbox.show();
		submitButton.show();
		scoreLabelSSS.show();

		scoreNumberLabel.setText("Your Score: " + scoreNumber);
		problemNumberLabel.setText("Problem Number: " + problemNumber);

		problemLabel.setText("Unscramble this word: " + scrambledWords.get(problemNumber - 1));

		if(isLastProblem) {
			submitButton.hide();
			escapeButton.show();
		}

	}

	public boolean isCorrect() {
		String userAnswer = textbox.getText();
		return userAnswer.equals(unscrambledWords.get(problemNumber - 1));
	}












	// fourByFourTicTacToeGame
	public static boolean isPlayer1 = true;
	public static boolean gameEnded = false;

	public static JButton button1;
	public static JButton button2;
	public static JButton button3;
	public static JButton button4;
	public static JButton button5;
	public static JButton button6;
	public static JButton button7;
	public static JButton button8;
	public static JButton button9;
	public static JButton button10;
	public static JButton button11;
	public static JButton button12;
	public static JButton button13;
	public static JButton button14;
	public static JButton button15;
	public static JButton button16;

	public static boolean isClickedbutton1 = false;
	public static boolean isClickedbutton2 = false;
	public static boolean isClickedbutton3 = false;
	public static boolean isClickedbutton4 = false;
	public static boolean isClickedbutton5 = false;
	public static boolean isClickedbutton6 = false;
	public static boolean isClickedbutton7 = false;
	public static boolean isClickedbutton8 = false;
	public static boolean isClickedbutton9 = false;
	public static boolean isClickedbutton10 = false;
	public static boolean isClickedbutton11 = false;
	public static boolean isClickedbutton12 = false;
	public static boolean isClickedbutton13 = false;
	public static boolean isClickedbutton14 = false;
	public static boolean isClickedbutton15 = false;
	public static boolean isClickedbutton16 = false;

	// 1 is Player 1. 2 is Player 2.
	public static int XObutton1 = 0;
	public static int XObutton2 = 0;
	public static int XObutton3 = 0;
	public static int XObutton4 = 0;
	public static int XObutton5 = 0;
	public static int XObutton6 = 0;
	public static int XObutton7 = 0;
	public static int XObutton8 = 0;
	public static int XObutton9 = 0;
	public static int XObutton10 = 0;
	public static int XObutton11 = 0;
	public static int XObutton12 = 0;
	public static int XObutton13 = 0;
	public static int XObutton14 = 0;
	public static int XObutton15 = 0;
	public static int XObutton16 = 0;

	public static JLabel whosturn;
	public static JLabel resultTTT;
	public static JLabel instru1;
	public static JLabel instru2;

	public static JPanel panelTTT;

	// timer
	private static int secTTT =01;
	private static int minTTT = 02;
	private static JLabel timeTTT;
	private static Timer timerTTT = new Timer();
	private static TimerTask taskTTT = new TimerTask() {
		public void run() {

			secTTT--;
			if(minTTT>=1&&secTTT==0) {
				minTTT--;
				secTTT = 59;
			}
			if(secTTT<10) {//check this part 
				timeTTT.setText("Timer: 0"+minTTT+":0"+secTTT);
			}else {
				timeTTT.setText("Timer: 0"+minTTT+":"+secTTT);
			}
			if(minTTT==0&&secTTT==0) {

				whosturn.setText("SORRY, TIMER UP YOU ARE NOT WORTHY THE SHELL.");
				timerTTT.cancel();

			}

		}
	};

	public static void fourByFourTicTacToeGame() {
		panelTTT = new JPanel();
		JFrame frameTTT = new JFrame("TicTacToe Game");
		frameTTT.setSize(700, 750);
		frameTTT.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameTTT.add(panelTTT);

		panelTTT.setLayout(null);

		button1 = new JButton("");
		button1.setBounds(10, 10, 150, 150);
		button1.addActionListener(new TheGame());
		panelTTT.add(button1);

		button2 = new JButton("");
		button2.setBounds(161, 10, 150, 150);
		button2.addActionListener(new TheGame());
		panelTTT.add(button2);

		button3 = new JButton("");
		button3.setBounds(312, 10, 150, 150);
		button3.addActionListener(new TheGame());
		panelTTT.add(button3);

		button4 = new JButton("");
		button4.setBounds(463, 10, 150, 150);
		button4.addActionListener(new TheGame());
		panelTTT.add(button4);

		button5 = new JButton("");
		button5.setBounds(10, 161, 150, 150);
		button5.addActionListener(new TheGame());
		panelTTT.add(button5);

		button6 = new JButton("");
		button6.setBounds(161, 161, 150, 150);
		button6.addActionListener(new TheGame());
		panelTTT.add(button6);

		button7 = new JButton("");
		button7.setBounds(312, 161, 150, 150);
		button7.addActionListener(new TheGame());
		panelTTT.add(button7);

		button8 = new JButton("");
		button8.setBounds(463, 161, 150, 150);
		button8.addActionListener(new TheGame());
		panelTTT.add(button8);

		button9 = new JButton("");
		button9.setBounds(10, 312, 150, 150);
		button9.addActionListener(new TheGame());
		panelTTT.add(button9);

		button10 = new JButton("");
		button10.setBounds(161, 312, 150, 150);
		button10.addActionListener(new TheGame());
		panelTTT.add(button10);

		button11 = new JButton("");
		button11.setBounds(312, 312, 150, 150);
		button11.addActionListener(new TheGame());
		panelTTT.add(button11);

		button12 = new JButton("");
		button12.setBounds(463, 312, 150, 150);
		button12.addActionListener(new TheGame());
		panelTTT.add(button12);

		button13 = new JButton("");
		button13.setBounds(10, 463, 150, 150);
		button13.addActionListener(new TheGame());
		panelTTT.add(button13);

		button14 = new JButton("");
		button14.setBounds(161, 463, 150, 150);
		button14.addActionListener(new TheGame());
		panelTTT.add(button14);

		button15 = new JButton("");
		button15.setBounds(312, 463, 150, 150);
		button15.addActionListener(new TheGame());
		panelTTT.add(button15);

		button16 = new JButton("");
		button16.setBounds(463, 463, 150, 150);
		button16.addActionListener(new TheGame());
		panelTTT.add(button16);

		instru1 = new JLabel("You are Player 1. Your buddy is Player 2. Player 1 should win.");
		instru2 = new JLabel("If Player1 loses, you won't get the shell. BUT, if your buddy wins, well... your buddy is smarter than ya.");
		instru1.setBounds(10, 614, 1000, 25);
		instru2.setBounds(10, 639, 1000, 25);
		panelTTT.add(instru1);
		panelTTT.add(instru2);

		whosturn = new JLabel("Player 1, please choose");
		whosturn.setBounds(10, 670, 500, 25);
		whosturn.setForeground(Color.RED);
		panelTTT.add(whosturn);

		////////
		nextButton = new JButton("Next");
		nextButton.setBounds(10, 655, 100, 35);
		nextButton.addActionListener(new TheGame());
		panelTTT.add(nextButton);
		nextButton.setVisible(false);
		////////

		frameTTT.setVisible(true);
	}

	public static void change(JButton button) {
		if (isFilled()) {
			whosturn.setText(whoWon() + " won!!!!!!!!!!!!!!!");
			if (whoWon().equals("Player 1")) {
				nextButton.setVisible(true);
				gameEnded = true;
			} else if (whoWon().equals("Player 2")) {
				nextButton.setVisible(false);
				whosturn.setText(whoWon() + " won!!!!" + "SORRY, YOU LOST THE GAME");
				gameEnded = true;
			}
			timerTTT.cancel();
		} else if (whoWon().equals("no one")) {

		} else {
			button1.removeActionListener(new TheGame());
			button2.removeActionListener(new TheGame());
			button3.removeActionListener(new TheGame());
			button4.removeActionListener(new TheGame());
			button5.removeActionListener(new TheGame());
			button6.removeActionListener(new TheGame());
			button7.removeActionListener(new TheGame());
			button8.removeActionListener(new TheGame());
			button9.removeActionListener(new TheGame());
			button10.removeActionListener(new TheGame());
			button11.removeActionListener(new TheGame());
			button12.removeActionListener(new TheGame());
			button13.removeActionListener(new TheGame());
			button14.removeActionListener(new TheGame());
			button15.removeActionListener(new TheGame());
			button16.removeActionListener(new TheGame());

			whosturn.setText(whoWon() + " won!!!!!!!!!!!!!!!");
			if (whoWon().equals("Player 1")) {
				nextButton.setVisible(true);
				gameEnded = true;
				timerTTT.cancel();
			} else if (whoWon().equals("Player 2")) {
				nextButton.setVisible(false);
				whosturn.setText(whoWon() + " won!!!!" + "SORRY, YOU LOST THE GAME");
				gameEnded = true;
				timerTTT.cancel();
			}
		}
		if (isPlayer1) {
			isPlayer1 = false;
			if (!(gameEnded)) {
				whosturn.setText("Player 2, please choose");
				whosturn.setForeground(Color.BLUE);
			}
			button.setText("X");
			button.setOpaque(true);
			button.setBackground(Color.RED);
			button.setForeground(Color.WHITE);
			button.setBorderPainted(false);
			button.removeActionListener(new TheGame());
		} else {
			isPlayer1 = true;
			if (!(gameEnded)) {
				whosturn.setText("Player 1, please choose");
				whosturn.setForeground(Color.RED);
			}
			button.setText("O");
			button.setOpaque(true);
			button.setBackground(Color.BLUE);
			button.setForeground(Color.WHITE);
			button.setBorderPainted(false);
			button.removeActionListener(new TheGame());
		}
	}
	public static boolean isFilled() {
		return isClickedbutton1
				&& isClickedbutton2
				&& isClickedbutton3
				&& isClickedbutton4
				&& isClickedbutton5
				&& isClickedbutton6
				&& isClickedbutton7
				&& isClickedbutton8
				&& isClickedbutton9
				&& isClickedbutton10
				&& isClickedbutton11
				&& isClickedbutton12
				&& isClickedbutton13
				&& isClickedbutton14
				&& isClickedbutton15
				&& isClickedbutton16;
	}

	public static String whoWon() {
		for (int num = 1; num <= 2; num++) {
			if (XObutton1 == num && XObutton2 == num && XObutton3 == num && XObutton4 == num) {
				return "Player " + num;
			} else if (XObutton1 == num && XObutton5 == num && XObutton9 == num && XObutton13 == num) {
				return "Player " + num;
			} else if (XObutton1 == num && XObutton6 == num && XObutton11 == num && XObutton16 == num) {
				return "Player " + num;
			} else if (XObutton2 == num && XObutton6 == num && XObutton10 == num && XObutton14 == num) {
				return "Player " + num;
			} else if (XObutton3 == num && XObutton7 == num && XObutton11 == num && XObutton15 == num) {
				return "Player " + num;
			} else if (XObutton4 == num && XObutton8 == num && XObutton12 == num && XObutton16 == num) {
				return "Player " + num;
			} else if (XObutton4 == num && XObutton7 == num && XObutton10 == num && XObutton13 == num) {
				return "Player " + num;
			} else if (XObutton5 == num && XObutton6 == num && XObutton7 == num && XObutton8 == num) {
				return "Player " + num;
			} else if (XObutton9 == num && XObutton10 == num && XObutton11 == num && XObutton12 == num) {
				return "Player " + num;
			} else if (XObutton13 == num && XObutton14 == num && XObutton15 == num && XObutton16 == num) {
				return "Player " + num;
			}
		}
		return "no one";
	}











	// titlePage
	public static JLabel L1;
	public static JFrame window;
	public static Container con;
	public static JPanel titleNamePanel, startButtonPanel, startScreenPanel, goButtonPanel, imagePanel;
	public static JLabel titleNameLabel, imageLabel;
	public static ImageIcon image;
	public static Font titleButtonFont = new Font("Times New Roman", Font.BOLD, 100);
	public static Font startButtonFont = new Font("Times New Roman", Font.BOLD, 30);
	public static Font startScreenFont = new Font("Times New Roman", Font.BOLD, 24);
	public static JButton startButton, goButton;
	public static JTextArea startScreenText;
	public static JTextField jt = new JTextField();
	public static void titlePage() {

		window = new JFrame("Welcome to Jumanjee 5");
		window.setSize(1400, 800);
		window.getContentPane().setBackground(new Color(0, 105, 148));
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
		startButton.addActionListener(new TheGame());

		titleNamePanel.add(titleNameLabel);
		con.add(titleNamePanel);
		startButtonPanel.add(startButton);
		con.add(startButtonPanel);
		window.setVisible(true);

		imagePanel = new JPanel(); 
		imagePanel.setBounds(0,0,1920, 1200);
		imagePanel.setBackground(new Color(0, 105, 148));

		imageLabel = new JLabel();

		image = new ImageIcon("Game.jpg");

		imageLabel.setIcon(image);
		imagePanel.add(imageLabel);

		con.add(imagePanel);
	}

	public void startScreen( ) {

		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false); 

		startScreenPanel = new JPanel();
		startScreenPanel.setBounds(100, 100, 800, 400);
		startScreenPanel.setBackground(new Color(0, 105, 148));
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
		goButtonPanel.setBounds(185, 500, 215, 55);
		goButtonPanel.setBackground(Color.YELLOW);
		con.add(goButtonPanel);

		goButton = new JButton("Let's Go");
		goButton.setBackground(Color.YELLOW);
		goButton.setForeground(Color.RED);
		goButton.setFont(startButtonFont);
		goButton.addActionListener(new TheGame());
		goButtonPanel.add(goButton);

		con.remove(imagePanel);
	}










	// riddleGame
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

		frameRiddle = new JFrame("Riddle Game");
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
		submitbutton.addActionListener(new TheGame());
		answer.addKeyListener(new TheGame());
		panelRiddle.add(submitbutton);

		timerRiddle.schedule(taskRiddle, 1000, 1000);

		////////
		nextButton = new JButton("Next");
		nextButton.setBounds(10, 100, 100, 35);
		nextButton.addActionListener(new TheGame());
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
		if (currLevel == 2) { // for riddleGame
			if(e.getKeyCode()==KeyEvent.VK_ENTER) {
				checksubmit();
			}
		} else if (currLevel == 1) { // for memoryGame
			if(e.getKeyCode()==KeyEvent.VK_ENTER) {
				String user = userText.getText();
				userText.setText("");

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
			}
		}

	}
	@Override
	public void keyReleased(KeyEvent e) {


	}

	public static void checksubmit() {//RiddleGame
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
				nextButton.setVisible(true);
			}else {
				successRiddle.setText("SORRY, YOU LOST THE GAME");
				timeRiddle.setVisible(false);
			}
			timerRiddle.cancel();

		}else {
			quesnumber++;	
		}
		questionnolabel.setText("Question number: "+(quesnumber+1));
		question.setText("Question: "+Riddles[quesnumber]);
		answer.setText("");
	}














	// memoryGame
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
		JFrame frameMemory = new JFrame("Memory Game");
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
		startTheGameButton.addActionListener(new TheGame());
		panelMemory.add(startTheGameButton);

		listOfWords = new JLabel("");
		listOfWords.setBounds(10, 270, 2000, 30);
		panelMemory.add(listOfWords);
		listOfWords.setVisible(false);

		doneMemorizing = new JButton("Done Memorizing");
		doneMemorizing.setBounds(9, 235, 160, 35);
		doneMemorizing.addActionListener(new TheGame());
		panelMemory.add(doneMemorizing);
		doneMemorizing.setVisible(false);


		typeLabel = new JLabel("Type");
		typeLabel.setBounds(10, 345, 60, 25);
		panelMemory.add(typeLabel);
		typeLabel.setVisible(false);

		userText = new JTextField(20);
		userText.setBounds(80, 345, 165, 35);
		userText.addKeyListener(new TheGame());
		panelMemory.add(userText);
		userText.setVisible(false);

		checkButton = new JButton("Check if I memorized correctly");
		checkButton.setBounds(245, 345, 250, 35);
		checkButton.addActionListener(new TheGame());
		panelMemory.add(checkButton);
		checkButton.setVisible(false);

		done = new JButton("Done spitting out what I have in my brain");
		done.setBounds(495, 345, 300, 35);
		done.addActionListener(new TheGame());
		panelMemory.add(done);
		done.setVisible(false);

		successMemory = new JLabel("Number of correct things : 0");
		successMemory.setBounds(10, 380, 300, 25);
		panelMemory.add(successMemory);
		successMemory.setVisible(false);

		getIt = new JLabel("");
		getIt.setBounds(10, 405, 300, 25);
		panelMemory.add(getIt);
		getIt.setVisible(false);

		finalSay1 = new JLabel("");
		finalSay1.setBounds(10, 405, 600, 25);
		panelMemory.add(finalSay1);
		finalSay1.setVisible(false);

		finalSay2 = new JLabel("");
		finalSay2.setBounds(10, 430, 600, 25);
		panelMemory.add(finalSay2);
		finalSay2.setVisible(false);

		finalSay3 = new JLabel("");
		finalSay3.setBounds(10, 455, 600, 25);
		panelMemory.add(finalSay3);
		finalSay3.setVisible(false);

		timeMemory = new JLabel("hey");
		timeMemory.setBounds(25, 410, 600, 175);
		panelMemory.add(timeMemory);
		timerMemory.schedule(taskMemory, 1000, 1000);

		////////
		nextButton = new JButton("Next");
		nextButton.setBounds(10, 550, 150, 35);
		nextButton.addActionListener(new TheGame());
		panelMemory.add(nextButton);
		nextButton.setVisible(false);
		////////

		frameMemory.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {

		// memoryGame
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
			userText.setText("");

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
			doneMemorizing.setVisible(false);

			startTheGameButton.setVisible(false);
			typeLabel.setVisible(true);
			userText.setVisible(true);
			checkButton.setVisible(true);
			successMemory.setVisible(true);
			getIt.setVisible(true);
			done.setVisible(true);
		} else if (e.getSource() == done) {
			taskMemory.cancel();

			checkButton.setVisible(false);
			done.setVisible(false);
			successMemory.setVisible(false);
			getIt.setVisible(false);
			typeLabel.setVisible(false);
			userText.setVisible(false);

			finalSay1.setText("So, you got " + count + " correct, which means . . .");
			finalSay1.setVisible(true);

			if (count >= 8) {
				finalSay2.setText("Well, well, well. You are smart enough to be worthy of the shell.");
				finalSay3.setText("Click the \"Next\" button to go to the next level.");
				finalSay2.setVisible(true);
				finalSay3.setVisible(true);
				nextButton.setVisible(true);
			} else {
				finalSay2.setText("you are not worthy of the shell!");
				finalSay3.setText("Bye. Adios");
				finalSay2.setVisible(true);
				finalSay3.setVisible(true);
				nextButton.setVisible(false);
			}



			// nextButton
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
				fourByFourTicTacToeGame();
			} else if (currLevel == 4){
				try {
					scramble();
				} catch (FileNotFoundException | InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (currLevel == 5) {
				goodBye();
			}
		} else if (e.getSource() == lastRestartButton) {
			currLevel = 2;
			riddleGame();


			// riddleGame
		} else if (e.getSource() == submitbutton) {
			checksubmit();




			// titlePage
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




			// scramble
		} else if (e.getSource() == startGameButton) {

			// remove preexisting items
			title.hide();
			beginningDirectionsLabel1.hide();
			beginningDirectionsLabel2.hide();
			beginningDirectionsLabel3.hide();
			beginningDirectionsLabel4.hide();
			beginningDirectionsLabel5.hide();

			beginningDirectionsLabel6.setBounds(10, 85, 550, 25);
			panelSSS.add(beginningDirectionsLabel6);

			startGameButton.hide();

			problemsDisplay(false);

		} else if ((e.getSource() == submitButton)) {

			if (isCorrect()) {
				scoreLabelSSS.setText("Correct! Good Job!");

				scoreNumber++;
				problemNumber++;

			} else {
				scoreLabelSSS.setText("Incorrect! The correct anwser is " + unscrambledWords.get(problemNumber - 1));

				problemNumber++;

			}

			if (problemNumber - 1 == 10) {
				problemsDisplay(true);
			} else {
				problemsDisplay(false);
			}

		} else if (e.getSource() == escapeButton || e.getSource() == restartButton){
			beginningDirectionsLabel6.hide();
			scoreNumberLabel.hide();
			problemNumberLabel.hide();
			problemLabel.hide();
			textbox.hide();
			scoreLabelSSS.hide();
			escapeButton.hide();

			didEscape1.show();
			didEscape2.show();

			if(scoreNumber >= toWinScore) {
				didEscape1.setText("Congrats! You escaped the submarine sucessfully with the dive suit!");
				didEscape2.setText("Click \"Next\" to proceed in the game.");
				nextButton.show();
			} else {
				didEscape1.setText("Sorry! You were not able to successfully escape the submarine with the dive suit.");
				didEscape2.setText("Click \"Restart\" to restart the game.");
				restartButton.show();
			}
		}




		// fourByFourTicTacToeGame
		if (currLevel == 3) {
			whosturn.setBounds(10, 625, 500, 25);
			instru1.setVisible(false);
			instru2.setVisible(false);
			if (isFilled()) {
				whosturn.setText(whoWon() + " won!!!!!!!!!!!!!!!");
				if (whoWon().equals("Player 1")) {
					nextButton.setVisible(true);
					gameEnded = true;
				} else if (whoWon().equals("Player 2")) {
					nextButton.setVisible(false);
					whosturn.setText(whoWon() + " won!!!!" + "SORRY, YOU LOST THE GAME");
					gameEnded = true;
				}
			}
			if (!(isFilled()) && !(gameEnded)) {
				if (e.getSource() == button1) {
					if (isClickedbutton1 == false) {
						if (isPlayer1 == true) {
							XObutton1 = 1;
						} else {
							XObutton1 = 2;
						}
						change(button1);
					}
					isClickedbutton1 = true;
				} else if (e.getSource() == button2) {
					if (isClickedbutton2 == false) {
						if (isPlayer1 == true) {
							XObutton2 = 1;
						} else {
							XObutton2 = 2;
						}
						change(button2);
					}
					isClickedbutton2 = true;
				} else if (e.getSource() == button3) {
					if (isClickedbutton3 == false) {
						if (isPlayer1 == true) {
							XObutton3 = 1;
						} else {
							XObutton3 = 2;
						}
						change(button3);
					}
					isClickedbutton3 = true;
				} else if (e.getSource() == button4) {
					if (isClickedbutton4 == false) {
						if (isPlayer1 == true) {
							XObutton4 = 1;
						} else {
							XObutton4 = 2;
						}
						change(button4);
					}
					isClickedbutton4 = true;
				} else if (e.getSource() == button5) {
					if (isClickedbutton5 == false) {
						if (isPlayer1 == true) {
							XObutton5 = 1;
						} else {
							XObutton5 = 2;
						}
						change(button5);
					}
					isClickedbutton5 = true;
				} else if (e.getSource() == button6) {
					if (isClickedbutton6 == false) {
						if (isPlayer1 == true) {
							XObutton6 = 1;
						} else {
							XObutton6 = 2;
						}
						change(button6);
					}
					isClickedbutton6 = true;
				} else if (e.getSource() == button7) {
					if (isClickedbutton7 == false) {
						if (isPlayer1 == true) {
							XObutton7 = 1;
						} else {
							XObutton7 = 2;
						}
						change(button7);
					}
					isClickedbutton7 = true;
				} else if (e.getSource() == button8) {
					if (isClickedbutton8 == false) {
						if (isPlayer1 == true) {
							XObutton8 = 1;
						} else {
							XObutton8 = 2;
						}
						change(button8);
					}
					isClickedbutton8 = true;
				} else if (e.getSource() == button9) {
					if (isClickedbutton9 == false) {
						if (isPlayer1 == true) {
							XObutton9 = 1;
						} else {
							XObutton9 = 2;
						}
						change(button9);
					}
					isClickedbutton9 = true;
				} else if (e.getSource() == button10) {
					if (isClickedbutton10 == false) {
						if (isPlayer1 == true) {
							XObutton10 = 1;
						} else {
							XObutton10 = 2;
						}
						change(button10);
					}
					isClickedbutton10 = true;
				} else if (e.getSource() == button11) {
					if (isClickedbutton11 == false) {
						if (isPlayer1 == true) {
							XObutton11 = 1;
						} else {
							XObutton11 = 2;
						}
						change(button11);
					}
					isClickedbutton11 = true;
				} else if (e.getSource() == button12) {
					if (isClickedbutton12 == false) {
						if (isPlayer1 == true) {
							XObutton12 = 1;
						} else {
							XObutton12 = 2;
						}
						change(button12);
					}
					isClickedbutton12 = true;
				} else if (e.getSource() == button13) {
					if (isClickedbutton13 == false) {
						if (isPlayer1 == true) {
							XObutton13 = 1;
						} else {
							XObutton13 = 2;
						}
						change(button13);
					}
					isClickedbutton13 = true;
				} else if (e.getSource() == button14) {
					if (isClickedbutton14 == false) {
						if (isPlayer1 == true) {
							XObutton14 = 1;
						} else {
							XObutton14 = 2;
						}
						change(button14);
					}
					isClickedbutton14 = true;
				} else if (e.getSource() == button15) {
					if (isClickedbutton15 == false) {
						if (isPlayer1 == true) {
							XObutton15 = 1;
						} else {
							XObutton15 = 2;
						}
						change(button15);
					}
					isClickedbutton15 = true;
				} else if (e.getSource() == button16) {
					if (isClickedbutton16 == false) {
						if (isPlayer1 == true) {
							XObutton16 = 1;
						} else {
							XObutton16 = 2;
						}
						change(button16);
					}
					isClickedbutton16 = true;
				}
				if (isFilled()) {
					whosturn.setText(whoWon() + " won!!!!!!!!!!!!!!!");
					if (whoWon().equals("Player 1")) {
						nextButton.setVisible(true);
						gameEnded = true;
					} else if (whoWon().equals("Player 2")) {
						nextButton.setVisible(false);
						whosturn.setText(whoWon() + " won!!!!" + "SORRY, YOU LOST THE GAME");
						gameEnded = true;
					}
				}
			} else {
				whosturn.setText(whoWon() + " won!!!!!!!!!!!!!!!");
				if (whoWon().equals("Player 1")) {
					nextButton.setVisible(true);
					gameEnded = true;
				} else if (whoWon().equals("Player 2")) {
					nextButton.setVisible(false);
					whosturn.setText(whoWon() + " won!!!!" + "SORRY, YOU LOST THE GAME");
					gameEnded = true;
				}
			}
		}

	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub

	}


}
