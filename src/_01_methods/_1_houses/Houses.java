package _01_methods._1_houses;

import java.awt.Color;
import java.util.Random;

import org.jointheleague.graphical.robot.Robot;

/*
 *    Copyright (c) The League of Amazing Programmers 2013-2021
 *    Level 1
 */
public class Houses {
		
	public void run() {
	//Set up
		Robot robert = new Robot();
		robert.setX(0);
		robert.setY(440);
		robert.hide();
		robert.turn(90);
		robert.penDown();
		robert.setPenWidth(2);
		robert.setSpeed(20);
		robert.setPenColor(Color.GREEN);
		robert.move(20);
		
	//Houses 25 roof
		house(robert, "tall", "");
		house(robert, "med", "red");
		house(robert, "short", "magenta");
		
	}
	public static void house(Robot robert, String hightS, String color) {
		int hight = 150;
		boolean pointyRoof = false;
		Random ran = new Random();
		if(hightS.equalsIgnoreCase("Tall")) {
			hight = 250;
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
		robert.move(100);
		
		if(pointyRoof = true) {
			robert.turn(45);
			robert.move(25);
			robert.turn(45);
			robert.move(25);
			robert.turn(45);
		}
		else {
			robert.turn(90);
			robert.move(35);
			robert.turn(90);
		}
		
		robert.move(100);
	//Lawn
		robert.turn(-90);
		robert.setPenColor(Color.GREEN);
		robert.move(15);
	}
}
