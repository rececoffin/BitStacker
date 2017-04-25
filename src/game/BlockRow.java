package game;

public class BlockRow {
	private Block[] bitString;
	private int bitValue;
	private int numBits;
	
	public BlockRow(int numBits) {
		this.numBits = numBits;
		bitString = new Block[this.numBits];
		
		for(int i = 0; i < numBits; i++){
			bitString[i] = new Block();
		}
		
		bitValue = 0;
	}

	public Block[] getBitString() {
		return bitString;
	}

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
		this.bitValue = bitValue;
	}

	public boolean checkGuess(int i) {
		if (bitValue == i) {
			return true;
		}
		return false;
	}
	
	

}
