package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.GamePlay;

public class NextLevelDialog extends JDialog{
	private int level;
	private static JButton faster;
	private static JButton moreBits;
	
	public NextLevelDialog(int level) {
		//Cat I need you to make this all pretty
		this.level = level;
		setSize(1000, 1000);
		setLayout(new FlowLayout());
		
		//add a title
		JPanel panel = addTitlePanel();
		add(panel);
		
		faster = new JButton("Make the Blocks move faster.");
		moreBits = new JButton("Add one bit to the string.");
		//event listeners
		faster.addActionListener(new ButtonListener());
		moreBits.addActionListener(new ButtonListener());
		add(faster);
		add(moreBits);
	}
	private JPanel addTitlePanel() {
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Congratulations! You beat level " + (level - 1));
		JLabel label2 = new JLabel("What would you like to do?");
		panel.add(label);
		panel.add(label2);
		
		return panel;
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
		}
		
	}

}
