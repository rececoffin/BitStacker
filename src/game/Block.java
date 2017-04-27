package game;

<<<<<<< HEAD
import java.awt.Color;
=======
import java.awt.Graphics;
>>>>>>> 8e5b70a922a19ee74f6686db6d054e0a4e21f1ac
import java.util.Random;

public class Block {
	private int bit;

	public Color blockColor;

	public static final int width = 30;
	public static final int height = 30;
	public static final int spacing = 2;
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
	public void setRandomColor(){
		Random r = new Random();
		int n = r.nextInt(7);
		switch (n){
		case 0: 
			//purple
			blockColor = new Color(153,0,255);
			break;
		case 1: 
			//pink
			blockColor = new Color(255,3,214);
			break;
		case 2: 
			//cyan
			blockColor = new Color(0,255,255);
			break;
		case 3: 
			//blue cyan weirdness
			blockColor = new Color(0,255,188);
			break;
		case 4: 
			//orange
			blockColor = new Color(255,162,0);
			break;
		case 5: 
			//another blue
			blockColor = new Color(0,145,255);
			break;
		case 6: 
			//green
			blockColor = new Color(0,255,85);
			break;
//		case 7: 
//			//
//			blockColor = new Color(0,0,0);
//			break;
		default: 
			//just in case
			blockColor = Color.WHITE;
		}
	}
	public Color getBlockColor() {
		return blockColor;
	}

	public void draw(Graphics g, int x, int y) {
		g.fillRect(x, y, Block.width, Block.height);
		g.drawString(Integer.toString(bit), x + (Block.width/2), y + (Block.height/2));
	}
}
