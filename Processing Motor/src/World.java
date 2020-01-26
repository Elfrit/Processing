import peasy.PeasyCam;
import processing.core.*;

public class World extends PApplet{
	
	//PVector pose_1 = new PVector(0,0,0);
	PVector pose_2 = new PVector(10,10,10);
	PVector pose_3 = new PVector(200,0,0);
	PVector pose_4 = new PVector(400,-100,100);
	
	PVector pose_5 = new PVector(200,-10,0);
	PVector pose_6 = new PVector(400,-100,100);
	
	//PVector velocity = new PVector(0,0,0);
	
	boolean jump = true;
	float JumpHeigth = (float)0.1;
	float GravityHeigthMin = (float) 0.0;
	float Gravity = (float) 0.30;
	boolean canFall = false;
	
	boolean isLeft, isRight, isUp, isDown, isJump; 
	
	PVector tempVeloce = new PVector(1301,1301,1301);
	
	PeasyCam cam;
	
	int[] x = {255,255,255};
	//public Cubes cube1 = new Cubes(pose_1, pose_2, x, this); //Ici cube 1 est notre "personnage", le main cube
	
	public Character mainChar = new Character(this);
	public Cubes cube2 = new Cubes(pose_3, pose_4, x, this);
	public Cubes cube3 = new Cubes(pose_5, pose_6, x, this);
	public Cubes[] cube = new Cubes[2];
	
	public Maps ground = new Maps(1300,this); //doit toujours etre impair.. a corriger ?
	
	public static void main(String[] args) {
		PApplet.main("World");
	}
	
	
	public void settings() {
	      size(640, 640, P3D);
	      
	}
	 
	public void setup() {
		//cube[0] = cube1;
		//cube2.setPosition(cube2.getPosition_1().x-cube2.getPosition_2().x/2,0,0);
		cube[1] = cube2;
		//cube[2] = cube3;
		//mainChar.getVelocity().x, mainChar.getVelocity().y,mainChar.getVelocity().z
		cam = new PeasyCam(this, mainChar.getVelocity().x+400, mainChar.getVelocity().y+270,mainChar.getVelocity().z+200,0);
		cam.setYawRotationMode();
		cam.setMinimumDistance(50);
		cam.setMaximumDistance(500);
	}
	
	boolean setMove(int k, boolean b) {
		  switch (k) {
		  case 'z':
		    return isUp = b;
		 
		  case 's':
		    return isDown = b;
		 
		  case 'q':
		    return isLeft = b;
		 
		  case 'd':
		    return isRight = b;
		    
		  case ' ':
			    return isJump = b;
		 
		  default:
		    return b;
		  }
		}
	
	
		public void keyPressed() {
		  setMove(key, true);
		}
		 
