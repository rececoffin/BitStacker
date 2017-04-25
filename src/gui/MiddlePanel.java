package gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class MiddlePanel extends JPanel{
	public MiddlePanel(){
		//set grid
		setLayout(new GridLayout(0,0));
		//set color
		setBackground(new Color(3,3,54));
		//mess with this
		setPreferredSize(getSize());
	}
}
