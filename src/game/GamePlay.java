package game;

import java.awt.Graphics;
import java.util.LinkedList;

public class GamePlay {
	private int level;
	private int score;
	private LinkedList<BlockRow> blocks;
	private int speed;
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
}
