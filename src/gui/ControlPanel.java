package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sun.xml.internal.ws.api.Component;

import game.GamePlay;
import game.MainDisplay;

public class ControlPanel extends JPanel{
	JTextField textBox;
	int intAnswer;
	public static final int CONTROL_PANEL_HEIGHT = 100;
	public static final int GAME_PANEL_HEIGHT = MainDisplay.MAIN_DISPLAY_HEIGHT - CONTROL_PANEL_HEIGHT;

	public ControlPanel(){
		setPreferredSize(new Dimension(200, CONTROL_PANEL_HEIGHT));
		
		setBackground(new Color(255,3,214));
		setLayout(new GridLayout(1, 3));
	
		//Enter answer label
		JPanel panel = createLabel();
		add(panel, BorderLayout.CENTER);
		//text box to get input
		panel = createInput();
		add(panel, BorderLayout.CENTER);
		//submit button
		panel = createButton();
		add(panel, BorderLayout.CENTER);
	}
	public void submitEvent(){
		String answer = textBox.getText();
		int v = Integer.parseInt(answer);
		textBox.setText("");

		
		GamePlay.getInstance().submitButton(v);
		
	}
	private JPanel createLabel(){
		JPanel p = new JPanel();
		JLabel box = new JLabel("                                                                                                                                                              ");
		p.add(box);
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
		JLabel box = new JLabel("                                                                                                                                                                 ");
		p.add(box);
		textBox = new JTextField(15);
		textBox.setPreferredSize( new Dimension( 300, 40 ) );
		textBox.setFont(new Font("Impact", Font.PLAIN, 20));
		textBox.addKeyListener(new EnterListener());
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
		button.setPreferredSize(new Dimension(200,80));
		
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
			//GamePlay.getInstance().setAnswer(v);
			submitEvent();

		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	
	//enter key takes text box data
	private class EnterListener implements KeyListener{

		@Override
		public void keyPressed(KeyEvent e) {
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_ENTER){
				
				//if (v == null){
					
				//}
				//GamePlay.getInstance().setAnswer(v);
				submitEvent();
			}
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
		
			
		}
		
	}
}