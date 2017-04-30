package game;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;

import sun.applet.Main;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import gui.ControlPanel;
import gui.GameOver;
import gui.Introduction;
import gui.MiddlePanel;
import gui.NextLevelDialog;
import gui.ParticleSystemManager;
import gui.RowCorrectParticleSystem;
import gui.SidePanels;



import java.util.LinkedList;

import java.awt.Graphics;


public class GamePlay{
	
	private static MainDisplay md;
	private static Introduction id;
	private static Boolean start = false;
	private static Boolean gameStatus = true;
	public static Boolean win = false;
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
	//Needed to prevent thread conflicts with the linked lists
	ReentrantLock lock = new ReentrantLock();

	private int level;
	private int score;
	private LinkedList<BlockRow> blocks;
	private ParticleSystemManager psm;
	//Speed is in pixels per second
	private double speed;
	private int numBlocks;
	//private int rightEdge;
	//private int blockPaneHeight = ControlPanel.GAME_PANEL_HEIGHT;
	private int blockPaneHeight = 685;
	private int blockPaneWidth = 500;
	
	public void setBlockPaneHeight(int nh){
		blockPaneHeight = nh;
	}
	public void setBlockPaneWidth(int nh){
		blockPaneWidth = nh;
	}

	public GamePlay() {
		blocks = new LinkedList<BlockRow>();
		level = 1;

		speed = 100;
		numBlocks = 3;
		psm = new ParticleSystemManager();

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
		return false;
	}
	
	//Not used???
	private void endGame(){
		System.exit(0);
	}
	
	//adds to the score, handles the next level dialog
	public void incrementScore(){
		score++;
		
		md.setScore(score);
		if (score == 8) {
			level++;
			md.setLevel(level);
			md.setIsNewLevel(true);
			

			if(level <= 10){
				NextLevelDialog nl = new NextLevelDialog(level);
				nl.setLocationRelativeTo(null);
				nl.setVisible(true);
			}

		}
		
			
		
		
		
	}
	
	//these methods will be used to make the game harder after the user beats a level
	public void increaseSpeed() {
		speed += 50;
		reset();
	}
	public void addBit(){
		numBlocks++;
		reset();
	}

	//reset the board, should have updated speed or bit
	public void reset() {
		score = 0;
		md.setScore(score);
		blocks.clear();
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
			//the fancy particle system
			psm.addPS(new RowCorrectParticleSystem(currentBottomRowX(), currentBottomRowY()));
			//incrementScore();
			//Destroy the bottom row
			lock.lock();//Lock is needed on this operation or it may interfere with other methods
			try{
				blocks.removeLast();
			}finally{
				lock.unlock();
			}
			
			incrementScore();

		}else{
			//The guess was wrong
			
		}
	}
	//returns the center of the current bottom row horizontally
	private int currentBottomRowX(){
		int answer = 0;
		lock.lock();
		try{
			answer = blockPaneWidth - blocks.getFirst().getRowWidth() / 2;
		}finally{
			lock.unlock();
		}
		return answer;
	}
	private int currentBottomRowY(){
		int answer = 0;
		lock.lock();
		try{
			if(blocks.size() > 1){
				answer = blockPaneHeight - (Block.height + Block.spacing) / 2;
			}else{
				answer = getFloatingBlockPosition() + (Block.height + Block.spacing) / 2;
			}
		}finally{
			lock.unlock();
		}
		return answer;
	}
	//calls the check guess for the block row
	public boolean checkGuess(int guess) {
		System.out.println("checking " + guess);
		boolean result = false;
		lock.lock();
		try{
			if (blocks.getLast().checkGuess(guess)) {
				result = true;
			}
		}
		finally{
			lock.unlock();
		}
		return result;
	}
	
	
	//draws the blocks everytime update is called
	public void drawGame(Graphics g) {
		int counter = 1;
		int rightEdge = MiddlePanel.getInstance().getWidth();
		lock.lock();
		try{
			for (BlockRow b : blocks) {
				if (blocks.getFirst() == b) {
					b.draw(g, rightEdge, getFloatingBlockPosition());
				}
				else {
					b.draw(g, rightEdge, blockPaneHeight - ((blocks.size() - counter) * (Block.height + Block.spacing)));
					counter++;
				}
			}
		}finally{
			lock.unlock();
		}
		psm.draw(g);
	}
	
	//Updates the game - a new frame
	void update(){
		if(MiddlePanel.getInstance() != null){
			//blockPaneHeight = 10;
			MiddlePanel.getInstance();
		}
		
		//System.out.println("Update");
		//This is where the game checks if the row has gotten to the point where it needs
		lock.lock();
		try{
			if(blocks.size() == 0 || timeForNewBlockRow()){
				if(checkBlockStackFull()){
					//meaning there's no more room for the next block so the player loses
					gameStatus = false;
					//endGame();
					
				}else{
					//If the game's not over add a new block row
					if (level > 10){
						win = true;
						gameStatus = false;
					}
					addBlockRow();
				}
			}
		}finally{
			lock.unlock();
		}
		
		MiddlePanel.getInstance().requestRepaint();
		
	}
	
	//Figure out if the floating block is done moving - meaning it has reached the top of the stack
	boolean timeForNewBlockRow(){
		int currentPosition = getFloatingBlockPosition();
		//System.out.println("the position of the floating block is: " + currentPosition);
		int target = blockPaneHeight - (Block.height + Block.spacing) * (blocks.size());
		//System.out.println("target = " + target);
		return currentPosition > target;

	}
	
	int getFloatingBlockPosition(){
		//Move the first block in the linked list's position down.
		//Speed is in pixels per second
		double pixelsTraveled = 0.0;
		//lock.lock();
		//try{
			pixelsTraveled = (int)(speed * blocks.getFirst().getElapsedTimeSeconds());
		//}finally{
		//	lock.unlock();
		//}
		return (int)pixelsTraveled;
	}
	
	private boolean checkBlockStackFull(){
		return blocks.size() * (Block.spacing + Block.height) > blockPaneHeight;
	}
	
	//Add a new block - happens when the old one has reached the top of the stack of blocks
	private void addBlockRow(){
		BlockRow newRow = new BlockRow(numBlocks);//For now I'm using level for this
		blocks.addFirst(newRow);
	}
	

	public static void main(String[] args) {
		
		md = MainDisplay.getFrameInstance();
		md.setLocationRelativeTo(null);
		
		id = new Introduction();
		id.setLocationRelativeTo(null);
		id.setVisible(true);
		//Loops until the play button is pressed so the game doesn't begin
		while(!md.gameBegin()) {
			System.out.println();
		}
		//main will need to call update to move the block every frame like it's supposed to.
		//System.out.println(md.gameBegin());
		while(gameStatus){
			
			if (!md.isNewLevel()) {
				GamePlay.getInstance().update();
			}

		}
	
			if(!win){
				GameOver screen = new GameOver(false);
				screen.setVisible(true);
				screen.setLocationRelativeTo(null);
			}
			else{
				GameOver screen2 = new GameOver(true);
				screen2.setVisible(true);
				screen2.setLocationRelativeTo(null);
			}
		
	}
	//linked list methods that have been multithread proofed

}
