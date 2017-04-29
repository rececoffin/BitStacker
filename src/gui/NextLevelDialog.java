package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.GamePlay;
import game.MainDisplay;

public class NextLevelDialog extends JDialog{
	private int level;
	private static JButton faster;
	private static JButton moreBits;
	Font myFont = new Font("Impact", Font.PLAIN, 25);
	
	public NextLevelDialog(int level) {
		//Cat I need you to make this all pretty
		this.level = level;
		this.setBackground(new Color(3,3,54));
		setSize(500, 300);
		setLayout(new GridLayout(3,0));
		//column is hieght
		//add a title
		JPanel panel = addTitlePanel();
		panel.setBackground(new Color(3,3,54));
		add(panel);
		
		panel = button1();
		panel.setBackground(new Color(3,3,54));
		add(panel);
		
		panel = button2();
		panel.setBackground(new Color(3,3,54));
		add(panel);	
		
	}
	private JPanel addTitlePanel() {
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Congratulations! You beat level " + (level - 1));
		JLabel label2 = new JLabel("What would you like to do?");
		label.setForeground(new Color(178,102,255));
		label.setFont(new Font("Impact", Font.PLAIN, 25));
		label2.setForeground(new Color(178,102,255));
		label2.setFont(new Font("Impact", Font.PLAIN, 25));
		panel.add(label);
		panel.add(label2);
		
		return panel;
	}
	private JPanel button1(){
		JPanel p = new JPanel();
		faster = new JButton("Make the Blocks move faster.");
		faster.addActionListener(new ButtonListener());
		faster.setBackground(new Color(0,255,188));
		faster.setForeground(Color.WHITE);
		faster.setFont(myFont);
		p.add(faster);
		return p;
		
	}
	private JPanel button2(){
		JPanel p = new JPanel();
		moreBits = new JButton("Add one bit to the string.");
		moreBits.addActionListener(new ButtonListener());
		moreBits.setBackground(new Color(0,255,188));
		moreBits.setForeground(Color.WHITE);
		moreBits.setFont(myFont);
		p.add(moreBits);
		return p;
		
	}
	
	
	//GETTERS
	public JButton getFaster() {
		return faster;
	}
	public JButton getMoreBits() {
		return moreBits;
	}
	//*********************
	
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//make the blocks move faster
			if(e.getSource() == faster){
				dispose();
				GamePlay.getInstance().increaseSpeed();
			}
			//add a bit to the bit string
			if(e.getSource() == moreBits){
				dispose();
				GamePlay.getInstance().addBit();
			}
			MainDisplay.getFrameInstance().setIsNewLevel(false);
		}
		
	}

}
