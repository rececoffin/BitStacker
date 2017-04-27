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


public class GamePlay{
	
	private static MainDisplay md;
	private static Introduction id;
	private static Boolean start = false;
	
	public static Boolean getStart() {
		return start;
	}

	public static void setStart(Boolean start) {
		GamePlay.start = start;
	}
	
	private int answer;
	
	public void setAnswer(int answer) {
		this.answer = answer;
	}
	
	public int getAnswer() {
		return answer;
	}
	
	private static GamePlay theInstance = new GamePlay();
	
	public static GamePlay getInstance() {
		return theInstance;
	}
	
	private int level;
	private int score;
	private LinkedList<BlockRow> blocks;
	//Speed is in pixels per second
	private double speed;
	private int rightEdge;
	private int blockPaneHeight = ControlPanel.GAME_PANEL_HEIGHT;
	

	public GamePlay() {
		blocks = new LinkedList<BlockRow>();
		level = 1;
		score = 0;
		speed = 200;
	}
	public void setList(LinkedList<BlockRow> blocks) {
		this.blocks = blocks;
		
	}

	public LinkedList<BlockRow> getBlocks() {
		return blocks;
	}

	//game is over when they get to level 10 or the blocks rech the top of screen
	public boolean gameOver() {
		if (level >= 10) {
			return true;
		}
		else if (blocks.size() >= 10) {
			return true;
		}
		return false;
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
	//Call this when the submit button is pressed
	public void submitButton(int submission){
		if(checkGuess(submission)){
			//The guess was right
			//Destroy the bottom row
			blocks.removeLast();
		}else{
			//The guess was wrong
		}
		MiddlePanel.getInstance().requestRepaint();

	}
	
	public boolean checkGuess(int guess) {
		System.out.println("checking " + guess);
		if (blocks.getFirst().checkGuess(guess)) {
			blocks.removeFirst();
			incrementScore();
			return true;
		}
		return false;
	}
	
	
	public void drawGame(Graphics g) {
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
		//System.out.println("Update");
		//This is where the game checks if the row has gotten to the point where it needs
		System.out.println("number of blocks = " + blocks.size());
		if(blocks.size() == 0 || timeForNewBlockRow()){
			addBlockRow();
		}
		//May have been wrong about needing this because paintComponent might be doing the same thing.
		//MiddlePanel.getInstance().requestRepaint();
	}
	//Figure out if the floating block is done moving - meaning it has reached the top of the stack
	boolean timeForNewBlockRow(){
		int currentPosition = getFloatingBlockPosition();
		System.out.println("the position of the floating block is: " + currentPosition);
		int target = blockPaneHeight - (Block.height + Block.spacing) * (blocks.size());
		System.out.println("target = " + target);
		return currentPosition > target;

	}
	
	int getFloatingBlockPosition(){
		//Move the first block in the linked list's position down.
		//Speed is in pixels per second
		
		double pixelsTraveled = (int)(speed * blocks.getFirst().getElapsedTimeSeconds());
		//int rowsOnStack = blocks.size() - 1;//-1 because the moving row is not on the stack
		return (int)pixelsTraveled;
	}
	
	//Add a new block - happens when the old one has reached the top of the stack of blocks
	private void addBlockRow(){
		BlockRow newRow = new BlockRow(level);//For now I'm using level for this
		blocks.addFirst(newRow);
	}
	//void initGame(){
	//	
	//}
	public static void main(String[] args) {
		
			md = new MainDisplay();
			
			
			//md.setVisible(true);
		
		
		id = new Introduction();
		id.setVisible(true);
		int i = 0;
		//main will need to call update to move the block every frame like it's supposed to.
		while(true){
			GamePlay.getInstance().update();
			i++;
			if(i > 10000){
				break;
			}
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
