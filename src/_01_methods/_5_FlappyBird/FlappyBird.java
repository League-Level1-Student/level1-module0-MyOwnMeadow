package _01_methods._5_FlappyBird;

import processing.core.PApplet;

public class FlappyBird extends PApplet {
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    
//BIRB
	int relX = (WIDTH/3) - (WIDTH/12);
	int relY = HEIGHT/2;
	
//Setings
	int startFallrate = 1;
	int gravBirb = 1;
	int startBounce = -20;
	int bounceDecayRate = 7;
	
//Core Mecanics
	int fallrateB = startFallrate;
	int bounce = startBounce;
	int bounceDecay = -startBounce/bounceDecayRate;
	
    @Override
    public void settings() {
        size(WIDTH, HEIGHT);
    }

    @Override
    public void setup() {
        
    }
    
    @Override
    public void mousePressed() {
    	fallrateB = -15;
    	bounce = startBounce;
    }

    @Override
    public void draw() {
    	background(150, 200, 250);
    	
    	
    //Temp BIRB
    	fill(20, 100, 30);
    	stroke(50, 250, 100);
    	ellipse(relX, relY, 50, 40);
    	
    //BIRB fall
    	if(relY < HEIGHT - fallrateB) {
        	relY += fallrateB;
    	}
    	else {
    		relY = HEIGHT;
    		fallrateB = bounce;
    		bounce += bounceDecay;
    	}
    	fallrateB += gravBirb;
    }

    static public void main(String[] args) {
        PApplet.main(FlappyBird.class.getName());
    }
}
