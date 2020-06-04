package nothing;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

import gamesAllTogether.MemoryGame;
import gamesAllTogether.somethingWeird;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class TicTacToeGame implements ActionListener {
	public static JButton nextButton;
	
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
			if(secTTT<=5&&minTTT==0) {
				panelTTT.setBackground(Color.red);
			}
			if(minTTT==0&&secTTT==0) {
				timerTTT.cancel();
				timeTTT.setText("Timer done");
				button1.removeActionListener(new TicTacToeGame());
				button2.removeActionListener(new TicTacToeGame());
				button3.removeActionListener(new TicTacToeGame());
				button4.removeActionListener(new TicTacToeGame());
				button5.removeActionListener(new TicTacToeGame());
				button6.removeActionListener(new TicTacToeGame());
				button7.removeActionListener(new TicTacToeGame());
				button8.removeActionListener(new TicTacToeGame());
				button9.removeActionListener(new TicTacToeGame());
				button10.removeActionListener(new TicTacToeGame());
				button11.removeActionListener(new TicTacToeGame());
				button12.removeActionListener(new TicTacToeGame());
				button13.removeActionListener(new TicTacToeGame());
				button14.removeActionListener(new TicTacToeGame());
				button15.removeActionListener(new TicTacToeGame());
				button16.removeActionListener(new TicTacToeGame());
				
				nextButton.setVisible(false);
				whosturn.setText("SORRY, YOU LOST THE GAME");
				gameEnded = true;

			}			

		}
	};

	
	
	
	public static void main(String[] args) {
		panelTTT = new JPanel();
		JFrame frameTTT = new JFrame("TicTacToe Game");
		frameTTT.setSize(700, 750);
		frameTTT.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameTTT.add(panelTTT);

		panelTTT.setLayout(null);
		
		button1 = new JButton("");
		button1.setBounds(10, 10, 150, 150);
		button1.addActionListener(new TicTacToeGame());
		panelTTT.add(button1);
		
		button2 = new JButton("");
		button2.setBounds(161, 10, 150, 150);
		button2.addActionListener(new TicTacToeGame());
		panelTTT.add(button2);
		
		button3 = new JButton("");
		button3.setBounds(312, 10, 150, 150);
		button3.addActionListener(new TicTacToeGame());
		panelTTT.add(button3);
		
		button4 = new JButton("");
		button4.setBounds(463, 10, 150, 150);
		button4.addActionListener(new TicTacToeGame());
		panelTTT.add(button4);
		
		button5 = new JButton("");
		button5.setBounds(10, 161, 150, 150);
		button5.addActionListener(new TicTacToeGame());
		panelTTT.add(button5);
		
		button6 = new JButton("");
		button6.setBounds(161, 161, 150, 150);
		button6.addActionListener(new TicTacToeGame());
		panelTTT.add(button6);
		
		button7 = new JButton("");
		button7.setBounds(312, 161, 150, 150);
		button7.addActionListener(new TicTacToeGame());
		panelTTT.add(button7);
		
		button8 = new JButton("");
		button8.setBounds(463, 161, 150, 150);
		button8.addActionListener(new TicTacToeGame());
		panelTTT.add(button8);
		
		button9 = new JButton("");
		button9.setBounds(10, 312, 150, 150);
		button9.addActionListener(new TicTacToeGame());
		panelTTT.add(button9);
		
		button10 = new JButton("");
		button10.setBounds(161, 312, 150, 150);
		button10.addActionListener(new TicTacToeGame());
		panelTTT.add(button10);
		
		button11 = new JButton("");
		button11.setBounds(312, 312, 150, 150);
		button11.addActionListener(new TicTacToeGame());
		panelTTT.add(button11);
		
		button12 = new JButton("");
		button12.setBounds(463, 312, 150, 150);
		button12.addActionListener(new TicTacToeGame());
		panelTTT.add(button12);
		
		button13 = new JButton("");
		button13.setBounds(10, 463, 150, 150);
		button13.addActionListener(new TicTacToeGame());
		panelTTT.add(button13);
		
		button14 = new JButton("");
		button14.setBounds(161, 463, 150, 150);
		button14.addActionListener(new TicTacToeGame());
		panelTTT.add(button14);
		
		button15 = new JButton("");
		button15.setBounds(312, 463, 150, 150);
		button15.addActionListener(new TicTacToeGame());
		panelTTT.add(button15);
		
		button16 = new JButton("");
		button16.setBounds(463, 463, 150, 150);
		button16.addActionListener(new TicTacToeGame());
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
		nextButton.addActionListener(new somethingWeird());
		panelTTT.add(nextButton);
		nextButton.setVisible(false);
		////////
		
		frameTTT.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		whosturn.setBounds(10, 625, 500, 25);
		instru1.setVisible(false);
		instru2.setVisible(false);
		if (!(isFilled()) && !(gameEnded)) {
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
	public void change(JButton button) {
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
		} else if (whoWon().equals("no one")) {
			
		} else {
			button1.removeActionListener(new TicTacToeGame());
			button2.removeActionListener(new TicTacToeGame());
			button3.removeActionListener(new TicTacToeGame());
			button4.removeActionListener(new TicTacToeGame());
			button5.removeActionListener(new TicTacToeGame());
			button6.removeActionListener(new TicTacToeGame());
			button7.removeActionListener(new TicTacToeGame());
			button8.removeActionListener(new TicTacToeGame());
			button9.removeActionListener(new TicTacToeGame());
			button10.removeActionListener(new TicTacToeGame());
			button11.removeActionListener(new TicTacToeGame());
			button12.removeActionListener(new TicTacToeGame());
			button13.removeActionListener(new TicTacToeGame());
			button14.removeActionListener(new TicTacToeGame());
			button15.removeActionListener(new TicTacToeGame());
			button16.removeActionListener(new TicTacToeGame());
			
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
			button.removeActionListener(new TicTacToeGame());
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
			button.removeActionListener(new TicTacToeGame());
		}
//		if (!(gameEnded)) {
//			if (isPlayer1) {
//				isPlayer1 = false;
//				whosturn.setText("Player 2, please choose");
//				whosturn.setForeground(Color.BLUE);
//				button.setText("X");
//				button.setOpaque(true);
//				button.setBackground(Color.RED);
//				button.setForeground(Color.WHITE);
//				button.setBorderPainted(false);
//				button.removeActionListener(new TicTacToeGame());
//			} else {
//				isPlayer1 = true;
//				whosturn.setText("Player 1, please choose");
//				whosturn.setForeground(Color.RED);
//				button.setText("O");
//				button.setOpaque(true);
//				button.setBackground(Color.BLUE);
//				button.setForeground(Color.WHITE);
//				button.setBorderPainted(false);
//				button.removeActionListener(new TicTacToeGame());
//			}
//		}
	}
	public boolean isFilled() {
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

}
