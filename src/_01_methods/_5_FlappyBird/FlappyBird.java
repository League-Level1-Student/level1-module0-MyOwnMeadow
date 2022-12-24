package _01_methods._5_FlappyBird;

import processing.core.PApplet;

public class FlappyBird extends PApplet {
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
//Pipe
    int pipeY = (int) random(HEIGHT - 100);			//Bottem pipe hight
    int pipeX = WIDTH;								
	int pipeSize = 50;								//Pipe thickness
	
    
//BIRB
	int relX = (WIDTH/3) - (WIDTH/12);
	int relY = HEIGHT/2;
	
//Setings
	
	//BIRB
	int startFallrate = 1;
	int gravBirb = 1;
	int startBounce = -20;
	int bounceDecayRate = 7;
	int forgiveness = 20;					//How much you can clip into the pipe
	
	//PIPE
	int scrolSpedStart = 5;
	int scrolIncrece = 1;
	int pipeGap = 200;						//Size of gap
	
//Core Mecanics
	
	//Birb
	int fallrateB = startFallrate;
	int bounce = startBounce;
	int bounceDecay = -startBounce/bounceDecayRate;
	int score = 0;
	
	//Pipe
	float scrolSped = scrolSpedStart;
	int pipeGapY = pipeGap + pipeY;			//Location of the bottem of the upper pipe (same as top of the gap)
	
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
    	paint();
    	grav();
    	crash();
    	pipeScrol();
    }
    public void paint() {
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
        	rect(pipeX, pipeY - pipeGap - 1000, pipeSize, 1000);
    }
    public void grav() {
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
    public void crash() {
        //BIRB FAILLLLLLLLlllllllliiiiiiii
    	if(relY <= pipeY + forgiveness && relY >= pipeGapY - forgiveness) {
    		score += 1;
    	}
    	else if(pipeX <= relX) {
    		System.exit(0);
    	}
    }
    public void pipeScrol() {
        //PIPE scrol
    	pipeX -= scrolSped;
    	
    	if(pipeX <= - pipeSize - 1) {
    		pipeX = WIDTH + 50;
    		pipeY = (int) random(HEIGHT - 100);
    		pipeGapY = pipeGap + pipeY;
    	}
    }
    static public void main(String[] args) {
        PApplet.main(FlappyBird.class.getName());
    }
}
