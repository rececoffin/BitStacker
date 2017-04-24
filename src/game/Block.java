package game;

import java.util.Random;

public class Block {
	private int bit;
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

}
