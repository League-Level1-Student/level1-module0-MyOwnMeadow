package _04_gui_from_scratch._4_cuteness_tv;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CutenessTV implements ActionListener{
//Inetiation for frames and stuff
	JFrame screen = new JFrame();
	JPanel remote = new JPanel();
	JButton duckB = new JButton();
	JButton frogB = new JButton();
	JButton uniB = new JButton();
	
//Veriables
	Dimension BIG = new Dimension(400, 400);
	Dimension SMALL = new Dimension(200, 50);
	
	public void showRemote() {
	//Frames
		screen.setVisible(true);
		screen.add(remote);
		
		screen.pack();
		
	//Buttons
		duckB.addActionListener(this);
		frogB.addActionListener(this);
		uniB.addActionListener(this);
		
		remote.add(duckB);
		remote.add(frogB);
		remote.add(uniB);
		
		duckB.setPreferredSize(SMALL);
		frogB.setPreferredSize(SMALL);
		uniB.setPreferredSize(SMALL);
		
		//Text
		duckB.setText("Avien Chanel");
		frogB.setText("Simiaquadic Chanel");
		uniB.setText("Fanticy Chanel");
		
		screen.pack();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();
		
		if(buttonPressed == e.getSource()) {
		if(buttonPressed == duckB) {
			showDucks();
			System.out.println("DUCK BUTTON PRESSED");
		}
		else if(buttonPressed == frogB) {
			showFrog();
			System.out.println("FROG BUTTON PRESSED");
		}
		else if(buttonPressed == uniB) {
			showFluffyUnicorns();
			System.out.println("UNI BUTTON PRESSED");
		}
		}
	}
//The Videos
	void showDucks() {
	     playVideo("https://www.youtube.com/watch?v=MtN1YnoL46Q");
	}

	void showFrog() {
	     playVideo("https://www.youtube.com/watch?v=cBkWhkAZ9ds");
	}

	void showFluffyUnicorns() {
	     playVideo("https://www.youtube.com/watch?v=a-xWhG4UU_Y");
	}

	void playVideo(String videoID) {
	     
	     // Workaround for Linux because "Desktop.getDesktop().browse()" doesn't 
	     //work on some Linux implementations 
	     try {
	     if (System.getProperty("os.name").toLowerCase().contains("linux")) {
	     if (Runtime.getRuntime().exec(new String[] { 
	      "which", "xdg- open" }).getInputStream().read() != -1) {
	     Runtime.getRuntime().exec(new String[] { "xdg-open", videoID }); 
	     }
	     } else {
	          URI uri = new URI(videoID);
	          java.awt.Desktop.getDesktop().browse(uri);
	     }      } catch (Exception e) {
	          e.printStackTrace();
	     }
	}
}
