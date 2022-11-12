package _01_methods._3_rain_game;

import java.awt.Color;
import java.util.Random;

import processing.core.PApplet;
import processing.core.PImage;

/*
 * Goal: Make a game where the user has to catch rain drops in a bucket!
 * 
 * In the setup() method:
 * 1. If you are using an image for the bucket, load it and resize it here.
 *    A bucket image, bucket.png, has been provided if you want to use it.
 *    bucket = loadImage("images/bucket.png");
 *    bucket.resize(100, 100);  // you can choose values other than 100, 100
 * 
 * In the draw() method:
 * 2. Set a background color
 * 
 * 3. Draw a raindrop (ellipse) at the top of the screen
 * 
 * 4. Make the rain fall down the screen.
 *    Hint: make a variable for the raindrop's Y position and change it after
 *    you draw the raindrop.
 * 
 * 5. When the rain falls off the bottom of the canvas, start a new rain drop
 *    falling from the top.
 *    Each new drop should start at a random position (X position) at the top.
 *    Hint: This code will get a random number between 0 and the window width.
 *    int randomNumber = (int)random(width);
 * 
 * 6. Draw a bucket (rectangle or image) at the bottom of the screen.
 *    The bucket's width needs to be stored in the bucketWidth variable.
 * 
 * 7. Make the bucket move side-to-side with the mouse. Hint: use mouseX
 * 
 * 8. When the rain drop has fallen to the bucket, call the checkCatch() method
 *    to see if the rain drop is in the bucket.
 * 
 * 9. Show the current score on the screen using the code below.
 *    Change the color if it does not show up on your background.
 *    fill(0, 0, 0);
 *    textSize(16);
 *    text("Score: " + score, 20, 20);
 */
public class RainGame extends PApplet {
    static final int WIDTH = 600;
    static final int HEIGHT = 600;

    Random ran = new Random();
    
    int score = 0;
    int bucketWidth = 50;
    int bucketHeight = 20;
    int xBuck = 100;
    int yBuck = HEIGHT - 60;
    PImage bucket;
    int y = 50;
    int x = 0;
    
   //Difficulty
	int sped = 5;
	int skore = 0;
	int cathc = 5;
	int miss = 2;

//Cloud Setings
	int cloudW = 120;
	int cloudH = 20;
	int cloudX = 50;
	int cloudFrunt = 50;
	
    // Sets the size of your canvas
    @Override
    public void settings() {
        size(WIDTH, HEIGHT);
    }

    @Override
    public void setup() {
    	x = ran.nextInt(WIDTH - 8) +4;
    }

    @Override
    public void draw() {
    	background(100, 100, 150);
  
//DIFICALTY:
    	
    	if(sped >= 100) {
    		sped = 100;
    	}
    	else {
    		sped = (skore/10) + 5;
    	}
    	
    //Clouds
    	fill(90, 90, 110);
    	stroke(120, 120, 150);
    	ellipse(cloudX, cloudFrunt, cloudW, cloudH);
    	ellipse(cloudX + 100, cloudFrunt, cloudW, cloudH);
    	ellipse(cloudX + 200, cloudFrunt, cloudW, cloudH);
    	ellipse(cloudX + 300, cloudFrunt, cloudW, cloudH);
    	ellipse(cloudX + 400, cloudFrunt, cloudW, cloudH);
    	ellipse(cloudX + 500, cloudFrunt, cloudW, cloudH);  
    
    //Cloud Line
    	noStroke();
    	rect(0, 0, WIDTH, 50);
    //Bucket
    	xBuck = mouseX - (bucketWidth/2);
    	fill(100, 50, 50);
    	stroke(50, 20, 20);
    	rect(xBuck, yBuck, bucketWidth, bucketHeight);
    	noStroke();
    	rect(xBuck, yBuck, bucketWidth, 2);
    	
    //Rain Drop
    	fill(0, 0, 200);
    	noStroke();
		ellipse(x, y, 5, 15);
    	
		if(y > HEIGHT) {
			y = 50;
			x = ran.nextInt(WIDTH - 8) +4;
			if(skore >= miss) {
				skore -= miss;
				println("SCORE: " + skore);
			}
			else if(skore > 0) {
				skore = 0;
				println("SCORE: " + skore);
			}
		}
		else if(y >= yBuck && x >= xBuck && x <= (xBuck + bucketWidth)) {
			skore += cathc;
			y = 50;
			x = ran.nextInt(WIDTH - 8) +4;
			println("SCORE: " + skore);
		}
		else {
			y += sped;
		}
	//Score print
		fill(0, 0, 50);
	    textSize(20);
	    text("SCORE: " + skore, 20, 20);
    }

    static public void main(String[] args) {
        PApplet.main(RainGame.class.getName());
    }
    
    /*********************** DO NOT MODIFY THE CODE BELOW ********************/

    void checkCatch(int x) {
        if (x > mouseX && x < mouseX + bucketWidth) {
            score++;
        } else if (score > 0) {
            score--;
        }
        println("Your score is now: " + score);
    }
}
