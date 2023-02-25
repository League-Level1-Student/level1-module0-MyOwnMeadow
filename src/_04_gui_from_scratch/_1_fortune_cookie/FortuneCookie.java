package _04_gui_from_scratch._1_fortune_cookie;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class FortuneCookie implements ActionListener {
	//Frames and the like
	JFrame fortune = new JFrame();
	JButton cookie = new JButton();
	Random ran = new Random();
	String actividy = "read a book";
	
	public void showButton() {

	//Framin'
		fortune.setVisible(true);
		fortune.add(cookie);
		
		fortune.pack();
		
	//Buttoin'
		cookie.addActionListener(this);
	}
	public void actionPerformed(ActionEvent arg0) {
		JButton buttonPressed = (JButton) arg0.getSource();
		if(buttonPressed == cookie) {
			System.out.println("BUTTON PRESSED");
			JOptionPane.showInputDialog("Ask a question, any yes-or-no question.");
			JOptionPane.showMessageDialog(null, "PROSSESING QUETION...");
			
			int forchune = ran.nextInt(5);
			
			if(forchune == 0) {
				JOptionPane.showMessageDialog(null, "Apsolutely.");
				actividy = "skiing";
			}
			else if(forchune == 1) {
				JOptionPane.showMessageDialog(null, "I would suggest aginst it.");
				actividy = "paint";
			}
			else if(forchune == 2) {
				JOptionPane.showMessageDialog(null, "Probuly.");
				actividy = "draw";
			}
			else if(forchune == 3) {
				JOptionPane.showMessageDialog(null, "Apsolutly not.");
				actividy = "do somthing else";
			}
			else if(forchune == 4) {
				JOptionPane.showMessageDialog(null, "Go " + actividy + " insted of asking me.");
				actividy = "read a book";
			}
			else {
				actividy = "fix the code";
				JOptionPane.showMessageDialog(null, "ERROR");
			}
		}
		}
}
