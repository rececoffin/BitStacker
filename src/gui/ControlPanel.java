package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sun.xml.internal.ws.api.Component;

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
		JLabel label = new JLabel("Enter Answer: ");
		label.setFont(new Font("Impact", Font.PLAIN, 35));
		label.setForeground(Color.WHITE);
		label.setAlignmentX(CENTER_ALIGNMENT);
		label.setAlignmentY(CENTER_ALIGNMENT);
		p.add(label);
		p.setPreferredSize(new Dimension(60,100));
		p.setBackground(new Color(255,3,214));
		return p;
	}
	
	private JPanel createInput(){
		JPanel p = new JPanel();
		textBox = new JTextField(15);
		textBox.setPreferredSize( new Dimension( 300, 30 ) );
	
		p.add(textBox);
		p.setBackground(new Color(255,3,214));
		
		return p;
	}
	
	private JPanel createButton(){
		JPanel p = new JPanel();
		JButton button = new JButton(" Submit ");
		button.setBackground(new Color(0,255,188));
		button.addMouseListener(new SubmitListener());
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Impact", Font.PLAIN, 35));
		button.setPreferredSize(new Dimension(200,75));
		button.setAlignmentX(CENTER_ALIGNMENT);
		button.setAlignmentY(CENTER_ALIGNMENT);
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
