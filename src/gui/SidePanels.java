package gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SidePanels extends JPanel{
	public JTextField level;
	private JTextField levelValue;
	public SidePanels(boolean left){
		//instance = this;
		if (left){
			//set grid
			setLayout(new GridLayout(2,0));
			//set color
			setBackground(new Color(0,255,255));
			JLabel label = new JLabel("Level");
			
			level = new JTextField(15);
			level.setEditable(false);
			levelValue = level;
			add(label);
			add(level);
			
		}
		if (!left){
			//set grid
			setLayout(new GridLayout(2,0));
			//set color
			setBackground(new Color(0,255,85));
			JLabel label = new JLabel("Level");
			
			level = new JTextField(15);
			level.setEditable(false);
			levelValue = level;
			add(label);
			add(level);
			
		}
	}
	public void setLevel(int level){
		levelValue.setText(Integer.toString(level));
	}
	public void setScore(int level){
		levelValue.setText(Integer.toString(level));
	}
}
