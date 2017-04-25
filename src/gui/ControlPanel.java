package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import clueGame.Board;
import game.GamePlay;

public class ControlPanel extends JPanel{
	public ControlPanel(){
		setBackground(new Color(255,3,214));
		setLayout(new GridLayout(1, 3));
		JPanel panel = createLabel();
		add(panel);
		panel = createInput();
		add(panel);
		panel = createButton();
		add(panel);
	}
	
	private JPanel createLabel(){
		JPanel p = new JPanel();
		JLabel label = new JLabel("Enter Answer");
		p.add(label);
		p.setBackground(new Color(255,3,214));
		return p;
	}
	
	private JPanel createInput(){
		JPanel p = new JPanel();
		JTextField textBox = new JTextField("Answer");
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
			GamePlay.getInstance().submitAnswer();
			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
}
