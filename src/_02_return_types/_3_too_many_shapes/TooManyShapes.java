package _02_return_types._3_too_many_shapes;



import java.util.Random;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class TooManyShapes {
	static Robot rob = new Robot();

	public static void main(String[] args) {
		boolean drawing = true;
		rob.show();
		while(drawing == true) {
		//1. Ask the user how many sides they want their shape to be
		String sideS = JOptionPane.showInputDialog("How many sides do you want?");
		int sideNum = Integer.parseInt(sideS);
		//2. Ask the user how many shapes they want
		String shapeS = JOptionPane.showInputDialog("And how meny shapes?");
		int shapeNum = Integer.parseInt(shapeS);
		//3. Call canMakeShape() and save what is returned into a variable
		boolean shapeInStock = canMakeShape(sideNum);
		
		
		//4. If the shape CAN be drawn
		if(shapeInStock == true) {
			//5. Call and save what is returned from calculateTurnAngle()
			int turnAngle = calculateTurnAngle(sideNum);
			//6. Use drawPolygons() to draw your shape
			drawPolygons(sideNum, shapeNum, turnAngle);
		}
		//7. If the shape CANNOT be drawn 
		else {
			//8. Call notEnoughSides() and print out what is returned 
			System.out.println(notEnoughSides());
			JOptionPane.showMessageDialog(null, notEnoughSides());
		}
		
		String drawMoreS = JOptionPane.showInputDialog("CONTINUE DRAWING?\n"
				+ "\nTYPE ''No'' TO STOP,\n"
				+ "TYPE ''Yes'' TO CONTINUE.");
		
		if(drawMoreS.equalsIgnoreCase("no")) {
			drawing = false;
		}
		else {
			JOptionPane.showMessageDialog(null, "I'LL TAKE THAT AS A YES.");
		}
		}
	}
	
	static int calculateTurnAngle(int numSides) {
		int angle = 360/numSides;
		return angle;
	}
	
	static void drawPolygons(int numSides, int numShapes, int degrees) {
		rob.setSpeed(100);
		rob.penDown();
		int dist = 25;
		Random rand = new Random();
		
		for(int i = 0; i < numShapes; i++) {
			int x = rand.nextInt(600);
			int y = rand.nextInt(600);
			int angle = rand.nextInt(360);

			rob.setX(x);
			rob.setY(y);
			rob.setAngle(angle);
			rob.setRandomPenColor();
			
			for(int j = 0; j < numSides; j++) {
				rob.move(dist);
				rob.turn(degrees);
			}
	    }
		rob.hide();
	}
	
	static boolean canMakeShape(int numSides) {
		if(numSides >= 3) {
			return true;
		}
		return false;
	}
	
	static String notEnoughSides() {
		return "It is imposible to make a poloygon with that number of sides.\n"
				+ "Please enter a number greater than 2";
	}
}
