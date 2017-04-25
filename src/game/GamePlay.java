package game;

import java.util.LinkedList;



public class GamePlay {
	private int level;
	private int score;
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
	public void submitAnswer(){
		
	}

	public static GamePlay getInstance() {
		return theInstance;
	}


}
