package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.util.LinkedList;

import sun.applet.Main;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

import gui.ControlPanel;
import gui.Introduction;
import gui.MiddlePanel;
import gui.SidePanels;



import java.util.LinkedList;

public class GamePlay {
	private int level;
	private static MainDisplay md;
	private static IntroDisplay id;
	private int score;
	public static Boolean start = false;
	public int answer;
	private static GamePlay theInstance = new GamePlay();
	public void setList(LinkedList<BlockRow> blocks) {
		// TODO Auto-generated method stub
		
	}

	public boolean gameOver() {
		// TODO Auto-generated method stub
		return false;
	}
	public static GamePlay getInstance() {
		return theInstance;
	}

 
	public static void main(String[] args) {
		
			md = new MainDisplay();
			md.setVisible(true);
		
		
		id = new IntroDisplay();
		id.setVisible(true);
	}
}
class MainDisplay extends JFrame{
	public MainDisplay(){
		
		JFrame frame = new JFrame();
		setSize(900, 850);
		//setLayout(new GridBagLayout());
		setTitle("Bit Stacker");
		setBackground(new Color(3,3,54));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MiddlePanel mp = new MiddlePanel();
		SidePanels left = new SidePanels(true);
		SidePanels right = new SidePanels(false);
		ControlPanel cp = new ControlPanel();
		left.setLevel(1);
		right.setScore(0);
		FlowLayout flowLay = (FlowLayout) left.getLayout();
		flowLay.setAlignment(FlowLayout.LEFT);
		this.add(left, BorderLayout.WEST);
		
	    FlowLayout newFlow = (FlowLayout) right.getLayout();
	    newFlow.setAlignment(FlowLayout.RIGHT);
		this.add(right, BorderLayout.EAST);
		
		this.add(cp, BorderLayout.SOUTH);
		this.add(mp, BorderLayout.CENTER);

	}
}
class IntroDisplay extends JFrame{
	public IntroDisplay(){
		JFrame frame = new JFrame();
		setSize(1250, 850);
		//setLayout(new GridBagLayout());
		setTitle("Bit Stacker Intro");
		setBackground(new Color(3,3,54));
		
		Introduction intro = new Introduction(frame);
		this.add(intro, BorderLayout.CENTER);

	}

}
