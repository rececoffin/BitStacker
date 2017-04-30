package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;

import javax.swing.JFrame;

import com.sun.glass.events.WindowEvent;

import gui.ControlPanel;
import gui.MiddlePanel;
import gui.SidePanels;

public class MainDisplay extends JFrame{
	public static final int MAIN_DISPLAY_HEIGHT = 850;
	private static MainDisplay frameInstance = new MainDisplay();
	MiddlePanel mp;
	SidePanels left;
	SidePanels right;
	ControlPanel cp;
	private boolean gameBegin;
	private boolean newLevel;
	
	public MainDisplay(){
		
		JFrame frame = new JFrame();
		setSize(900, MAIN_DISPLAY_HEIGHT);
		//setLayout(new GridBagLayout());
		setTitle("Bit Stacker");
		setBackground(new Color(3,3,54));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mp = MiddlePanel.getInstance();
		left = new SidePanels(true);
		right = new SidePanels(false);
		cp = new ControlPanel();
		left.setLevel(1);
		right.setScore(0);
		gameBegin = false;
		newLevel = false;
		FlowLayout flowLay = (FlowLayout) left.getLayout();
		flowLay.setAlignment(FlowLayout.LEFT);
		this.add(left, BorderLayout.WEST);
		
	    FlowLayout newFlow = (FlowLayout) right.getLayout();
	    newFlow.setAlignment(FlowLayout.RIGHT);
		this.add(right, BorderLayout.EAST);
		
		this.add(cp, BorderLayout.SOUTH);
		this.add(mp, BorderLayout.CENTER);
//		this.addWindowListener(new WindowAdapter(){
//			public void windowOpened( WindowEvent e){
//				cp.textBox.requestFocus();
//			}
//		});
		setVisible(false);

	}
	public static MainDisplay getFrameInstance() {
		return frameInstance;
	}
	
	public void setLevel(int level){
		left.setLevel(level);
	}
	
	public void setScore(int score){
		right.setScore(score);
	}
	public boolean gameBegin() {
		return gameBegin;
	}
	public void setGameBegin(boolean b) {
		gameBegin = b;
		return;
	}
	public boolean isNewLevel() {		
		return newLevel;
	}
	public void setIsNewLevel(boolean b) {
		newLevel = b;
		return;
	}
}
