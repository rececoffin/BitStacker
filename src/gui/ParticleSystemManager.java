package gui;

import java.awt.Graphics;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class ParticleSystemManager {
	Set<ParticleSystem> systems;
	
	public ParticleSystemManager() {
		systems = new TreeSet<ParticleSystem>();
	}
	
	
	
	public void draw(Graphics g){
		Iterator<ParticleSystem> i = systems.iterator();
		while(i.hasNext()){
			ParticleSystem ps = i.next();
			
			if(ps.drawAndIsDone(g)){
				i.remove();
			}
			
		}
	}
	public void addPS(ParticleSystem newPS){
		systems.add(newPS);
	}
}
