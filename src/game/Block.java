package game;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import java.util.Random;

import gui.ColorGenerator;

public class Block {
	private int bit;

	public Color blockColor;

	public static final int width = 45;
	public static final int height = 45;
	public static final int spacing = 2;
	private int position;
	public Block(int position) {
		this.position = position;
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
	private int bitValue(){
		return (int)Math.pow(2,  position);
	}
	public void draw(Graphics g, int x, int y, boolean displayBitValue) {
		//System.out.println("drawing a block at " + x + ", " + y );
		//g.fillRect(x, y, Block.width, Block.height);
		String stringToDisplay = Integer.toString(bit);
		if(displayBitValue){
			stringToDisplay += "(" + Integer.toString(bitValue()) + ")";
		}
		int horizontalTextPosition = x + (Block.width/2) - 3;
		if(displayBitValue){
			horizontalTextPosition = x + (Block.width/2) - 10;
		}
		g.setColor(blockColor);
		g.fillRect(x, y, Block.width, Block.height);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Impact", Font.PLAIN, 20));
		g.drawString(stringToDisplay, horizontalTextPosition, y + (Block.height/2) + 7);
	}
}
