package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.GamePlay;
import gui.NextLevelDialog.ButtonListener;

public class GameOver extends JDialog{
	private static JButton exit;
	Font myFont = new Font("Impact", Font.PLAIN, 25);
public GameOver(boolean win) {
	//Cat I need you to make this all pretty
		JPanel panel;
		setBackground(new Color(3,3,54));
		setSize(500, 300);
		setLayout(new GridLayout(2,0));
			if (win){
				panel = addWinPanel();
			}
			else{
				panel = addLosePanel();
			}
			
			//column is hieght
			//add a title
			
			panel.setBackground(new Color(3,3,54));
			add(panel);
			
			panel = button1();
			panel.setBackground(new Color(3,3,54));
			add(panel);
			
			
}

private JPanel addLosePanel() {
	JPanel panel = new JPanel();
	JLabel label = new JLabel("You lose!");
	
	label.setForeground(new Color(178,102,255));
	label.setFont(new Font("Impact", Font.PLAIN, 55));

	panel.add(label);

	
	return panel;
}
private JPanel addWinPanel() {
	JPanel panel = new JPanel();
	JLabel label = new JLabel("You win!");
	
	label.setForeground(new Color(178,102,255));
	label.setFont(new Font("Impact", Font.PLAIN, 55));

	panel.add(label);

	
	return panel;
}
private JPanel button1(){
	JPanel p = new JPanel();
	exit = new JButton("Exit");
	exit.addActionListener(new ButtonListener());
	exit.setBackground(new Color(0,255,188));
	exit.setForeground(Color.WHITE);
	exit.setFont(myFont);
	p.add(exit);
	return p;
	
}
class ButtonListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
	
}
}
