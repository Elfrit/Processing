import java.util.ArrayList;
//import peasy.*;

import processing.core.*;

public class Ground {
	int borderX;

	PApplet parent;

	ArrayList<Cubes> cubes = new ArrayList<Cubes>();
	
	int border;
	
	public Ground(int Borderx/*, int Bordery, int Borderz*/, PApplet p){
		this.borderX=Borderx;

		this.parent=p;
	
		
		int divX = (int)this.borderX/100; //nombre de carré en x
		this.border=this.borderX/2;

		
		int parite = 0;
		for (int j=0; j<divX; j++) {
			for (int i=0; i<divX; i++) {
				PVector vec1 = new PVector(0+(i*100),0,0+(j*100));
				PVector vec2 = new PVector(100+(i*100),50,100+(j*100));
				if (parite!=1) {
					int[] x = {64,64,64};
					cubes.add(new Cubes(vec1,vec2,x,this.parent));
					parite++;
				}
				else {
					int[] y = {255,255,255};
					cubes.add(new Cubes(vec1,vec2,y,this.parent));
					parite--;
				}
			}
		}
		

	}
	
	
	public void drawGround() {
		//this.parent.fill(255);
		this.parent.beginShape(	);
		for (int k=0; k<cubes.size(); k++){
			cubes.get(k).drawCube();
		}
		
	    this.parent.endShape();
		
		
		
	}
	
	public void display(){
		this.parent.pushMatrix();
		this.parent.translate(-this.border, 100, -this.border);
		this.parent.noStroke();
		parent.rotateX((float) (-Math.PI*2));
//	 	parent.rotateY((float) (parent.frameCount * 0.002));
//	 	parent.rotateZ((float) (parent.frameCount * 0.001));
	    this.drawGround(); // Farm out shape to another method
	    this.parent.popMatrix();
	}


	public int getBorderX() {
		return borderX;
	}

	public void setBorderX(int borderX) {
		this.borderX = borderX;
	}
}
