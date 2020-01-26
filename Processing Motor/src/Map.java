import peasy.PeasyCam;
import processing.core.*;

public class Map extends PApplet{
	
	PVector pose_1 = new PVector(0,0,0);
	PVector pose_2 = new PVector(50,50,50);
	PVector pose_3 = new PVector(200,0,0);
	PVector pose_4 = new PVector(400,100,100);
	
	PVector pose_5 = new PVector(200,-10,0);
	PVector pose_6 = new PVector(400,-100,100);
	
	PVector velocity = new PVector(0,0,0);
	PeasyCam cam;
	
	int[] x = {255,255,255};
	public Cubes cube1 = new Cubes(pose_1, pose_2, x, this); //Ici cube 1 est notre "personnage", le main cube
	public Cubes cube2 = new Cubes(pose_3, pose_4, x, this);
	public Cubes cube3 = new Cubes(pose_5, pose_6, x, this);
	public Cubes[] cube = new Cubes[3];
	
	public Ground ground = new Ground(2100,this); //doit toujours etre impair.. a corriger ?
	
	public static void main(String[] args) {
		PApplet.main("Map");
	}
	
	
	public void settings() {
	      size(640, 640, P3D);
	      
	}
	 
	public void setup() {
		cube[0] = cube1;
		//cube2.setPosition(cube2.getPosition_1().x-cube2.getPosition_2().x/2,0,0);
		cube[1] = cube2;
		cube[2] = cube3;
		cam = new PeasyCam(this, 400,300,300,0);
		cam.setMinimumDistance(50);
		cam.setMaximumDistance(500);
	}
	 
	 
	 public void update() {
		 cube1.setPosition(velocity.x, velocity.y,velocity.z);
		 cube1.setPosition_1(velocity.x,velocity.y,velocity.z);
		 cube1.setPosition_2(velocity.x,velocity.y,velocity.z);
		 System.out.println("=========================");
		 //System.out.println("Position="+cube1.getPosition());
		 System.out.println("Position_1="+cube1.getPosition_1());
		 System.out.println("Position_2="+cube1.getPosition_2());
		 System.out.println("=========================");
		 System.out.println("Position_1="+cube2.getPosition_1());
		 System.out.println("Position_2="+cube2.getPosition_2());
		 System.out.println("velocew="+velocity.x);
		 //System.out.println("Border="+ground.getBorderX());
		 System.out.println("=========================");
		 // Premiere serie de collision pour les murs (bloques non compris)
		 
		 if (keyPressed == true){
			 if (key == 'd') {
				 this.velocity.x = 1;
			 }
			 if (key == 'q') {
				 this.velocity.x = -1;
			 }
			 if (key == 'z'){
				 this.velocity.z = -1;
			 }
			 if (key == 's'){
				 this.velocity.z = 1;
			 }
			 if (key == BACKSPACE){
				 this.velocity.y = -1;
			 }
			 if (key == TAB){
				 this.velocity.y = 1;
			 }
		 }
		 
	      
		 
		 if (cube1.getPosition().x>ground.getBorderX() || cube1.getPosition().x<-(ground.getBorderX())) {
			 velocity.x*=-1;
			 velocity.y*=-1;
			 velocity.z*=-1;
		 }
		 
		 
		 
//		 if (cube1.getPosition().y>ground.getBorderY() || cube1.getPosition().y<-(ground.getBorderY())) {
//			 velocity.x*=-1;
//		 }
//		 
//		 if (cube1.getPosition().z>ground.getBorderZ() || cube1.getPosition().z<-(ground.getBorderZ())) {
//			 velocity.x*=-1;
//		 }
		 
		 //deuxième serie de collision, cette fois si avec les blocs environnant
		 
		 for(int i=1; i<cube.length; i++) {
			 
			 //Commence par x
			 
			 if (((cube1.getPosition_1().x > cube[i].getPosition_1().x && cube1.getPosition_2().x < cube[i].getPosition_1().x)
				|| (cube1.getPosition_1().x < cube[i].getPosition_1().x && cube1.getPosition_2().x > cube[i].getPosition_1().x)
				|| (cube1.getPosition_1().x == cube[i].getPosition_1().x) //&& cube1.getPosition_2().y == cube[i].getPosition_1().y)
				|| (cube1.getPosition_2().x > cube[i].getPosition_1().x && cube1.getPosition_1().x < cube[i].getPosition_1().x)
				|| (cube1.getPosition_2().x < cube[i].getPosition_1().x && cube1.getPosition_1().x > cube[i].getPosition_1().x)
				|| (cube1.getPosition_2().x == cube[i].getPosition_1().x) //&& cube1.getPosition_1().y == cube[i].getPosition_1().y)
							 
				|| (cube1.getPosition_1().x > cube[i].getPosition_2().x && cube1.getPosition_2().x < cube[i].getPosition_2().x)
				|| (cube1.getPosition_1().x < cube[i].getPosition_2().x && cube1.getPosition_2().x > cube[i].getPosition_2().x)
				|| (cube1.getPosition_1().x == cube[i].getPosition_2().x) //&& cube1.getPosition_2().y == cube[i].getPosition_2().y)
				|| (cube1.getPosition_2().x > cube[i].getPosition_2().x && cube1.getPosition_1().x < cube[i].getPosition_2().x)
				|| (cube1.getPosition_2().x < cube[i].getPosition_2().x && cube1.getPosition_1().y > cube[i].getPosition_2().x)
				|| (cube1.getPosition_2().x == cube[i].getPosition_2().x) //&& cube1.getPosition_1().y == cube[i].getPosition_2().y))
					 
				|| (cube1.getPosition_2().x == cube[i].getPosition_2().x && cube1.getPosition_1().x == cube[i].getPosition_1().x)
				|| (cube1.getPosition_2().x > cube[i].getPosition_2().x && cube1.getPosition_1().x < cube[i].getPosition_1().x) // a verifier
				|| (cube1.getPosition_1().x > cube[i].getPosition_1().x && cube1.getPosition_2().x < cube[i].getPosition_2().x))
					 
				
				&& 
				 
				((cube1.getPosition_1().y > cube[i].getPosition_1().y && cube1.getPosition_2().y < cube[i].getPosition_1().y)
				|| (cube1.getPosition_1().y < cube[i].getPosition_1().y && cube1.getPosition_2().y > cube[i].getPosition_1().y)
				|| (cube1.getPosition_1().y == cube[i].getPosition_1().y) //&& cube1.getPosition_2().y == cube[i].getPosition_1().y)
				|| (cube1.getPosition_2().y > cube[i].getPosition_1().y && cube1.getPosition_1().y < cube[i].getPosition_1().y)
				|| (cube1.getPosition_2().y < cube[i].getPosition_1().y && cube1.getPosition_1().y > cube[i].getPosition_1().y)
				|| (cube1.getPosition_2().y == cube[i].getPosition_1().y) //&& cube1.getPosition_1().y == cube[i].getPosition_1().y)
						 
				|| (cube1.getPosition_1().y > cube[i].getPosition_2().y && cube1.getPosition_2().y < cube[i].getPosition_2().y)
				|| (cube1.getPosition_1().y < cube[i].getPosition_2().y && cube1.getPosition_2().y > cube[i].getPosition_2().y)
				|| (cube1.getPosition_1().y == cube[i].getPosition_2().y) //&& cube1.getPosition_2().y == cube[i].getPosition_2().y)
				|| (cube1.getPosition_2().y > cube[i].getPosition_2().y && cube1.getPosition_1().y < cube[i].getPosition_2().y)
				|| (cube1.getPosition_2().y < cube[i].getPosition_2().y && cube1.getPosition_1().y > cube[i].getPosition_2().y)
				|| (cube1.getPosition_2().y == cube[i].getPosition_2().y) //&& cube1.getPosition_1().y == cube[i].getPosition_2().y))
				 
				|| (cube1.getPosition_2().y == cube[i].getPosition_2().y && cube1.getPosition_1().y == cube[i].getPosition_1().y)
				|| (cube1.getPosition_2().y > cube[i].getPosition_2().y && cube1.getPosition_1().y < cube[i].getPosition_1().y) // a verifier
				|| (cube1.getPosition_1().y > cube[i].getPosition_1().y && cube1.getPosition_2().y < cube[i].getPosition_2().y))
				 
				&&
				
					 
				((cube1.getPosition_1().z > cube[i].getPosition_1().z && cube1.getPosition_2().z < cube[i].getPosition_1().z)
			 	|| (cube1.getPosition_1().z < cube[i].getPosition_1().z && cube1.getPosition_2().z > cube[i].getPosition_1().z)
				|| (cube1.getPosition_1().z == cube[i].getPosition_1().z) //&& cube1.getPosition_2().z == cube[i].getPosition_1().z)
				//|| (cube1.getPosition_1().z > cube[i].getPosition_1().z && cube1.getPosition_2().z > cube[i].getPosition_1().z)
				|| (cube1.getPosition_2().z > cube[i].getPosition_1().z && cube1.getPosition_1().z < cube[i].getPosition_1().z)
				|| (cube1.getPosition_2().z < cube[i].getPosition_1().z && cube1.getPosition_1().z > cube[i].getPosition_1().z)
				|| (cube1.getPosition_2().z == cube[i].getPosition_1().z) //&& cube1.getPosition_1().z == cube[i].getPosition_1().z)
				
				
				|| (cube1.getPosition_1().z > cube[i].getPosition_2().z && cube1.getPosition_2().z < cube[i].getPosition_2().z)
				|| (cube1.getPosition_1().z < cube[i].getPosition_2().z && cube1.getPosition_2().z > cube[i].getPosition_2().z)
				|| (cube1.getPosition_1().z == cube[i].getPosition_2().z) //&& cube1.getPosition_2().z == cube[i].getPosition_2().z)
				|| (cube1.getPosition_2().z > cube[i].getPosition_2().z && cube1.getPosition_1().z < cube[i].getPosition_2().z)
				|| (cube1.getPosition_2().z < cube[i].getPosition_2().z && cube1.getPosition_1().z > cube[i].getPosition_2().z)
				|| (cube1.getPosition_2().z == cube[i].getPosition_2().z)
					 	
				|| (cube1.getPosition_2().z == cube[i].getPosition_2().x && cube1.getPosition_1().z == cube[i].getPosition_1().z)
				|| (cube1.getPosition_2().z > cube[i].getPosition_2().z && cube1.getPosition_1().z < cube[i].getPosition_1().z) // a verifier
				|| (cube1.getPosition_1().z > cube[i].getPosition_1().z && cube1.getPosition_2().z < cube[i].getPosition_2().z))){ //&& cube1.getPosition_1().z == cube[i].getPosition_2().z))){
				 
				 	cube1.setPosition(-1*((velocity.x*2)), -1*((velocity.y*2)), -1*((velocity.z*2)));
				 	cube1.setPosition_1(-1*((velocity.x*2)), -1*((velocity.y*2)), -1*((velocity.z*2)));
				 	cube1.setPosition_2(-1*((velocity.x*2)), -1*((velocity.y*2)), -1*((velocity.z*2)));	
			 }		
		 }
		 
		 if (keyPressed == false){
	    	  this.velocity.x = 0;
	    	  this.velocity.y = 0;
	    	  this.velocity.z = 0;
	      }
//		 while (cube1.getPosition_1().y<0) {
//			 cube1.setPosition(0,-1,0);
//			 cube1.setPosition_1(0,-1,0);
//			 cube1.setPosition_2(0,-1,0);
//		 }
	 }
	 
	 
	 public void draw() {
	      this.background(50);
	      lights();

	 	  //camera(mouseX, height/2, (height/2) / tan(PI/6), mouseX, height/2, 0, 0, 1, 0);
	 	  translate(width/2, height/2);
	      stroke(255);
	      noFill(); 
	      
//	      for (Cubes c : cubies) {
//	        c.update();
	      this.update();
	      cube1.display();
	      cube2.display();
	      cube3.display();
	      ground.display();
	 }
	 
//	 public void mouseDragged() {
//		 if 
//	 }
}
