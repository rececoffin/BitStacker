package tests;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import game.Block;
import game.BlockRow;
import game.GamePlay;
import sun.misc.Queue;

public class GameTests {
//	private Block block;
//	@Before
//	public void setUp(){
//		block = new Block();
//		
//	}
	
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
	
	
	//tests that the blocks disapear when the user puts in the correct value
	@Test
	public void testDeletingBlock(){
		//also test that the score is updated
		LinkedList<BlockRow> blocks = new LinkedList<BlockRow>();
		
		//blocks.add(new)
		
		
		//also test that it moves to the next level when they reach the correct score

	}
	
	//test that the game is over when a block reaches the top
	@Test
	public void testGameOver(){
		GamePlay gp = new GamePlay();
		LinkedList<BlockRow> blocks = new LinkedList<BlockRow>();
		//add 8 blocks, game should end
		for(int i = 0; i < 8; i++){
			blocks.add(new BlockRow(2));
		}
		assertEquals(8, blocks.size());
		//game should end when the size is 8
		gp.setList(blocks);
		assertTrue(gp.gameOver());
	}
	

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
