package gui;

import java.awt.Color;
import java.util.Random;

public class ColorGenerator {
	static ColorGenerator instance = new ColorGenerator();
	static Random random;
	
	private ColorGenerator() {
		random = new Random();
	}
	
	static public Color getRandomColor(){
		//choose a random color for every block
		int n = random.nextInt(7);
		Color c;
		switch (n){
		//cat approved colors if you need one, the black background color is (3,3,54)
		case 0: 
			//purple
			c = new Color(153,0,255);
			break;
		case 1: 
			//pink
			c = new Color(255,3,214);
			break;
		case 2: 
			//cyan
			c = new Color(0,255,255);
			break;
		case 3: 
			//blue cyan weirdness
			c = new Color(0,255,188);
			break;
		case 4: 
			//orange
			c = new Color(255,162,0);
			break;
		case 5: 
			//another blue
			c = new Color(0,145,255);
			break;
		case 6: 
			//green
			c = new Color(0,255,85);
			break;
//		case 7: 
//			//
//			blockColor = new Color(0,0,0);
//			break;
		default: 
			//just in case
			c = Color.WHITE;
		}
		return c;
	}

}
