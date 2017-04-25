package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import game.GamePlay;

public class ControlPanel extends JPanel{
	JTextField textBox;
	int intAnswer;
	public ControlPanel(){
		setPreferredSize(new Dimension(200,100));
		
		setBackground(new Color(255,3,214));
		setLayout(new GridLayout(1, 3));
		JPanel panel = createLabel();
		add(panel, BorderLayout.CENTER);
		panel = createInput();
		add(panel, BorderLayout.CENTER);
		panel = createButton();
		add(panel, BorderLayout.CENTER);
	}
	public void submitAnswer(){
		String answer = textBox.getText();
		int v = Integer.parseInt(answer);
		GamePlay.getInstance().answer = v;
		
	}
	private JPanel createLabel(){
		JPanel p = new JPanel();
		JLabel label = new JLabel("Enter Answer");
		p.add(label);
		p.setPreferredSize(new Dimension(60,100));
		p.setBackground(new Color(255,3,214));
		return p;
	}
	
	private JPanel createInput(){
		JPanel p = new JPanel();
		textBox = new JTextField(15);
		p.add(textBox);
		p.setBackground(new Color(255,3,214));
		return p;
	}
	
	private JPanel createButton(){
		JPanel p = new JPanel();
		JButton button = new JButton(" Submit ");
		button.setBackground(new Color(0,255,188));
		button.addMouseListener(new SubmitListener());
		p.add(button);
		p.setPreferredSize(new Dimension(60,100));
		p.setBackground(new Color(255,3,214));
		return p;
	}
	
	private class SubmitListener implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			submitAnswer();
			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
}
