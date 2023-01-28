package _03_gui_with_help._2_photo_quiz;
/*
 *    Copyright (c) The League of Amazing Programmers 2013-2021
 *    Level 1
 */

import java.awt.Component;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PhotoQuiz {

	public void run() {
	//Veriabluls:
		int score = 0;
		int qNum = 0;
		
	//JFrame
		JFrame quiz = new JFrame();
		quiz.setVisible(true);
		// This will make sure the program exits when you close the window
		quiz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 1. find an image on the internet, and put its URL in a String
		// variable (from your browser, right click on the image, and select
		// “Copy Image Address” )
		String lampryS = "https://www.hcn.org/issues/54.2/indigenous-affairs-fish-humble-suckers-pacific-lamprey-have-survived-5-mass-extinctions-but-are-now-under-threat/lamprey-brian-2-jpg/image";
		// 2. create a variable of type "Component" that will hold your image
		Component lampPNG;
		// 3. use the "createImage()" method below to initialize your Component
		lampPNG = createImage(lampryS);
		// 4. add the image to the quiz window
		quiz.add(lampPNG);
		// 5. call the pack() method on the quiz window
		quiz.pack();
		// 6. ask a question that relates to the image
		
		
		
//Q1
		String ans1 = JOptionPane.showInputDialog("What creacher is this?");
		// 7. print "CORRECT" if the user gave the right answer
		if(ans1.equalsIgnoreCase("lamprey") || ans1.equalsIgnoreCase("lampry")) {
			JOptionPane.showMessageDialog(null, "CORRECT!");
			score += 1;
			qNum += 1;
		}
		// 8. print "INCORRECT" if the answer is wrong
		else {
			JOptionPane.showMessageDialog(null, "WRONG. IT IS A LAMPREY, NOT A ''" + ans1 + ".''");
			qNum += 1;
		}
		// 9. remove the component from the quiz window (you may not see the
		// effect of this until step 12)
		quiz.remove(lampPNG);
		// 10. find another image and create it (might take more than one line
		// of code)
		Component map;
		String mapS ="https://thumbs.dreamstime.com/z/usa-canada-large-detailed-political-map-states-provinc-provinces-capital-cities-84432397.jpg";
		map = createImage(mapS);
		// 11. add the second image to the quiz window
		quiz.add(map);
		// 12. pack the quiz window
		quiz.pack();
		// 13. ask another question
//Q2
		String ans2 = JOptionPane.showInputDialog(null, "What state/provence is the 2nd largest producer of maple syrup in the world?\n (Hint: Quebec is the largest producer)");
		// 14+ check answer, say if correct or incorrect, etc.
		if(ans2.equalsIgnoreCase("vermont")) {
			JOptionPane.showMessageDialog(null, "CORRECT!");
			score += 1;
			qNum += 1;
		}
		else {
			JOptionPane.showMessageDialog(null, "WRONG. IT'S VERMONT, NOT ''" + ans2 + ".''");
			qNum += 1;
		}
		
	//Summery:
		JOptionPane.showMessageDialog(null, "YOU GOT " + score + "/" + qNum + " CORRECT.");
		
	}

	private Component createImage(String imageUrl) {
		JLabel imageLabel = new JLabel();
		URL url;
		try {
			url = new URL(imageUrl);
			Icon icon = new ImageIcon(url);
			imageLabel.setIcon(icon);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "I can't find your image!!");
		}
		
		return imageLabel;
	}

	/* OPTIONAL */
	// *14. add scoring to your quiz
	// *15. make something happen when mouse enters image
	// (imageComponent.addMouseMotionListener())
}
