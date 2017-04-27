package game;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.util.LinkedList;

import sun.applet.Main;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import gui.ControlPanel;
import gui.Introduction;
import gui.MiddlePanel;
import gui.SidePanels;



import java.util.LinkedList;

import java.awt.Graphics;


public class GamePlay extends JPanel{//Is JPanel going to go on this one?
	
	private static MainDisplay md;
	private static Introduction id;
	public static Boolean start = false;
	public int answer;
	private static GamePlay theInstance = new GamePlay();
	private int level;
	private int score;
	private LinkedList<BlockRow> blocks;
	//Speed is in pixels per second
	private double speed;
	private int rightEdge;
	private int blockPaneHeight;
	
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
				b.draw(g, rightEdge, getFloatingBlockPosition());
			}
			else {
				b.draw(g, rightEdge, blockPaneHeight - (counter * (Block.height + Block.spacing)));
				counter++;
			}
		}
	}
	
	//Updates the game - a new frame
	void update(){
		//This is where the game checks if the row has gotten to the point where it needs
		//int blockPosition = getFloatingBlockPosition();
		if(timeForNewBlockRow()){
			addBlockRow();
		}
		//May have been wrong about needing this because paintComponent might be doing the same thing.
		repaint();
	}
	//Figure out if the floating block is done moving - meaning it has reached the top of the stack
	boolean timeForNewBlockRow(){
		int currentPosition = getFloatingBlockPosition();
		int target = blockPaneHeight - (Block.height + Block.spacing) * blocks.size();
		return false;

	}
	
	int getFloatingBlockPosition(){
		//Move the first block in the linked list's position down.
		//Speed is in pixels per second
		double pixelsTraveled = (int)(speed * blocks.getFirst().getElapsedTimeSeconds());
		int rowsOnStack = blocks.size() - 1;//-1 because the moving row is not on the stack
		return rowsOnStack;
	}
	
	//Add a new block - happens when the old one has reached the top of the stack of blocks
	void addBlockRow(){
		BlockRow newRow = new BlockRow(level);//For now I'm using level for this
		blocks.addFirst(newRow);
	}
	
	public static void main(String[] args) {
		
			md = new MainDisplay();
			
			
			//md.setVisible(true);
		
		
		id = new Introduction();
		id.setVisible(true);
		
		//main will need to call update to move the block every frame like it's supposed to.
		while(true){
			GamePlay.getInstance().update();
		}
		
	}
}





//
//class IntroDisplay extends JDialog{
//	public IntroDisplay(){
//		//JFrame frame = this;
//		setSize(1250, 850);
//		//setLayout(new GridBagLayout());
//		setTitle("Bit Stacker Intro");
//		setBackground(new Color(3,3,54));
//		
//		Introduction intro = new Introduction();
//	//	Introduction intro = new Introduction(frame);
//		this.add(intro, BorderLayout.CENTER);
//
//
//	}
	
//}
