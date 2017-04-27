package game;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.util.LinkedList;

import sun.applet.Main;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

import gui.ControlPanel;
import gui.Introduction;
import gui.MiddlePanel;
import gui.SidePanels;



import java.util.LinkedList;

import java.awt.Graphics;


public class GamePlay {
	
	private static MainDisplay md;
	private static IntroDisplay id;
	
	public static Boolean start = false;
	public int answer;
	private static GamePlay theInstance = new GamePlay();
	private int level;
	private int score;
	private LinkedList<BlockRow> blocks;
	private int speed;
	private int rightEdge;
	private int y;
	
	public GamePlay() {
		blocks = new LinkedList<BlockRow>();
		level = 1;
		score = 0;
		speed = 1;
	}
	public void setList(LinkedList<BlockRow> blocks) {
		this.blocks = blocks;
		
	}

	public LinkedList<BlockRow> getBlocks() {
		return blocks;
	}

	public boolean gameOver() {
		if (level >= 10) {
			return true;
		}
		else if (blocks.size() >= 10) {
			return true;
		}
		return false;
	}

	public static GamePlay getInstance() {
		return theInstance;
	}
	public void incrementScore(){
		score++;
		if (score >= 8) {
			level++;
		}
	}

	public int getScore() {   
		return score;
	}

	public void setScore(int i) {
		this.score = i;
		
	}

	public int  getLevel() {
		return level;

	}

	public boolean checkGuess(int guess) {
		if (blocks.getFirst().checkGuess(guess)) {
			blocks.removeFirst();
			incrementScore();
			return true;
		}
		return false;
	}
	
	
	public void paintComponent(Graphics g) {
		int counter = 0;
		for (BlockRow b : blocks) {
			if (blocks.getLast() == b) {
				b.draw(g, rightEdge, y);
			}
			else {
				b.draw(g, rightEdge, y - (counter * (Block.height + Block.spacing)));
				counter++;
			}
		}
	}
 
	public static void main(String[] args) {
		
			md = new MainDisplay();
			md.setVisible(true);
		
		
		id = new IntroDisplay();
		id.setVisible(true);
	}
}






class MainDisplay extends JFrame{
	public MainDisplay(){
		
		JFrame frame = new JFrame();
		setSize(900, 850);
		//setLayout(new GridBagLayout());
		setTitle("Bit Stacker");
		setBackground(new Color(3,3,54));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MiddlePanel mp = new MiddlePanel();
		SidePanels left = new SidePanels(true);
		SidePanels right = new SidePanels(false);
		ControlPanel cp = new ControlPanel();
		left.setLevel(1);
		right.setScore(0);
		FlowLayout flowLay = (FlowLayout) left.getLayout();
		flowLay.setAlignment(FlowLayout.LEFT);
		this.add(left, BorderLayout.WEST);
		
	    FlowLayout newFlow = (FlowLayout) right.getLayout();
	    newFlow.setAlignment(FlowLayout.RIGHT);
		this.add(right, BorderLayout.EAST);
		
		this.add(cp, BorderLayout.SOUTH);
		this.add(mp, BorderLayout.CENTER);

	}
}





class IntroDisplay extends JFrame{
	public IntroDisplay(){
		JFrame frame = this;
		setSize(1250, 850);
		//setLayout(new GridBagLayout());
		setTitle("Bit Stacker Intro");
		setBackground(new Color(3,3,54));
		
		Introduction intro = new Introduction(frame);
		this.add(intro, BorderLayout.CENTER);


	}
	
}
