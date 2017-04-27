package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SidePanels extends JPanel{
	public JTextField level;
	public JTextField score;
	private JTextField levelValue;
	private JTextField scoreValue;
	public SidePanels(boolean left){
		//instance = this;
		setPreferredSize(new Dimension(200, 100));
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.VERTICAL;
		//left panel
		if (left){
			//set grid
			//set color
			setBackground(new Color(0,255,255));
			JLabel label = new JLabel("Level:");
			label.setFont(new Font("Impact", Font.PLAIN, 35));
			label.setForeground(Color.WHITE);
			add(label);
			
			//updating level text field
			level = new JTextField(3);
			level.setEditable(false);
			level.setBackground(new Color(0,255,255));
			level.setFont(new Font("Impact", Font.PLAIN, 35));
			level.setForeground(Color.WHITE);
			levelValue = level;
			add(level);
			
		}
		
		//right panel
		if (!left){
			setBackground(new Color(0,255,85));
			JLabel label = new JLabel("Score:");
			label.setFont(new Font("Impact", Font.PLAIN, 35));
			label.setForeground(Color.WHITE);
			add(label);
			
			//updatnig score text field
			score = new JTextField(3);
			score.setEditable(false);
			score.setBackground(new Color(0,255,85));
			score.setFont(new Font("Impact", Font.PLAIN, 35));
			score.setForeground(Color.WHITE);
			scoreValue = score;
			add(score);
			
		}
	}
	public void setLevel(int level){
		
			levelValue.setText(Integer.toString(level));
		
		
	}
	public void setScore(int score){
		scoreValue.setText(Integer.toString(score));
	}
}
