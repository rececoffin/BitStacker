package game;

public class BlockRow {
	private Block[] bitString;
	
	public BlockRow(int numBits) {
		bitString = new Block[numBits];
	}

	public Block[] getBitString() {
		return bitString;
	}

	public int calcValue() {
		return 0;
	}

	public void setString(Block[] bitString) {
		this.bitString = bitString;
		
	}
	
	

}
