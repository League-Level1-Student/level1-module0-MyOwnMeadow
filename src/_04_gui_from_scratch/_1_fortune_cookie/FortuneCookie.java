package _04_gui_from_scratch._1_fortune_cookie;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FortuneCookie implements ActionListener{
	//Frames and the like
	JFrame fortune = new JFrame();
	JButton cookie = new JButton();
	
	public void showButton() {
		System.out.println("BUTTON PRESSED");

	//Framin'
		fortune.setVisible(true);
		fortune.add(cookie);
		
		fortune.pack();
		
	//Buttoin'
		cookie.addActionListener(this);
	}
	public void actionPerformed(ActionEvent arg0) {
		JButton buttonPressed = (JButton) arg0.getSource();

		}
}
