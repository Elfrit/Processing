import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

import processing.core.*;
import queasycam.QueasyCam;

public class Map_Interface_JFrame extends JFrame{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	public Map_Interface_JFrame(String nom, int w, int h) {
		super (nom);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		JPanel PN = new JPanel();
		JPanel PS = new JPanel();
		
		this.add(PN, BorderLayout.NORTH);
		this.add(PS, BorderLayout.SOUTH);
		
		
		
		
		
	}
	
	
	PVector multi_value = new PVector(width, height/2);
	PVector heigths = new PVector(width, 2*(height/2));
	PVector weigth = new PVector(width, 3*(height/2));
	PVector deepth = new PVector(width, 4*(height/2));
	PVector x_fig_value = new PVector(width, 5*(height/2));
	PVector y_fig_value = new PVector(width, 6*(height/2));
	PVector z_fig_value = new PVector(width, 7*(height/2));
	ArrayList<Cubes> cubes = new ArrayList<Cubes>();
	int[] color = {255,255,255};
	Cubes selectedObject; /*= new Cubes(new PVector(0,0,0),new PVector(0,0,0),color, this);*/
	
	
	PVector[] allCircles = {multi_value, heigths, weigth, deepth, x_fig_value, y_fig_value, z_fig_value};
	
	
	
	public static void main(String[] args) {
		PApplet.main("Map_Interface");
	}
	
	public void settings() {
		size(300, 640);
	}
	
	public void setup() {
	}
	
	
//	public Map_Interface() {
//	    super();
//	    PApplet.runSketch(new String[] {this.getClass().getSimpleName()}, this);
//	  }
//	
	
	
	
//	public Map_Interface(PApplet p){
//		this.parent = p;
//	}
	
	public void mouseClicked() {
		
		if (inObject()) {
			this.cubes.add(selectedObject);
		}
		
//		for (int i=0; i<allCircles.length; i++) {
//			if (inCircle(allCircles[i].x, allCircles[i].y))
//				System.out.println("IZOKÉ");
//		}
//		System.out.println(inObject());
//		if (inObject()) {
//			PVector pose_1 = new  PVector(x_fig_value.x, y_fig_value.x, z_fig_value.x);
//			PVector pose_2 = new PVector(weigth.x, heigths.x, deepth.x);
//			int[] color = {255,200,100};
//			selectedObject = new Cubes(pose_1,pose_2,color, this);
//		}
	}
	
	public void mouseDragged() {
		for (int i=0; i<allCircles.length; i++) {
			if (inCircle(allCircles[i].x, allCircles[i].y)) {
				if (mouseX<(width/3)*2 && mouseX>width/3)
					allCircles[i].x = mouseX;
			}
		}
		
	}
	
	public void mouseReleased() {
		  
	}
	
	public boolean inCircle(float x, float y) {
		float disX = x - mouseX;
		float disY = y - mouseY;
		if (sqrt(sq(disX) + sq(disY)) < 10/2 ) 
			return true;
		return false;
	}
	
	public boolean inObject() {
//		System.out.println("X1 = "+width/10+" y1 = "+(float) (width*0.80)+" x2 = "+(float) (height*0.60)+" y2 = "+height*0.30);
//		System.out.println("MouseX= "+mouseX+" || Mouse Y ="+mouseY);
		if(mouseX>width/10 && mouseX<(float) (width*0.80) && mouseY>(float) (height*0.60) && mouseY<height*0.9) 
			return true;
		return false;
	}
	
	public void update() {
		PVector pose_1 = new PVector(x_fig_value.x-width,z_fig_value.x-width,z_fig_value.x-width);
		PVector pose_2 = new PVector(weigth.x-width, heigths.x-width, deepth.x-width);
		int col_1 = new Random().nextInt(255);
		int col_2 = new Random().nextInt(255);
		int col_3 = new Random().nextInt(255);
		int[] col = {col_1,col_2,col_3};
		this.selectedObject = new Cubes(pose_1,pose_2,col, this);
		System.out.println(inObject());
		System.out.println(((Cubes) selectedObject).printObject());
	}
	
	public void draw() {
		this.update();
		//ellipse(50,50, 100, 100);
//		ellipse(multi_value.x, multi_value.y, 10, 10);
//		ellipse(heigth.x, heigth.y, 10, 10);
//		ellipse(weigth.x, weigth.y, 10, 10);
//		ellipse(50,50, 20, 100);
		background(255);
		fill(0);
		//ellipse(100, 50, 100, 100);
		ellipse(multi_value.x, multi_value.y, 20, 20);
		ellipse(heigths.x, heigths.y, 20, 20);
		ellipse(weigth.x, weigth.y, 20, 20);
		ellipse(deepth.x, deepth.y, 20, 20);
		ellipse(x_fig_value.x, x_fig_value.y, 20, 20);
		ellipse(y_fig_value.x, y_fig_value.y, 20, 20);
		ellipse(z_fig_value.x, z_fig_value.y, 20, 20);
		
		
		line(width/3, multi_value.y, (width/3)*2, multi_value.y);
		line(width/3, heigths.y, (width/3)*2, heigths.y);
		line(width/3, weigth.y, (width/3)*2, weigth.y);
		line(width/3, deepth.y, (width/3)*2, deepth.y);
		line(width/3, x_fig_value.y, (width/3)*2, x_fig_value.y);
		line(width/3, y_fig_value.y, (width/3)*2, y_fig_value.y);
		line(width/3, z_fig_value.y, (width/3)*2, z_fig_value.y);
		
		//System.out.println(height*0.9);
		
		//384-----256p du haut
		//192-----448p du haut
		//donc 576, il faut donc être 64p plus haut
		
		fill(255,30,100);
		rect(width/10, (float) ((height)*0.60), (float) (width*0.80), (float) (height*0.30));
		//System.out.println("X1 = "+width/10+" y1 = "+(float) (width*0.80)+" x2 = "+(float) (height*0.60)+" y2 = "+height*0.30);
		//noStroke();
		
		
		//System.out.println("X1 = "+width/10+" y1 = "+(float) (width*0.80)+" x2 = "+(float) (height*0.60)+" y2 = "+heigth.y*2);
		
//		ellipse(50,50, 20, 100);
	}

	public Cubes getSelectedObject() {
		return selectedObject;
	}

	public void setSelectedObject(Cubes selectedObject) {
		this.selectedObject = selectedObject;
	}
	
	public ArrayList<Cubes> getCubes(){
		return this.cubes;
	}
	
}
