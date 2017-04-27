package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;

import gui.ControlPanel;
import gui.MiddlePanel;
import gui.SidePanels;

public class MainDisplay extends JFrame{
	private static MainDisplay frameInstance = new MainDisplay();
	
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
		setVisible(false);

	}
	public static MainDisplay getFrameInstance() {
		return frameInstance;
	}
}
