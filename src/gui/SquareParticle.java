package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class SquareParticle {
	private Color color;
	Dimension position;
	int direction;
	double speed;
	int size;
	//private Dimension startingPosition;
	//private int startingSize;
	public SquareParticle(Dimension position, int size) {
		color = ColorGenerator.getRandomColor();
		this.position = position;
		this.size = size;
		//this.startingPosition = position;
		//this.startingSize = size;
	}
	
	public void draw(Graphics g){
		g.setColor(color);
		g.fillRect(position.width, position.height, size, size);
	}
}
