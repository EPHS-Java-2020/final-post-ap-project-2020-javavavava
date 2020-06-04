package gamesAllTogether;

import javax.swing.JPanel;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame extends JFrame {

	JPanel p=new JPanel();
	practice buttons[]=new practice[9];
	static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
	static ArrayList<Integer> siriPositions = new ArrayList<Integer>();

	public TicTacToeGame() {
		super("TicTacToe");
		setSize(400,400);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		p.setLayout(new GridLayout(3,3));
		for(int i=0; i < 9; i++) {
			buttons[i]=new practice();
			p.add(buttons[i]);
		}
		add(p);
		setVisible(true);
	}
	public static void main(String[] args) {
		new TicTacToeGame();
		char[] [] gameBoard = {{' ', '|', ' ', '|', ' '},
				{'-', '+', '-', '+', '-'},
				{' ', '|', ' ', '|', ' '},
				{'-', '+', '-', '+', '-'},
				{' ', '|', ' ', '|', ' '}};

		printGameBoard(gameBoard);



		while(true) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter ur number (1-9):");
			int playerPos= scan.nextInt();
			while(playerPositions.contains(playerPos) || siriPositions.contains(playerPositions)) {
				System.out.println("positions taken! Enter a correct position");
				playerPos = scan.nextInt();
			}

			placePiece(gameBoard, playerPos, "player" );
			String result = checkWinner();
			if(result.length() > 0) {
				System.out.println(result);
				break;
			}

			Random rand = new Random();
			int siriPos = rand.nextInt(9) + 1;
			while(playerPositions.contains(siriPos) || siriPositions.contains(siriPos)) {
				siriPos = rand.nextInt(9) + 1;
			}
			placePiece(gameBoard, siriPos, "siri" );

			printGameBoard(gameBoard); 

			result = checkWinner();
			if(result.length() > 0) {
				System.out.println(result);
				break;
			}
		}
	}


	public static void printGameBoard(char[][] gameBoard) { 
		for(char[] row : gameBoard) {
			for(char c: row) {
				System.out.print(c);
			}
			System.out.println();
		}

	}

	public static void placePiece(char[][] gameBoard, int pos, String user) {

		char symbol =' ';

		if(user.equals("player")) {
			symbol = 'X';
			playerPositions.add(pos);
		} else if(user.contentEquals("siri")) { 
			symbol = '0';
			siriPositions.add(pos);
		}

		switch(pos) {
		case 1:
			gameBoard[0][0] = symbol;
			break;
		case 2:
			gameBoard[0][2] = symbol;
			break;
		case 3:
			gameBoard[0][4] = symbol;
			break;
		case 4:
			gameBoard[2][0] = symbol;
			break;
		case 5:
			gameBoard[2][2] = symbol;
			break;
		case 6:
			gameBoard[2][4] = symbol;
			break;
		case 7:
			gameBoard[4][0] = symbol;
			break;
		case 8:
			gameBoard[4][2] = symbol;
			break;
		case 9:
			gameBoard[4][4] = symbol;
			break;
		default:
			break;
		}
	}

	public static String checkWinner() {

		List topRow = Arrays.asList(1, 2, 3);
		List midRow = Arrays.asList(4, 5, 6);
		List botRow = Arrays.asList(7, 8, 9);
		List leftCol = Arrays.asList(1, 4, 7);
		List midCol = Arrays.asList(2, 5, 8);
		List rightCol = Arrays.asList(3, 6, 9);
		List cross1 = Arrays.asList(1, 5, 9);
		List cross2 = Arrays.asList(7, 5, 3);

		List<List> winning = new ArrayList<List>();
		winning.add(topRow);
		winning.add(midRow);
		winning.add(botRow);
		winning.add(leftCol);
		winning.add(midCol);
		winning.add(rightCol);
		winning.add(cross1);
		winning.add(cross2);

		for(List l: winning) {
			if(playerPositions.containsAll(l)) {
				return "Congratulations you won! move on to the next level"; 
			} else if(siriPositions.contains(l)) {
				return "siri wins"; 
			}
		}


		return "";
	}

}


