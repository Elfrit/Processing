import java.util.ArrayList;
import queasycam.*;
import processing.core.*;

public class Map_Creator extends PApplet{
	
	
	public Map_Interface otherWindow;
	
	
	private Maps ground = new Maps(1300,this);
	QueasyCam cam;
	ArrayList<Cubes> blocs = new ArrayList<Cubes>();
	//private PVector Position_1;
	//private PVector Position_2;
	boolean isLeft, isRight, isUp, isDown, Zup,Zdown; 
	//private static int[] color = {255,255,255};
	PVector velocity = new PVector(0,0,0);
	//PVector pose_1 = new PVector(0,-100,0);
	//PVector pose_2 = new PVector(100,100,100);
	//Cubes cube = new Cubes(pose_1,pose_2,color,this);
	
	public static void main(String[] args) {
		PApplet.main("Map_Creator");
	}
	
	
	public void settings() {
	      size(640, 640, P3D);
	      otherWindow = new Map_Interface();
	      
	}
	
	public void setup(){
		cam = new QueasyCam(this);
		
	}
	
	public void exit()
	  {
	    otherWindow.dispose();
	    super.exit();
	  }


	boolean setMove(int k, boolean b) {
		  switch (keyCode) {
		  case UP:
		    return isUp = b;
		 
		  case DOWN:
		    return isDown = b;
		 
		  case LEFT:
		    return isLeft = b;
		 
		  case RIGHT:
		    return isRight = b;
		  
		  }
		  
		  switch(k) {
		  case 'p':
			    return Zup = b;
		  case 'm':
			    return Zdown = b;
			    
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
			 
		  
//	public void MousePressed() {
//		PVector xyz1 = new PVector(mouseX, mouseY, 0);
//		PVector xyz2 = new PVector(); 
//		Cubes cube = new Cubes(xyz1, xyz2, color, this);
//		blocs.add(cube);
//	}
	
	public void MouseDragged(){
		
	}
	
	public void MouseReleased(){
		
	}
	
	public void update() {
		
		//cube.setPosition(velocity.x, velocity.y,velocity.z);
		//cube.setPosition_1(velocity.x, velocity.y,velocity.z);
		//cube.setPosition_2(velocity.x, velocity.y,velocity.z);
		
//		 System.out.println(cube.getPosition());
//		 System.out.println(cube.getPosition_1());
//		 System.out.println(cube.getPosition_2());
//		 System.out.println("Je passe ici");
		
		
		
		 if (this.isLeft) {
			 this.velocity.x = 1;
		 }
		 if (this.isRight) {
			 this.velocity.x = -1;
		 }
		 if (this.Zdown){
			 this.velocity.z = -1;
		 }
		 if (this.Zdown){
			 this.velocity.z = 1;
		 }
		 if (this.isUp){
			 this.velocity.y = -1;
		 }
		 if (this.isDown){
			 this.velocity.y = 1;
		 }
		 
		 if (keyPressed == false){
	    	  this.velocity.x = 0;
	    	  this.velocity.y = 0;
	    	  this.velocity.z = 0;
	      }
		
	}
	
	public void draw() {
		
		background(255,180,70);
		translate(width/2, height/2);
		rotateY(2);
		this.update();
		if (blocs.size()!=0) {
			for (int i=0; i<blocs.size(); i++)
				blocs.get(i).display();
		}
		//cube.display();
		ground.display();
		//box(300);
		//box(50);
		
	}
	
	
	
}
