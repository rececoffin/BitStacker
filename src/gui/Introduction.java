package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class Introduction extends JPanel{
	public Introduction(){
		setBackground(new Color(3,3,54));
		setLayout(new GridLayout(4, 0));
		JPanel panel = title1Panel();
		add(panel);
		panel = title2Panel();
		add(panel);
		panel = instructionPanel();
		add(panel);
		panel = buttonPanel();
		add(panel);
	
	}
	private JPanel title1Panel(){
		JPanel p = new JPanel();
		
		return p;
	}
	private JPanel title2Panel(){
		JPanel p = new JPanel();
		return p;
	}
	private JPanel instructionPanel(){
		JPanel p = new JPanel();
		return p;
	}
	private JPanel buttonPanel(){
		JPanel p = new JPanel();
		JButton button = new JButton(" PLAY ");
		button.setBackground(new Color(0,255,188));
		button.addMouseListener(new StartListener());
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Impact", Font.PLAIN, 35));
		button.setPreferredSize(new Dimension(200,75));
		p.add(button);
		return p;
	}
	private void playGame(){									//to do 
		
	}
	private class StartListener implements MouseListener{
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
			playGame();
			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
}
