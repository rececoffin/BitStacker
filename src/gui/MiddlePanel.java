package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;

import javax.swing.JPanel;

import game.GamePlay;

public class MiddlePanel extends JPanel{
	public static MiddlePanel instance = new MiddlePanel();
	public MiddlePanel(){
		instance = this;
		//set grid
		//set color
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.CENTER;
		setBackground(new Color(3,3,54));
		//mess with this
		setPreferredSize(getSize());
	}
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		System.out.println("paint component");

		GamePlay.getInstance().drawGame(g);
	}
	public void requestRepaint(){
		System.out.println("repaint");
		repaint();
	}
	static public MiddlePanel getInstance(){
		return instance;
	}
}

