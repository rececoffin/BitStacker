package game;

import java.awt.Graphics;

public class BlockRow {
	private Block[] bitString;
	//private int bitValue;
	private int numBits;
	public int getNumBits() {
		return numBits;
	}
	private long t;
	
	public BlockRow(int numBits) {
		this.numBits = numBits;
		t = System.nanoTime();
		bitString = new Block[this.numBits];
		
		for(int i = 0; i < numBits; i++){
			bitString[i] = new Block();
		}
	}

	public Block[] getBitString() {
		return bitString;
	}

	public int getRowWidth(){
		return (Block.width + Block.spacing) * numBits - Block.spacing;
	}
	
	//calculate the value of the bits in a row
	public int calcValue() {
		int value = 0;
		for(int i = 0; i < bitString.length; i++){
			value += (bitString[i].getBit()) * (Math.pow(2, numBits - i - 1));
		}		
		return value;
	}

	public void setString(Block[] bitString) {
		this.bitString = bitString;
	}
	
	public void setValue(int bitValue) {
		System.out.println("BlockRow.setValue(" + bitValue + ") should not be called in the actual game, just for testing.");
		if(bitValue < 0){
			System.out.println("BlockRow.setValue() can't take negative values right now.");
			return;
		}
		if(bitValue >= Math.pow(2, numBits)){
			System.out.println("BlockRow.setValue() was given a value that is too large.");
			return;
		}
		for(int i = 0; i < bitString.length; i++){
			int thisBitValue =  (int) Math.pow(2, numBits - i - 1);
			if(bitValue >= thisBitValue){
				bitValue -= thisBitValue;
				bitString[i].setBit(1);
				//System.out.println("Set bit at index " + i);
			}else{
				bitString[i].setBit(0);
			}
		}
	}

	public boolean checkGuess(int i) {
		return i == calcValue();
	}
	
	public void draw(Graphics g, int rightEdge, int y) {
		//System.out.println("drawing a block row");
		for (int i = 0; i < bitString.length; ++i) {
			bitString[i].draw(g, rightEdge - ((Block.width + Block.spacing) * (numBits - i)), y);
		}
	}
	
	public double getElapsedTimeSeconds() {
		//This might not work because the long int risks losing a lot when cast to double, I haven't thought through all the details maybe it's fine
		return (double)(System.nanoTime() - t) / 1000000000.0;
	}
	
}
