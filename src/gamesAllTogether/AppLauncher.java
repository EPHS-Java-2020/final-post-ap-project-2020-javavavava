package gamesAllTogether;

import java.util.Scanner;

import temporarySending.TileGameWork;
public class AppLauncher {

	public static void main(String[] args) {
		TileGameWork printer = new TileGameWork();
		System.out.println("Type 'shuffle' to start game");
		Scanner initial = new Scanner(System.in);
		String initializer = initial.nextLine();
		
		if(initializer.equals("shuffle")) {
			printer.randomizer(printer.getOriginal());
			//start game
			System.out.println("Type two numbers that are next to each other to switch their positions. \n Try to put the whole puzzle in numerical order. \n Type 0 when you think you have the answer.");
			printer.boardPrint(printer.getOriginal());
		} else {
			System.out.println("type shuffle to run game");
			
		}
		Scanner numberSwitcherFirst = new Scanner(System.in);
		
		Scanner numberSwitcherSecond = new Scanner(System.in);
		int nameFirst = numberSwitcherFirst.nextInt();
		int nameSecond = numberSwitcherSecond.nextInt();
		printer.switcher(nameFirst, nameSecond);
		while(nameFirst != 0) {
			 nameFirst = numberSwitcherFirst.nextInt();
			 nameSecond = numberSwitcherSecond.nextInt();
			printer.switcher(nameFirst, nameSecond);
		}
		if(printer.checker() == true) {
			System.out.print("You win!");
		}else {
			System.out.println("You lose. Try again.");
		}
		
	}
	
	
	

}
