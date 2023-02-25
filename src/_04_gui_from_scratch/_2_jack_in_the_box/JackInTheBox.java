package _04_gui_from_scratch._2_jack_in_the_box;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class JackInTheBox implements ActionListener {
//Variabules
	JFrame box = new JFrame();
	JButton suprize = new JButton();
	JPanel pan = new JPanel();
	int jackIsSummoned;
	int presses = 0;
	Random ran = new Random();
	
	Dimension BIG = new Dimension(400, 400);
	Dimension SMALL = new Dimension(200, 200);
	
	public void showButton() {
	//Frame
		box.add(suprize);
		box.setVisible(true);
		
	//Button
		pan.add(suprize);
		box.add(pan);
		suprize.addActionListener(this);
		suprize.setText("Click me a few times");
		suprize.setSize(SMALL);
		jackIsSummoned = ran.nextInt(4) + 4;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton buttonPressed = (JButton) arg0.getSource();
		presses += 1;
		
		if(presses == jackIsSummoned) {
			suprize.setText("SUPRIZE!!!");
			suprize.setSize(BIG);
			showPicture("jackInTheBox.png");
		}
	}
//Showing picture
	private void showPicture(String fileName) { 
	     try {
	          JLabel imageLabel = createLabelImage(fileName);
	          JFrame frame = new JFrame();
	          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	          frame.add(imageLabel);
	          frame.setVisible(true);
	          frame.pack();
	     } catch (Exception e) {
	          e.printStackTrace();
	     }
	}

	private JLabel createLabelImage(String fileName) {
	     try {
	          URL imageURL = getClass().getResource(fileName);
	          if (imageURL == null) {
	               System.err.println("Could not find image " + fileName);
	               return new JLabel();
	          } else {
	               Icon icon = new ImageIcon(imageURL);
	               JLabel imageLabel = new JLabel(icon);
	               return imageLabel;
	          }
	     } catch (Exception e) {
	          System.err.println("Could not find image " + fileName);
	          return new JLabel();
	     }
	}

}
