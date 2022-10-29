package _01_methods._1_houses;

import java.awt.Color;
import java.util.Random;

import org.jointheleague.graphical.robot.Robot;

/*
 *    Copyright (c) The League of Amazing Programmers 2013-2021
 *    Level 1
 */
public class Houses {
	static boolean randomness = true;		//Set to "True" if you want a random city
	public void run() {
	//Set up
		Robot robert = new Robot();
		int i = 1;
		
		robert.setX(0);
		robert.setY(400);
		robert.hide();
		robert.turn(90);
		robert.penDown();
		robert.setPenWidth(2);
		robert.setSpeed(20);
		robert.setPenColor(Color.GREEN);
		robert.move(20);
		
	//Houses
	while(i > 0) {
		house(robert, "tall", "pink");
		house(robert, "med", "red");
		house(robert, "short", "magenta");
		house(robert, "med", "light gray");
		house(robert, "short", "orange");
		house(robert, "tall", "cyan");
		house(robert, "short", "blue");
		house(robert, "med", "dark gray");
		house(robert, "tall", "yellow");
		house(robert, "med", "pink");
		house(robert, "short", "gray");
		house(robert, "med", "cyan");
		house(robert, "short", "orange");
		house(robert, "tall", "magenta");
		house(robert, "short", "blue");
		house(robert, "med", "light gray");
		i -= 1;
	}
	}
	public static void house(Robot robert, String hightS, String color) {
		int hight = 150;
		boolean pointyRoof = false;
		Random ran = new Random();
		
		if(randomness == true) {			///For random citys
			int hightI = ran.nextInt(3);
			
			if(hightI == 0) {
				hightS = "short";
			}
			else if(hightI == 1) {
				hightS = "med";
			}
			else if (hightI == 2) {
				hightS = "tall";
			}
			
			color = "";
		}
		
		if(hightS.equalsIgnoreCase("Tall")) {
			hight = 250;
			pointyRoof = false;
		}
		else if(hightS.equalsIgnoreCase("Short")) {
			hight = 60;
			pointyRoof = true;
		}
		else {
			hightS = "Medieom";
			
			int tOrF = ran.nextInt(2);
			if(tOrF == 0) {
				pointyRoof = true;
			}
			else {
				pointyRoof = false;
			}
		}
		
		if(color.equalsIgnoreCase("Red")) {
			robert.setPenColor(Color.RED);
		}
		else if(color.equalsIgnoreCase("Blue")) {
			robert.setPenColor(Color.BLUE);
		}
		else if(color.equalsIgnoreCase("Yellow")) {
			robert.setPenColor(Color.YELLOW);
		}
		else if(color.equalsIgnoreCase("Orange")) {
			robert.setPenColor(Color.ORANGE);
		}
		else if(color.equalsIgnoreCase("Cyan")) {
			robert.setPenColor(Color.CYAN);
		}
		else if(color.equalsIgnoreCase("Gray")) {
			robert.setPenColor(Color.GRAY);
		}
		else if(color.equalsIgnoreCase("Dark Gray")) {
			robert.setPenColor(Color.DARK_GRAY);
		}
		else if(color.equalsIgnoreCase("Light Gray")) {
			robert.setPenColor(Color.LIGHT_GRAY);
		}
		else if(color.equalsIgnoreCase("Pink")) {
			robert.setPenColor(Color.PINK);
		}
		else if(color.equalsIgnoreCase("Magenta")) {
			robert.setPenColor(Color.MAGENTA);
		}
		else {
			robert.setRandomPenColor();
		}
		
		
	//House
		robert.turn(-90);
		robert.move(hight);
		
		if(pointyRoof == true) {
			robert.turn(45);
			robert.move(25);
			robert.turn(45);
			robert.move(25);
			robert.turn(90);
		}
		else {
			robert.turn(90);
			robert.move(35);
			robert.turn(90);
		}
		
		robert.move(hight + 5);
	//Lawn
		robert.turn(-90);
		robert.setPenColor(Color.GREEN);
		robert.move(15);
	}
}









