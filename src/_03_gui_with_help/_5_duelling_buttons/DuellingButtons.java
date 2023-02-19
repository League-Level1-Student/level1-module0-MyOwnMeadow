package _03_gui_with_help._5_duelling_buttons;

/*
 *    Copyright (c) The League of Amazing Programmers 2013-2021
 *    Level 1
 */

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DuellingButtons implements ActionListener {

	JButton lButton = new JButton();
	JButton rButton = new JButton();

	Dimension BIG = new Dimension(400, 400);
	Dimension SMALL = new Dimension(200, 200);

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();

	public void run() {

		// 1. Add the panel to the frame
		frame.add(panel);
		// 2. Make the frame visible
		frame.setVisible(true);
		// 3. Set the text of the leftButton to "Click me!"
		lButton.setText("Click Me!");
		// 4. Set the text of the rightButton to "Click me!"
		rButton.setText("Click me!");
		// 5. Add an action listener to the leftButton
		lButton.addActionListener(this);
		// 6. Add an action listener to the rightButton
		rButton.addActionListener(this);
		// 7. Add the leftButton to the panel
		panel.add(lButton);
		// 8. Add the rightButton to the panel
		panel.add(rButton);
		
		rButton.setPreferredSize(SMALL);
		lButton.setPreferredSize(SMALL);
		// 9. Pack the frame
		frame.pack();
		// 10. Set the title of the frame to "Demanding Buttons"

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton buttonPressed = (JButton) arg0.getSource();

		/* If the buttonPressed was the leftButton.... */
		if(buttonPressed == lButton) {
		// Set the text of the rightButton to "No, click Me!"
			rButton.setText("No, click me!");
		// Set the PREFERRED size of the rightButton to BIG
			rButton.setPreferredSize(BIG);
		// Set the text of the leftButton to "Click Me!"
			lButton.setText("Click me agin!");
		// Set the PREFERRED size of the leftButton to SMALL
			lButton.setPreferredSize(SMALL);
		}
		/* If the buttonPressed was the rightButton, do the opposite. */
		else if(buttonPressed == rButton) {
			lButton.setText("No, click me!");
			lButton.setPreferredSize(BIG);
			rButton.setText("Click me agin!");
			rButton.setPreferredSize(SMALL);
		}

		frame.pack();
	}
}
