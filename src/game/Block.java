package game;


import java.awt.Color;

import java.awt.Graphics;

import java.util.Random;

import gui.ColorGenerator;

public class Block {
	private int bit;

	public Color blockColor;

	public static final int width = 45;
	public static final int height = 45;
	public static final int spacing = 2;
	public Block() {
		generateRandomBit();
		setRandomColor();
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
	public void setRandomColor(){
		blockColor = ColorGenerator.getRandomColor();
	}
	public Color getBlockColor() {
		return blockColor;
	}

	public void draw(Graphics g, int x, int y) {
		//System.out.println("drawing a block at " + x + ", " + y );
		//g.fillRect(x, y, Block.width, Block.height);
		g.setColor(blockColor);
		g.fillRect(x, y, Block.width, Block.height);
		g.setColor(Color.black);
		g.drawString(Integer.toString(bit), x + (Block.width/2), y + (Block.height/2));
	}
}
