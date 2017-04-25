package game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.util.LinkedList;

import sun.applet.Main;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

import gui.ControlPanel;
import gui.MiddlePanel;
import gui.SidePanels;



public class GamePlay {
	private int level;
	private static MainDisplay md;
	private int score;
	public int answer;
	private static GamePlay theInstance = new GamePlay();
	public GamePlay() {
		//default the level to 1
		level = 1;
	}

	public void setList(LinkedList<BlockRow> blocks) {
		// TODO Auto-generated method 
		
	}

	public boolean gameOver() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void incrementScore(){
		
	}

	public int getScore() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setScore(int i) {
		// TODO Auto-generated method stub
		
	}

	public int  getLevel() {
		// TODO Auto-generated method stub
		return 0;
	}


	public static GamePlay getInstance() {
		return theInstance;
	}

 
	public static void main(String[] args) {
		
		md = new MainDisplay();
		md.setVisible(true);
		
	}
}
class MainDisplay extends JFrame{
	public MainDisplay(){
		JFrame frame = new JFrame();
		setSize(new Dimension(1000, 1000));
		//setLayout(new GridBagLayout());
		setTitle("Bit Stacker");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MiddlePanel mp = new MiddlePanel();
		SidePanels left = new SidePanels(true);
		SidePanels right = new SidePanels(false);
		ControlPanel cp = new ControlPanel();
		this.add(cp, BorderLayout.SOUTH);
		this.add(mp, BorderLayout.CENTER);
		this.add(right, BorderLayout.EAST);
		this.add(left, BorderLayout.WEST);
		//this.pack();
		
		
//		this.add(cp);
//		this.add(left);
//		this.add(right);
//		this.add(mp);
	}
}