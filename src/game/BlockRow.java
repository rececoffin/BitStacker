package game;

public class BlockRow {
	private Block[] bitString;
	//private int bitValue;
	private int numBits;
	
	public BlockRow(int numBits) {
		this.numBits = numBits;
		bitString = new Block[this.numBits];
		
		for(int i = 0; i < numBits; i++){
			bitString[i] = new Block();
		}
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
//	public static void main(String [] args){
//		BlockRow row = new BlockRow(2);
//		row.setValue(4);
//		
//		row.setValue(0);
//		System.out.println("Done with 0");
//		
//		row.setValue(3);
//		
//		row.setValue(2);
//		
//		row.setValue(1);
//	}
	

}
