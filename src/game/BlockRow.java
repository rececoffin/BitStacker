package game;

public class BlockRow {
	private Block[] bitString;
	
	public BlockRow(int numBits) {
		bitString = new Block[numBits];
		
		for(int i = 0; i < numBits; i++){
			bitString[i] = new Block();
		}
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

	public void setValue(int i) {
		// TODO Auto-generated method stub
		
	}

	public boolean checkGuess(int i) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
