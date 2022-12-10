package _01_methods._5_FlappyBird;

import processing.core.PApplet;

public class FlappyBird extends PApplet {
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
//Pipe
    int pipeY = (int) random(HEIGHT - 100);;
    int pipeX = WIDTH;
	int pipeSize = 50;
	
    
//BIRB
	int relX = (WIDTH/3) - (WIDTH/12);
	int relY = HEIGHT/2;
	
//Setings
	
	//BIRB
	int startFallrate = 1;
	int gravBirb = 1;
	int startBounce = -20;
	int bounceDecayRate = 7;
	
	//PIPE
	int scrolSpedStart = 5;
	int scrolIncrece = 1;
	int pipeGap = 200;
	
//Core Mecanics
	
	//Birb
	int fallrateB = startFallrate;
	int bounce = startBounce;
	int bounceDecay = -startBounce/bounceDecayRate;
	
	//Pipe
	float scrolSped = scrolSpedStart;
	
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
    	fill(100, 20, 50);
    	stroke(250, 50, 100);
    	ellipse(relX, relY, 50, 40);
    
    //Temp pipe bottem
    	fill(100, 200, 100);
    	stroke(0, 100, 0);
    	rect(pipeX, pipeY, pipeSize, 1000);
    	
    //Temp pipe top
    	fill(100, 200, 100);
    	stroke(0, 100, 0);
    	rect(pipeX, pipeY + pipeGap, pipeSize, 1000);
    	
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
    	
    //PIPE scrol
    	pipeX -= scrolSped;
    	
    	if(pipeX <= - pipeSize - 1) {
    		pipeX = WIDTH + 50;
    		pipeY = (int) random(HEIGHT - 100);
    	}
    }

    static public void main(String[] args) {
        PApplet.main(FlappyBird.class.getName());
    }
}
