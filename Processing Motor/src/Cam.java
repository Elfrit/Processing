import processing.core.*;

import peasy.*;

public class Cam extends PApplet{
	PeasyCam cam;
	
	public static void main(String[] args) {
		PApplet.main("Cam");
	}

	public void settings() {
	  size(200,200,P3D);
	  
	}
	
	public void setup(){
		cam = new PeasyCam(this, 100);
		 cam.setMinimumDistance(50);
		 cam.setMaximumDistance(500);
		 cam.setYawRotationMode();
	}
	public void draw() {
	  rotateX((float) -.5);
	  rotateY((float) -.5);
	  background(0);
	  fill(255,0,0);
	  box(30);
	  pushMatrix();
	  translate(0,0,20);
	  fill(0,0,255);
	  box(5);
	  popMatrix();
	}
}
