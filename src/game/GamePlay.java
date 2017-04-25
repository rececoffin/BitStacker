package game;

import java.util.LinkedList;

public class GamePlay {
	private int level;
	private int score;
	private LinkedList<BlockRow> blocks;
	public GamePlay() {
		blocks = new LinkedList<BlockRow>();
		level = 1;
		score = 0;
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
}
