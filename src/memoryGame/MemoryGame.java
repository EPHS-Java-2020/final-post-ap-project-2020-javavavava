package memoryGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.util.*;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class MemoryGame implements ActionListener {

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

	public static void main(String[] args) throws InterruptedException {

		allWords = new ArrayList<String>();
		allWords.add("pineapple");
		allWords.add("timer");
		allWords.add("advanced");
		allWords.add("mouse");
		allWords.add("consequence");
		allWords.add("review");
		allWords.add("abstraction");
		allWords.add("juvenile");
		allWords.add("guarantee");
		allWords.add("quantum");
		allWords.add("suggestion");
		allWords.add("injury");
		allWords.add("procrastination");
		allWords.add("calculator");
		allWords.add("standard");
		allWords.add("frame");
		allWords.add("condition");
		allWords.add("injury");
		allWords.add("scan");
		allWords.add("shepard");
		allWords.add("injury");

		repeat = new ArrayList<String>();

		words = new ArrayList<String>();

		panel = new JPanel();
		JFrame frame = new JFrame();
		frame.setSize(1000, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);

		panel.setLayout(null);

		//		JLabel dialog1 = new JLabel("Mermaid 1: Oh look! A human!");
		//		dialog1.setBounds(10, 35, 500, 25);
		//		panel.add(dialog1);
		//		
		//		JLabel dialog2 = new JLabel("You: I need your help please! My submarine is broken and I am far from home. Please help me find a way home!");
		//		dialog2.setBounds(10, 60, 1000, 25);
		//		panel.add(dialog2);
		//
		//		JLabel dialog3 = new JLabel("Mermaid 2: Human if you are found worthy, we have a device that can give you the ability to breathe underwater. You will no longer need this ugly bulky contraption of yours to find your way back home");
		//		dialog3.setBounds(10, 85, 1500, 25);
		//		panel.add(dialog3);
		//		
		//		JLabel dialog4 = new JLabel("You: Oh my gosh really? That’s great!! Where do I get it?");
		//		dialog4.setBounds(10, 110, 500, 25);
		//		panel.add(dialog4);
		//		
		//		JLabel dialog5 = new JLabel("Mermaid 1: Let us take you to our King. He will be able to explain better than we can");
		//		dialog5.setBounds(10, 135, 1000, 25);
		//		panel.add(dialog5);
		//		
		//		JLabel dialog6 = new JLabel("You: Ok cool lets go");
		//		dialog6.setBounds(10, 160, 500, 25);
		//		panel.add(dialog6);
		//		
		//		JLabel dialog7 = new JLabel("*at the king’s house*");
		//		dialog7.setBounds(10, 185, 500, 25);
		//		panel.add(dialog7);
		//		
		//		JLabel dialog8 = new JLabel("King: You need to be smart enough to be worthy of this shell");
		//		dialog8.setBounds(10, 210, 500, 25);
		//		panel.add(dialog8);
		//		
		//		JLabel dialog9 = new JLabel("King: You need to pass all of these challenges to prove that you are smart");
		//		dialog9.setBounds(10, 235, 500, 25);
		//		panel.add(dialog9);
		//		
		//		JLabel dialog10 = new JLabel("*You start the adventure and play a bunch of games and stuff*");
		//		dialog10.setBounds(10, 260, 500, 25);
		//		panel.add(dialog10);
		//		
		//		JLabel dialog11 = new JLabel("---------------------");
		//		dialog11.setBounds(10, 285, 500, 25);
		//		panel.add(dialog11);

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

		JLabel dialog16 = new JLabel("If you get at least 8 words, you will get the shell");
		dialog16.setBounds(10, 135, 500, 25);
		panel.add(dialog16);

		JLabel dialog17= new JLabel("Remember! The list of words will appear when you click \"Start the Game\" button and disappear once you click \"Done Memorizing\" button!");
		dialog17.setBounds(10, 160, 1000, 25);
		panel.add(dialog17);

		JLabel dialog18= new JLabel("Good Luck");
		dialog18.setBounds(10, 185, 500, 25);
		panel.add(dialog18);

		startTheGameButton = new JButton("Start the Game");
		startTheGameButton.setBounds(9, 210, 160, 35);
		startTheGameButton.addActionListener(new MemoryGame());
		panel.add(startTheGameButton);

		listOfWords = new JLabel("");
		listOfWords.setBounds(10, 245, 2000, 30);
		panel.add(listOfWords);
		listOfWords.setVisible(false);

		doneMemorizing = new JButton("Done Memorizing");
		doneMemorizing.setBounds(9, 210, 160, 35);
		doneMemorizing.addActionListener(new MemoryGame());
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

		checkButton = new JButton("Check");
		checkButton.setBounds(245, 345, 100, 35);
		checkButton.addActionListener(new MemoryGame());
		panel.add(checkButton);
		checkButton.show(false);
		
		done = new JButton("Done");
		done.setBounds(345, 345, 100, 35);
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

		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == startTheGameButton) {
			while (words.size() < 15) {
				int i = 0;
				while (i < allWords.size()) {
					if (words.contains(allWords.get(i))) {
						i++;
					} else {
						int yesOrNo = 0;
						yesOrNo = (int)(Math.random() * 2);
						if (yesOrNo == 0) {
							words.add(allWords.get(i));
						}
						i++;
					}
				}
			}
			listOfWords.setText(Arrays.toString(words.toArray()));

			listOfWords.setVisible(true);

			startTheGameButton.show(false);
			doneMemorizing.show(true);
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
					return;
				}
				repeat.add(user);
			}
			getIt.setText("You did NOT get it!");
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

}
