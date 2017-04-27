package tests;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

import game.Block;
import game.BlockRow;
import game.GamePlay;

public class GameTests {
	
	//test that the 3 bit strings are generating a random 1 or 0
	@Test
	public void testRandomBitValues(){
		Block b1 = new Block();
		//check that 1's and 0's are 
		int oneOccur = 0;
		int zeroOccur = 0;
		for (int i = 0; i < 50; i++){
			b1.generateRandomBit();
			int bit = b1.getBit();
			//count each occur
			if(bit == 1) oneOccur++;
			else zeroOccur++;
		}
		
		//each should have occured
		assertTrue(oneOccur > 1);
		assertTrue(zeroOccur > 1);
	}
	
	//test that the binary strings are being converted to the correct decimal value
	@Test
	public void testTwoBitBinaryCoversion(){
		//two bits
		BlockRow br = new BlockRow(2);
		//get the array
		Block[] bitString = (Block[]) br.getBitString();
		bitString[0].setBit(1);
		bitString[1].setBit(0);
		//10 = 2
		br.setString(bitString);
		assertEquals(2, br.calcValue());
		
		bitString[1].setBit(1);
		//11 = 3
		br.setString(bitString);
		assertEquals(3, br.calcValue());
	}
	
	@Test
	public void testThreeBitBinaryConversion(){
		BlockRow br = new BlockRow(3);
		//get the array
		Block[] bitString = (Block[]) br.getBitString();
		bitString[0].setBit(1);
		bitString[1].setBit(0);
		bitString[2].setBit(1);
		//101 = 5
		br.setString(bitString);
		assertEquals(5, br.calcValue());
		
		bitString[1].setBit(1);
		bitString[2].setBit(0);
		//110 = 6
		br.setString(bitString);
		assertEquals(6, br.calcValue());
	}
	
	@Test
	public void testFourBitBinaryConversion(){
		BlockRow br = new BlockRow(4);
		//get the array
		Block[] bitString = (Block[]) br.getBitString();
		bitString[0].setBit(1);
		bitString[1].setBit(0);
		bitString[2].setBit(1);
		bitString[3].setBit(1);
		//1011 = 11
		br.setString(bitString);
		assertEquals(11, br.calcValue());
		
		bitString[1].setBit(1);
		bitString[2].setBit(0);
		//1101 = 13
		br.setString(bitString);
		assertEquals(13, br.calcValue());
	}
	
	
	//tests that the blocks disappear when the user puts in the correct value
	@Test
	public void testDeletingBlock(){
		LinkedList<BlockRow> blocks = new LinkedList<BlockRow>();
		GamePlay gp = new GamePlay();
		//add a couple blocks, delete the first
		blocks.add(new BlockRow(2));
		blocks.get(0).setValue(3);
		blocks.add(new BlockRow(2));
		blocks.get(1).setValue(0);
		gp.setList(blocks);
		assertEquals(2, gp.getBlocks().size());
		//user enters 3, should return true
		assertTrue(gp.checkGuess(3));
		//the block was removed
		assertEquals(1, blocks.size());
		//the score was updated
		assertEquals(1, gp.getScore());
		//the level should default to 1
		assertEquals(1, gp.getLevel());
		for(int i = 0; i < 7; i++){
			gp.incrementScore();
		}
		//after that loop, the level should change
		assertEquals(2, gp.getLevel());
		
	}
	
	//test that the game is over when a block reaches the top
	@Test
	public void testGameOver(){
		GamePlay gp = new GamePlay();
		LinkedList<BlockRow> blocks = new LinkedList<BlockRow>();
		//add 10 blocks, game should end
		for(int i = 0; i < 10; i++){
			blocks.add(new BlockRow(2));
		}
		assertEquals(10, blocks.size());
		//game should end when the size is 8
		gp.setList(blocks);
		assertTrue(gp.gameOver());
	}

}
