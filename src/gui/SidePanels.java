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
		if (left){
			//set grid
		//	setLayout(new GridLayout(2,60));
			//set color
			setBackground(new Color(0,255,255));
			JLabel label = new JLabel("Level:");
			label.setFont(new Font("Impact", Font.PLAIN, 35));
			label.setForeground(Color.WHITE);
			level = new JTextField(3);
			level.setEditable(false);
			level.setBackground(new Color(0,255,255));
			level.setFont(new Font("Impact", Font.PLAIN, 35));
			level.setForeground(Color.WHITE);
			levelValue = level;
			add(label);
			add(level);
			
		}
		if (!left){
			
			setBackground(new Color(0,255,85));
			
			JLabel label = new JLabel("Score:");
			label.setFont(new Font("Impact", Font.PLAIN, 35));
			label.setForeground(Color.WHITE);
			score = new JTextField(3);
			score.setEditable(false);
			score.setBackground(new Color(0,255,85));
			score.setFont(new Font("Impact", Font.PLAIN, 35));
			score.setForeground(Color.WHITE);
			scoreValue = score;
			add(label);
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
