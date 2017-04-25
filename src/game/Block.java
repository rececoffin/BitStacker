package game;

import java.awt.Graphics;
import java.util.Random;

public class Block {
	private int bit;
	public static final int width = 30;
	public static final int height = 30;
	public static final int spacing = 2;
	public Block() {
		bit = 0;
	}

	//generate a random bit value for a single block
	public void generateRandomBit() {
		Random rand = new Random();
		bit = rand.nextInt(2);
	}

	
	
	
	public int getBit() {
		return bit;
	}

	public void setBit(int b) {
		this.bit = b;
	}

	public void draw(Graphics g, int x, int y) {
		g.fillRect(x, y, Block.width, Block.height);
		g.drawString(Integer.toString(bit), x + (Block.width/2), y + (Block.height/2));
	}
}
