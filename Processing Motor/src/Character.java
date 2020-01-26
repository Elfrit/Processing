import processing.core.*;

public class Character {
	
	Cubes[] hitBox = new Cubes[6];
	Cubes positionBox;
	PVector Position = new PVector();
	PApplet parent;
	
	
	PVector velocity = new PVector(0,0,0);
	//int Jump;
	int Strength;
	int Pv;
	
	
	public Character(PApplet p) {
		
		this.parent=p;
		//this.Position=Position;
		
		
//		PVector headUp = new PVector(9,-9,10);
//		PVector headDown = new PVector(16,-14,13);
//		
//		PVector bodyUp = new PVector(11,-15,10);
//		PVector bodyDown = new PVector(14,-20,13);
//		
//		PVector armRUp = new PVector(9,-15,10);
//		PVector armRDown = new PVector(10,-20,13);
//		
//		PVector armLUp = new PVector(15,-15,10);
//		PVector armLDown = new PVector(16,-20,13);
//		
//		PVector legRUp = new PVector(11,-20,13);
//		PVector legRDown = new PVector(12,-25,13);
//		
//		PVector legLUp = new PVector(13,-20,13);
//		PVector legLDown = new PVector(14,-25,13);
//		
		
		
		

		PVector headUp = new PVector(9,-18,10);
		PVector headDown = new PVector(16,-12,13);
		
		PVector bodyUp = new PVector(11,-11,10);
		PVector bodyDown = new PVector(14,-6,13);
		
		PVector armRUp = new PVector(9,-11,10);
		PVector armRDown = new PVector(10,-6,13);
		
		PVector armLUp = new PVector(15,-11,10);
		PVector armLDown = new PVector(16,-6,13);
		
		PVector legRUp = new PVector(11,-6,13);
		PVector legRDown = new PVector(12,-1,13);
		
		PVector legLUp = new PVector(13,-6,13);
		PVector legLDown = new PVector(14,-1,13);
		
		
		
		
		int[] color = {255,255,255};
		
		hitBox[0] = new Cubes(headUp,headDown,color,this.parent);
		hitBox[1] = new Cubes(bodyUp,bodyDown,color,this.parent);
		hitBox[2] = new Cubes(armRUp,armRDown,color,this.parent);
		hitBox[3] = new Cubes(armLUp,armLDown,color,this.parent);
		hitBox[4] = new Cubes(legRUp,legRDown,color,this.parent);
		hitBox[5] = new Cubes(legLUp,legLDown,color,this.parent);
		
		
		PVector highPosition = new PVector(9,-1,10);
		PVector lowerPosition = new PVector(16,-18,13);
		this.positionBox = new Cubes(highPosition, lowerPosition, color, this.parent);
		
	}
	
	public void drawCharacter() {
		//this.parent.fill(255);
		this.parent.beginShape();
		
		//this.positionBox.drawCube();
		
		for (int k=0; k<hitBox.length; k++){
			this.hitBox[k].drawCube(); 
		}
		
		
	    this.parent.endShape();
		
	}
	
	public void display() {
		this.parent.pushMatrix();
		this.parent.translate(Position.x, Position.y, Position.z);
		this.parent.noStroke();
	    this.drawCharacter(); // Farm out shape to another method
	    this.parent.popMatrix();
	}
	
	public float Jump(float gravity, float JumpH){
		float x = JumpH+gravity;
		x=(float) ((float)Math.round(x*10)/ 10.0); //Methode pour garder 1 decimale après la virgule
		
		this.setPosition(0, x, 0);
		for(int j=0; j<this.hitBox.length; j++) {
			this.hitBox[j].setPosition_1(0, x, 0);
			this.hitBox[j].setPosition_2(0, x, 0);
		}
		this.setPositionBox(0, x, 0);
		return x;
	}
	
	public boolean Fall(float Hauteur, float BorderMax,  float gravity) {
		if (Hauteur<BorderMax) {
			//System.out.println("Je Passe ici");
			//x=(float) ((float)Math.round(x*10)/ 10.0); //Methode pour garder 1 decimale après la virgule
			
			this.setPosition(0, gravity, 0);
			for(int j=0; j<this.hitBox.length; j++) {
				this.hitBox[j].setPosition_1(0, gravity, 0);
				this.hitBox[j].setPosition_2(0, gravity, 0);
			}
			this.setPositionBox(0, gravity, 0);
			//System.out.println("Je Suis passé par Return true");
			return true;
			
		}
		
		else if (Hauteur>BorderMax-2) {
			//System.out.println("Je Passe par là");
			this.setPosition(0, BorderMax-Hauteur-2, 0);
			for(int j=0; j<this.hitBox.length; j++) {
				this.hitBox[j].setPosition_1(0, BorderMax-Hauteur-2, 0);
				this.hitBox[j].setPosition_2(0, BorderMax-Hauteur-2, 0);
			}
			this.setPositionBox(0, BorderMax-Hauteur-2, 0);
			return false;
		}
		
		return true;
	}
	
	
	

	public Cubes[] getHitBox() {
		return hitBox;
	}

	public void setHitBox(float x, float y, float z) {
		//this.setPosition(x,y,z);
		for (int i=0; i<this.hitBox.length; i++) {
			//this.hitBox[i].setPosition(x, y, z);
			this.hitBox[i].setPosition_1(x, y, z);
			this.hitBox[i].setPosition_2(x, y, z);
		}
	}

	public PVector getPosition() {
		return Position;
	}

	public void setPosition(float x, float y, float z) {
		this.Position.x+=x;
		this.Position.y+=y;
		this.Position.z+=z;
	}

	public Cubes getPositionBox() {
		return positionBox;
	}

	public void setPositionBox(float x, float y, float z) {
		//this.positionBox.setPosition(x, y, z);
		this.positionBox.setPosition_1(x, y, z);
		this.positionBox.setPosition_2(x, y, z);
	}
	
	public void setVelocity(float x, float y, float z) {
		this.velocity.x=x;
		this.velocity.y=y;
		this.velocity.z=z;
	}

	public PVector getVelocity() {
		return this.velocity;
	}
	
}