		public void keyReleased() {
		  setMove(key, false);
		}
		
	 
//		 public void mouseDragged() {
//			 	System.out.println("WARNIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIING !!!!!!!!!!!!!!!!!!!!!!!");
//				cam.rotateY(mouseX/PI);
//			}
		 
		
	 public void update() {
		 mainChar.setPosition(mainChar.getVelocity().x, mainChar.getVelocity().y,mainChar.getVelocity().z);
		 mainChar.setPositionBox(mainChar.getVelocity().x, mainChar.getVelocity().y,mainChar.getVelocity().z);
		 mainChar.setHitBox(mainChar.getVelocity().x, mainChar.getVelocity().y, mainChar.getVelocity().z);
		
		 cam.lookAt(mainChar.getPosition().x,mainChar.getPosition().y-50,mainChar.getPosition().z+100, 7);
		 //cam.lookAt(frameCount,frameCount,frameCount, 1000);
		 
		 /*
		mainChar.setPosition(velocity.x, velocity.y,velocity.z);
		mainChar.setPositionBox(velocity.x, velocity.y,velocity.z);
		mainChar.setHitBox(velocity.x, velocity.y,velocity.z);
		*/
		
		 // Premiere serie de collision pour les murs (bloques non compris)
		 
		  
		 
		 if (this.isRight) {
			 this.mainChar.getVelocity().x = 1;
		 }
		 if (this.isLeft) {
			 this.mainChar.getVelocity().x = -1;
		 }
		 if (this.isUp){
			 this.mainChar.getVelocity().z = -1;
		 }
		 if (this.isDown){
			 this.mainChar.getVelocity().z = 1;
		 }
		 if (key == BACKSPACE){
			 this.mainChar.getVelocity().y = -1;
		 }
		 if (key == TAB){
			 this.mainChar.getVelocity().y = 1;
		 }
		 if (this.isJump && this.jump){
			 //if(this.JumpHeigth<=3){
				 this.JumpHeigth=(float)-3.3;
				 this.jump=false;
			 //}
		 }
		 
		 
		/*
			 if (this.isRight) {
				 this.velocity.x = 1;
			 }
			 if (this.isLeft) {
				 this.velocity.x = -1;
			 }
			 if (this.isUp){
				 this.velocity.z = -1;
			 }
			 if (this.isDown){
				 this.velocity.z = 1;
			 }
			 if (key == BACKSPACE){
				 this.velocity.y = -1;
			 }
			 if (key == TAB){
				 this.velocity.y = 1;
			 }
			 if (this.isJump && this.jump){
				 //if(this.JumpHeigth<=3){
					 this.JumpHeigth=(float)-3.3;
					 this.jump=false;
				 //}
			 }
			 */
			 //else
			 

			 //System.out.println(GravityHeigthMin);
			 //System.out.println(JumpHeigth);
//		
//			 if (this.JumpHeigth<=this.GravityHeigthMin && this.jump==false)
//				 this.JumpHeigth = this.mainChar.Jump(this.Gravity, this.JumpHeigth);

			 if (this.JumpHeigth<=0 && this.jump==false)
				 this.JumpHeigth = this.mainChar.Jump(this.Gravity, this.JumpHeigth);

			 
			 //			 if (this.JumpHeigth==this.GravityHeigthMin) {	
//				 this.canFall = true;
//			 }
			 
//			 if (canFall) {
//			 if (this.mainChar.getPositionBox().getPosition_1().y<-3) {
			 
			
			 
			 
			 
			 	//System.out.println(this.mainChar.getPositionBox().getPosition_1().y<-2 );
			 	
			    //System.out.println(this.mainChar.getPositionBox().getPosition_1().y<-2);
				if (this.mainChar.getPositionBox().getPosition_1().y<-2)		
					this.canFall=true;
				
				int j = this.mainChar.getPositionBox().upperThan(cube);
				if (j!=-1) {
					//System.out.println(this.mainChar.getPositionBox().getPosition_1().y<this.cube[j].getPosition_2().y-2);
					if (this.mainChar.getPositionBox().getPosition_1().y<this.cube[j].getPosition_2().y-2)
						this.canFall=true;
	 			}
				
				 float BorderMax = 0;
				 if (this.mainChar.getPositionBox().upperThan(cube)!=-1) { //on cherche s'il existe un cube sur lequel on peut être (plus bas), si c'est le cas, on veut connaitre sa position dans la liste, sinon on retourne -1
				 		 BorderMax = cube[this.mainChar.getPositionBox().upperThan(cube)].getPosition_2().y-2;
				 }
//						 System.out.println("Hauteur = "+this.mainChar.getPositionBox().getPosition_1().y);
//						 System.out.println("Hauteur = "+this.mainChar.getPositionBox().getPosition_2().y);
//						 System.out.println("Gravité = "+this.Gravity);
				 
				//System.out.println(BorderMax);
//---				if (this.mainChar.Fall(this.mainChar.getPositionBox().getPosition_1().y, BorderMax	, this.Gravity)==false) {
//---					this.jump=true;
//---					//canFall=false;
//---				}
				//System.out.println(canFall);
				
				if (this.canFall)
					this.canFall=this.mainChar.Fall(this.mainChar.getPositionBox().getPosition_1().y, BorderMax	, this.Gravity);
				else
					this.jump=true;
						 
				 //}
				 
//						 this.mainChar.Fall(this.mainChar.getPositionBox().getPosition_1().y, 0, this.Gravity);
//			}
			 //System.out.println(frameCount);
				 
		 if(this.tempVeloce.x!=1301 && mainChar.getVelocity().x==0 && mainChar.getVelocity().y==0 && mainChar.getVelocity().z==0 ) {
				this.tempVeloce.x=1301;
				this.tempVeloce.y=1301;
				this.tempVeloce.z=1301;
		 } 
			 
			 //Il faut avoir un effet de gravité vers le bas
		 System.out.println(this.tempVeloce+"||||||||"+mainChar.getVelocity());
		 if (this.tempVeloce.x == mainChar.getVelocity().x && this.tempVeloce.y == mainChar.getVelocity().y && this.tempVeloce.z == mainChar.getVelocity().z) {
			 this.mainChar.setVelocity(0,0,0);
		 }
		 
		 System.out.println(this.tempVeloce+"||||||||"+mainChar.getVelocity());
			 
			 
			 
//		 System.out.println("JumpHeigth = "+this.JumpHeigth);
//		 System.out.println("JUmp = "+this.jump);
//		 System.out.println("GravitéMin = "+this.GravityHeigthMin);

		
		
		
		if (mainChar.getPosition().x>ground.getBorderX() || mainChar.getPosition().x<-(ground.getBorderX())
				|| mainChar.getPosition().y>0 || mainChar.getPosition().y<-(ground.getBorderX())
				|| mainChar.getPosition().z>ground.getBorderX() || mainChar.getPosition().z<-(ground.getBorderX())) {
			
			this.mainChar.getVelocity().x*=-1;
			this.mainChar.getVelocity().y*=-1;
			this.mainChar.getVelocity().z*=-1;
			/*
				 velocity.x*=-1;
				 velocity.y*=-1;
				 velocity.z*=-1;
			*/
		}
		 
		 //deuxième serie de collision, cette fois si avec les blocs environnant
		//System.out.println(mainChar.getPosition());
//		System.out.println(mainChar.getPositionBox().getPosition_1());
//		System.out.println(mainChar.getPositionBox().getPosition_2());
		
		 if (mainChar.getPositionBox().Collision(cube)){ //&& cube1.getPosition_1().z == cube[i].getPosition_2().z))){
				 
				 	mainChar.setPosition(-1*((this.mainChar.getVelocity().x*2)), -1*((this.mainChar.getVelocity().y*2)), -1*((this.mainChar.getVelocity().z*2)));
				 	mainChar.setPositionBox(-1*((this.mainChar.getVelocity().x*2)), -1*((this.mainChar.getVelocity().y*2)), -1*((this.mainChar.getVelocity().z*2)));
				 	mainChar.setHitBox(-1*((this.mainChar.getVelocity().x*2)), -1*((this.mainChar.getVelocity().y*2)), -1*((this.mainChar.getVelocity().z*2)));
				
				 	System.out.println("Je passe ici");
				 	
				 	this.tempVeloce.x = mainChar.getVelocity().x;
				 	this.tempVeloce.y = mainChar.getVelocity().y;
				 	this.tempVeloce.z = mainChar.getVelocity().z;
				 	
				 	System.out.println("----------------------------------");
				 	
				 	
//				 	this.mainChar.getVelocity().x=0;
//				 	this.mainChar.getVelocity().y=0;
//				 	this.mainChar.getVelocity().z=0;
				 	/*
				 	mainChar.setPosition(-1*((velocity.x*2)), -1*((velocity.y*2)), -1*((velocity.z*2)));
				 	mainChar.setPositionBox(-1*((velocity.x*2)), -1*((velocity.y*2)), -1*((velocity.z*2)));
				 	mainChar.setHitBox(-1*((velocity.x*2)), -1*((velocity.y*2)), -1*((velocity.z*2)));
				
				 	
				 	this.velocity.x=0;
				 	this.velocity.y=0;
				 	this.velocity.z=0;
				 	*/
		}
			
		 if (keyPressed == false){
			 this.mainChar.getVelocity().x = 0;
	    	  this.mainChar.getVelocity().y = 0;
	    	  this.mainChar.getVelocity().z = 0;
			 /*
	    	  this.velocity.x = 0;
	    	  this.velocity.y = 0;
	    	  this.velocity.z = 0;
	      	*/
	      }

		 
		// System.out.println(mainChar.getPosition());
	 }
	 
	
	 
	 public void draw() {
	      this.background(50);
	      lights();

	 	  //camera(mouseX, height/2, (height/2) / tan(PI/6), mouseX, height/2, 0, 0, 1, 0);
	 	  translate(width/2, height/2);
	      stroke(255);
	      noFill(); 
	      this.update();
	      mainChar.display();
	      cube2.display();
	     // cube3.display();
	      ground.display();
	 }
}

