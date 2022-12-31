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
	
	//GROUND
	int gHeight = 100;
	boolean gKill = true;
	
//Core Mecanics
	
	//Birb
	int fallrateB = startFallrate;
	int bounce = startBounce;
	int bounceDecay = -startBounce/bounceDecayRate;
	int score = 0;
	boolean loss = false;
	
	//Pipe
	float scrolSped = scrolSpedStart;
	int pipeGapY = pipeY - pipeGap;			//Location of the bottem of the upper pipe (same as top of the gap)
	
	//Ground
	int gY = 0;
	
    @Override
    public void settings() {
        size(WIDTH, HEIGHT);
    }
    @Override
    public void setup() {
        
    }
    
    @Override
    public void mousePressed() {
    	if(loss == false) {
    		fallrateB = -15;
    		bounce = startBounce;
    	}
    }

//Code Runner
    @Override
    public void draw() {
    	System.out.println(loss);
    	
		paint();
		if(!loss) {
    		crash();
    		pipeScrol();
    		fill(0, 0, 0);
    		textSize(10);
    		println("SCORE: " + score);
    		text("SCORE: " + score, 0, 0);
    	}
    	else if(loss) {
    		textSize(HEIGHT/12);
    		fill(80, 0, 0);
    		text("GAME\nOVER", WIDTH/2, HEIGHT/2);
    	}
		grav();
    }
    
//Code that is being ran
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
        	
        //Ground
        	fill(80, 100, 0);
        	noStroke();
        	rect(0, HEIGHT - gHeight, WIDTH, 1000);
        	
        //Score
    		fill(0, 0, 80);
    		textSize(10);
    		println("SCORE: " + score);
    		text("SCORE: " + score, 0, 0);
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

    	}
    	else if(pipeX <= relX && relX <= pipeX + 20) {
    		loss = true;
    	}
    	if(relY >= HEIGHT) {
    		
    	}
    }
    public void pipeScrol() {
        //PIPE scrol
    	pipeX -= scrolSped;
    	
    	if(pipeX <= - pipeSize - 1) {
    		pipeX = WIDTH + 50;
    		pipeY = (int) random(HEIGHT - 100) + pipeGap + 50;
    		pipeGapY = pipeY - pipeGap;
    		score += 1;
    	}
    }
    static public void main(String[] args) {
        PApplet.main(FlappyBird.class.getName());
    }
}
