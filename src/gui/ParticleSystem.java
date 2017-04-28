package gui;

import java.awt.Graphics;

abstract public class ParticleSystem implements Comparable<ParticleSystem> {
	static int id = 0;
	protected double duration = 1;//In seconds
	protected long createdNS;
	private int instanceID;
	public ParticleSystem() {
		createdNS = System.nanoTime();
		instanceID = id;
		id++;
	}
	
	abstract boolean drawAndIsDone(Graphics g);
	
	
	//How long the ps has existed
	protected double lifeTimeInSeconds(){
		return (double)(System.nanoTime() - createdNS) / 1000000000.0;
	}
	protected double percentLifeTimeElapsed(){
		return lifeTimeInSeconds() / duration;
	}
	protected double percentLifeTimeRemaining(){
		return 1.0 - percentLifeTimeElapsed();
	}
	
	protected boolean done(){
		return lifeTimeInSeconds() > duration;
	}
	public int getInstanceID(){
		return instanceID;
	}
	@Override
	public int compareTo(ParticleSystem other) {
		return Integer.compare(this.instanceID, other.getInstanceID());
	}
}
