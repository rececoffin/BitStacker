package gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class MiddlePanel extends JPanel{
	public MiddlePanel(){
		//set grid
		//setLayout(new GridLayout(1,0));
		//set color
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.CENTER;
		setBackground(new Color(3,3,54));
		//mess with this
		setPreferredSize(getSize());
	}
}
