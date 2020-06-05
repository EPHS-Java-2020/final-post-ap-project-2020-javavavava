package something;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class GameTitleWork {
	
	JLabel L1;

	JFrame window;
	Container con;
	JPanel titleNamePanel, startButtonPanel, startScreenPanel, goButtonPanel, imagePanel ;
	JLabel titleNameLabel, imageLabel;
	ImageIcon image; 
	Font titleButtonFont = new Font("Times New Roman", Font.BOLD, 100);
	Font startButtonFont = new Font("Times New Roman", Font.BOLD, 30);
	Font startScreenFont = new Font("Times New Roman", Font.BOLD, 24);
	JButton startButton, exitButton, goButton;
	JTextArea startScreenText;
	JTextField jt = new JTextField();
	StartScreenHandler a = new StartScreenHandler(); 
	
	
	public GameTitleWork() {
		
		window = new JFrame();
		window.setTitle("Jumanjee 5");
		window.setSize(1400, 800);
		window.getContentPane().setBackground(new Color(0, 105, 148));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setContentPane(new JLabel(new ImageIcon("Game.jpg")));
//		window.setBackground(new Color(0, 105, 148));
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
		startButton.addActionListener(a);
		
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

	public static void main (String[] args) {
		
		new GameTitleWork();
	}
	
	public void startScreen( ) {
		
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false); 
		
		startScreenPanel = new JPanel();
		startScreenPanel.setBounds(100, 100, 800, 600);
		startScreenPanel.setBackground(new Color(0, 105, 148) );
		con.add(startScreenPanel);
		
		startScreenText = new JTextArea("\"Hello There\" Welcome to Jumanjee 5 where this time it is underwater\n"
				+ "You were going to a trip and then now you are stuck in an ocean because your submarine has sunk.\n"
				+ "In order to escape the ocean you need to complete a series of tasks given.\n"
				+ "	- If you fail a task you have to start from the beginning\n"
				+ "	- If you run out of Oxygen you die\n");
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
		goButtonPanel.add(goButton);
		
	}
	
	public class StartScreenHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			startScreen();
			
		}
	}
		
		
		
	}
	
 
