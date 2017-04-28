package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import game.Block;

public class RowCorrectParticleSystem extends ParticleSystem {
	
	List<SquareParticle> particles;
	private final int particleCount = 40;
	private final int particleStartingSize = 10;
	private final double rowCorrectSystemDuration = 0.5f;
	private int verticalCenter;
	private int middlePoint;
	private final double maxMovespeed = 450;
	public RowCorrectParticleSystem(int x, int y) {
		super();
		duration = rowCorrectSystemDuration;
		verticalCenter = y;
		middlePoint = x;
		Random r = new Random();
		particles = new ArrayList<SquareParticle>();
		for (int i = 0; i < particleCount; i++) {
			int direction;
			if(r.nextInt() % 2 == 0){
				direction = -1;
				//System.out.println("left");
			}else{
				direction = 1;
				//System.out.println("right:");
			}
			SquareParticle sp = new SquareParticle(
					new Dimension(x, y - Block.height / 2 + r.nextInt(Block.height + 1) ),
					particleStartingSize);
			sp.direction = direction;
			sp.speed = maxMovespeed * 0.0 + (maxMovespeed * 1.0) * (double)r.nextInt(10000) / 10000.0;
			particles.add(sp);
		}

	}

	@Override
	boolean drawAndIsDone(Graphics g) {
		updateSizes();
		updatePositions();
		for(SquareParticle sp : particles){
			sp.draw(g);
		}
		return done();
	}
	private void updatePositions(){
		for(SquareParticle sp : particles){
			//double direction;
			//System.out.println("");
//			if(sp.position.width < middlePoint){
//				direction = -1.0;
//				System.out.println("left");
//			}else{
//				direction = 1.0;
//				System.out.println("right:");
//			}
			sp.position.width = middlePoint + (int)((sp.speed * sp.direction) * Math.sqrt(percentLifeTimeElapsed()));
			//break;
		}
	}
	private void updateSizes(){
		for(SquareParticle sp : particles){
			sp.size = (int)((double)particleStartingSize *  percentLifeTimeRemaining());
		}
	}
}
