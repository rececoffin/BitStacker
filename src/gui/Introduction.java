package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Introduction extends JPanel{
	public Introduction(){
		setBackground(Color.BLACK);
		setLayout(new GridLayout(4, 0));
		JPanel panel = title1Panel();
		panel.setBackground(new Color(3,3,54));
		add(panel);
		panel = title2Panel();
		panel.setBackground(new Color(3,3,54));
		add(panel);
		panel = instructionPanel();
		panel.setBackground(new Color(3,3,54));
		add(panel);
		panel = buttonPanel();
		panel.setBackground(new Color(3,3,54));
		add(panel);
	
	}
	private JPanel title1Panel(){
		JPanel p = new JPanel();
		//p.setLayout(new GridLayout(1, 0));
		
		JLabel letter = new JLabel("B");
		letter.setFont(new Font("Impact", Font.PLAIN, 150));
		letter.setBackground(new Color(255,3,214));
		letter.setForeground(new Color(255,3,214));
		p.add(letter);
		
		 letter = new JLabel("I");
		letter.setFont(new Font("Impact", Font.PLAIN, 150));
		letter.setBackground(new Color(0,255,255));
		letter.setForeground(new Color(153,0,255));
		p.add(letter);
		
		letter = new JLabel("T");
		letter.setFont(new Font("Impact", Font.PLAIN, 150));
		letter.setBackground(new Color(0,255,85));
		letter.setForeground(new Color(0,255,255));
		p.add(letter);
		
		return p;
	}
	private JPanel title2Panel(){
		JPanel p = new JPanel();
		JLabel letter = new JLabel("S");
		letter.setFont(new Font("Impact", Font.PLAIN, 150));
		letter.setBackground(new Color(255,3,214));
		letter.setForeground(new Color(0,255,188));
		p.add(letter);
		
		 letter = new JLabel("T");
		letter.setFont(new Font("Impact", Font.PLAIN, 150));
		letter.setBackground(new Color(0,255,255));
		letter.setForeground(new Color(255,162,0));
		p.add(letter);
		
		letter = new JLabel("A");
		letter.setFont(new Font("Impact", Font.PLAIN, 150));
		letter.setBackground(new Color(0,255,85));
		letter.setForeground(new Color(0,145,255));
		p.add(letter);
		
		 letter = new JLabel("C");
			letter.setFont(new Font("Impact", Font.PLAIN, 150));
			letter.setBackground(new Color(0,255,255));
			letter.setForeground(new Color(0,255,85));
			p.add(letter);
			
			letter = new JLabel("K");
			letter.setFont(new Font("Impact", Font.PLAIN, 150));
			letter.setBackground(new Color(0,255,85));
			letter.setForeground(new Color(255,3,214));
			p.add(letter);
			
			 letter = new JLabel("E");
				letter.setFont(new Font("Impact", Font.PLAIN, 150));
				letter.setBackground(new Color(0,255,255));
				letter.setForeground(new Color(153,0,255));
				p.add(letter);
				
				letter = new JLabel("R");
				letter.setForeground(new Color(0,255,255));
				letter.setFont(new Font("Impact", Font.PLAIN, 150));
				letter.setBackground(new Color(0,255,85));
				
				p.add(letter);
		return p;
	}
	private JPanel instructionPanel(){
		JPanel p = new JPanel();
		JLabel box = new JLabel("The binary number system is a base-2 number system. This means it only has two numbers: 0 and 1.");
		box.setForeground(new Color(0,255,255));
		box.setFont(new Font("Impact", Font.PLAIN, 25));
		p.add(box);
	    box = new JLabel("In a binary number each place represents a power of 2. For example:");
	    box.setForeground(new Color(0,255,255));
	    box.setFont(new Font("Impact", Font.PLAIN, 25));
	    p.add(box);
	    
	    box = new JLabel("1 = 2^0 = 1");
	    box.setForeground(new Color(0,255,255));
	    box.setFont(new Font("Impact", Font.PLAIN, 25));
	    p.add(box);
	    box = new JLabel("10 = 2^1 = 2");
	    box.setForeground(new Color(0,255,255));
	    box.setFont(new Font("Impact", Font.PLAIN, 25));
	    p.add(box);
	    box = new JLabel("100 = 2^2 = 4");
	    box.setForeground(new Color(0,255,255));
	    box.setFont(new Font("Impact", Font.PLAIN, 25));
	    p.add(box);
	    box = new JLabel("1000 = 2^3 = 8");
	    box.setForeground(new Color(0,255,255));
	    box.setFont(new Font("Impact", Font.PLAIN, 25));
	    p.add(box);
	    box = new JLabel("For example: 101 binary = 4 + 0 + 1 = 5 decimal");
	    box.setForeground(new Color(0,255,255));
	    box.setFont(new Font("Impact", Font.PLAIN, 25));
	    p.add(box);
		return p;
	}
	private JPanel buttonPanel(){
		JPanel p = new JPanel();
		JButton button = new JButton(" PLAY ");
		button.setBackground(new Color(0,255,188));
		button.addMouseListener(new StartListener());
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Impact", Font.PLAIN, 35));
		button.setPreferredSize(new Dimension(600,75));
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