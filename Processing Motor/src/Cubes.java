import processing.core.*;

public class Cubes{
	PVector[] vertices = new PVector[24];
	PVector Position_1;
	PVector Position_2;
	PApplet parent;
	int[] color;
	//PVector position = new PVector((Position_1.x+Position_2.x)/2,(Position_1.y+Position_2.y)/2,(Position_1.z+Position_2.z)/2);
	PVector position = new PVector();
	
	
	//PVector velocity = new PVector (0,0,0);
	
	public Cubes(PVector Position1, PVector Position2, int[] c, PApplet p) {
		this.Position_1=Position1; 
		this.Position_2=Position2;
		this.color=c;
		this.parent=p;
	
		
		vertices[0] = new PVector(this.Position_1.x, this.Position_1.y, this.Position_1.z);
	    vertices[1] = new PVector(this.Position_2.x, this.Position_1.y, this.Position_1.z);
	    vertices[2] = new PVector(this.Position_2.x, this.Position_2.y, this.Position_1.z);
	    vertices[3] = new PVector(this.Position_1.x, this.Position_2.y, this.Position_1.z);
	    
	    vertices[4] = new PVector(this.Position_1.x, this.Position_1.y, this.Position_1.z);
	    vertices[5] = new PVector(this.Position_1.x, this.Position_1.y, this.Position_2.z);
	    vertices[6] = new PVector(this.Position_1.x, this.Position_2.y, this.Position_2.z);
	    vertices[7] = new PVector(this.Position_1.x, this.Position_2.y, this.Position_1.z);
	    
	    vertices[8] = new PVector(this.Position_2.x, this.Position_2.y, this.Position_1.z);
	    vertices[9] = new PVector(this.Position_2.x, this.Position_2.y, this.Position_2.z);
	    vertices[10] = new PVector(this.Position_1.x, this.Position_2.y, this.Position_2.z);
	    vertices[11] = new PVector(this.Position_1.x, this.Position_2.y, this.Position_1.z);
	    
	    vertices[12] = new PVector(this.Position_2.x, this.Position_1.y, this.Position_1.z); 
	    vertices[13] = new PVector(this.Position_2.x, this.Position_1.y, this.Position_2.z);
	    vertices[14] = new PVector(this.Position_2.x, this.Position_2.y, this.Position_2.z);
	    vertices[15] = new PVector(this.Position_2.x, this.Position_2.y, this.Position_1.z);
	    
	    vertices[16] = new PVector(this.Position_2.x, this.Position_2.y, this.Position_2.z);
	    vertices[17] = new PVector(this.Position_2.x, this.Position_1.y, this.Position_2.z);
	    vertices[18] = new PVector(this.Position_1.x, this.Position_1.y, this.Position_2.z);
	    vertices[19] = new PVector(this.Position_1.x, this.Position_2.y, this.Position_2.z);
	    
	    vertices[20] = new PVector(this.Position_1.x, this.Position_1.y, this.Position_1.z);
	    vertices[21] = new PVector(this.Position_1.x, this.Position_1.y, this.Position_2.z);
	    vertices[22] = new PVector(this.Position_2.x, this.Position_1.y, this.Position_2.z);
	    vertices[23] = new PVector(this.Position_2.x, this.Position_1.y, this.Position_1.z);
	    }
	
	public void drawCube() {
			this.parent.fill(this.color[0],this.color[1],this.color[2]);
			this.parent.beginShape(PConstants.QUADS);
			//for (int i=0; i<vertices.length; i++)
			this.parent.vertex(vertices[0].x, vertices[0].y, vertices[0].z);
			this.parent.vertex(vertices[1].x, vertices[1].y, vertices[1].z);
			this.parent.vertex(vertices[2].x, vertices[2].y, vertices[2].z);
			this.parent.vertex(vertices[3].x, vertices[3].y, vertices[3].z);
			this.parent.vertex(vertices[4].x, vertices[4].y, vertices[4].z);
			this.parent.vertex(vertices[5].x, vertices[5].y, vertices[5].z);
			this.parent.vertex(vertices[6].x, vertices[6].y, vertices[6].z);
			this.parent.vertex(vertices[7].x, vertices[7].y, vertices[7].z);
			this.parent.vertex(vertices[8].x, vertices[8].y, vertices[8].z);
			this.parent.vertex(vertices[9].x, vertices[9].y, vertices[9].z);
			this.parent.vertex(vertices[10].x, vertices[10].y, vertices[10].z);
			this.parent.vertex(vertices[11].x, vertices[11].y, vertices[11].z);
			this.parent.vertex(vertices[12].x, vertices[12].y, vertices[12].z);
			this.parent.vertex(vertices[13].x, vertices[13].y, vertices[13].z);
			this.parent.vertex(vertices[14].x, vertices[14].y, vertices[14].z);
			this.parent.vertex(vertices[15].x, vertices[15].y, vertices[15].z);
			this.parent.vertex(vertices[16].x, vertices[16].y, vertices[16].z);
			this.parent.vertex(vertices[17].x, vertices[17].y, vertices[17].z);
			this.parent.vertex(vertices[18].x, vertices[18].y, vertices[18].z);
			this.parent.vertex(vertices[19].x, vertices[19].y, vertices[19].z);
			this.parent.vertex(vertices[20].x, vertices[20].y, vertices[20].z);
			this.parent.vertex(vertices[21].x, vertices[21].y, vertices[21].z);
			this.parent.vertex(vertices[22].x, vertices[22].y, vertices[22].z);
			this.parent.vertex(vertices[23].x, vertices[23].y, vertices[23].z);
			
		    this.parent.endShape();
	}
	
	public void display() {
		this.parent.pushMatrix();
		this.parent.translate(position.x, position.y, position.z);
//		parent.rotateX((float) (parent.frameCount * 0.001));
//	 	parent.rotateY((float) (parent.frameCount * 0.002));
//	 	parent.rotateZ((float) (parent.frameCount * 0.001));
		this.parent.noStroke();
	    this.drawCube(); // Farm out shape to another method
	    this.parent.popMatrix();
    }
	
	public boolean Collision(Cubes[] cube) {
		 for(int i=1; i<cube.length; i++) {
			if (((this.getPosition_1().x > cube[i].getPosition_1().x && this.getPosition_2().x < cube[i].getPosition_1().x)
					|| (this.getPosition_1().x < cube[i].getPosition_1().x && this.getPosition_2().x > cube[i].getPosition_1().x)
					|| (this.getPosition_1().x == cube[i].getPosition_1().x) //&& cube1.getPosition_2().y == cube[i].getPosition_1().y)
					|| (this.getPosition_2().x > cube[i].getPosition_1().x && this.getPosition_1().x < cube[i].getPosition_1().x)
					|| (this.getPosition_2().x < cube[i].getPosition_1().x && this.getPosition_1().x > cube[i].getPosition_1().x)
					|| (this.getPosition_2().x == cube[i].getPosition_1().x) //&& this.getPosition_1().y == cube[i].getPosition_1().y)
					
					|| (this.getPosition_1().x > cube[i].getPosition_2().x && this.getPosition_2().x < cube[i].getPosition_2().x)
					|| (this.getPosition_1().x < cube[i].getPosition_2().x && this.getPosition_2().x > cube[i].getPosition_2().x)
					|| (this.getPosition_1().x == cube[i].getPosition_2().x) //&& this.getPosition_2().y == cube[i].getPosition_2().y)
					|| (this.getPosition_2().x > cube[i].getPosition_2().x && this.getPosition_1().x < cube[i].getPosition_2().x)
					|| (this.getPosition_2().x < cube[i].getPosition_2().x && this.getPosition_1().y > cube[i].getPosition_2().x)
					|| (this.getPosition_2().x == cube[i].getPosition_2().x) //&& this.getPosition_1().y == cube[i].getPosition_2().y))
						 
					|| (this.getPosition_2().x == cube[i].getPosition_2().x && this.getPosition_1().x == cube[i].getPosition_1().x)
					|| (this.getPosition_2().x > cube[i].getPosition_2().x && this.getPosition_1().x < cube[i].getPosition_1().x) // a verifier
					|| (this.getPosition_1().x > cube[i].getPosition_1().x && this.getPosition_2().x < cube[i].getPosition_2().x))
					
					&& 
					 
					((this.getPosition_1().y > cube[i].getPosition_1().y && this.getPosition_2().y < cube[i].getPosition_1().y)
					|| (this.getPosition_1().y < cube[i].getPosition_1().y && this.getPosition_2().y > cube[i].getPosition_1().y)
					|| (this.getPosition_1().y == cube[i].getPosition_1().y) //&& this.getPosition_2().y == cube[i].getPosition_1().y)
					|| (this.getPosition_2().y > cube[i].getPosition_1().y && this.getPosition_1().y < cube[i].getPosition_1().y)
					|| (this.getPosition_2().y < cube[i].getPosition_1().y && this.getPosition_1().y > cube[i].getPosition_1().y)
					|| (this.getPosition_2().y == cube[i].getPosition_1().y) //&& cube1.getPosition_1().y == cube[i].getPosition_1().y)
							 
					|| (this.getPosition_1().y > cube[i].getPosition_2().y && this.getPosition_2().y < cube[i].getPosition_2().y)
					|| (this.getPosition_1().y < cube[i].getPosition_2().y && this.getPosition_2().y > cube[i].getPosition_2().y)
					|| (this.getPosition_1().y == cube[i].getPosition_2().y) //&& this.getPosition_2().y == cube[i].getPosition_2().y)
					|| (this.getPosition_2().y > cube[i].getPosition_2().y && this.getPosition_1().y < cube[i].getPosition_2().y)
					|| (this.getPosition_2().y < cube[i].getPosition_2().y && this.getPosition_1().y > cube[i].getPosition_2().y)
					|| (this.getPosition_2().y == cube[i].getPosition_2().y) //&& this.getPosition_1().y == cube[i].getPosition_2().y))
					 
					|| (this.getPosition_2().y == cube[i].getPosition_2().y && this.getPosition_1().y == cube[i].getPosition_1().y)
					|| (this.getPosition_2().y > cube[i].getPosition_2().y && this.getPosition_1().y < cube[i].getPosition_1().y) // a verifier
					|| (this.getPosition_1().y > cube[i].getPosition_1().y && this.getPosition_2().y < cube[i].getPosition_2().y))
					 
					&&
						 
					((this.getPosition_1().z > cube[i].getPosition_1().z && this.getPosition_2().z < cube[i].getPosition_1().z)
				 	|| (this.getPosition_1().z < cube[i].getPosition_1().z && this.getPosition_2().z > cube[i].getPosition_1().z)
					|| (this.getPosition_1().z == cube[i].getPosition_1().z) //&& this.getPosition_2().z == cube[i].getPosition_1().z)
					//|| (this.getPosition_1().z > cube[i].getPosition_1().z && this.getPosition_2().z > cube[i].getPosition_1().z)
					|| (this.getPosition_2().z > cube[i].getPosition_1().z && this.getPosition_1().z < cube[i].getPosition_1().z)
					|| (this.getPosition_2().z < cube[i].getPosition_1().z && this.getPosition_1().z > cube[i].getPosition_1().z)
					|| (this.getPosition_2().z == cube[i].getPosition_1().z) //&& this.getPosition_1().z == cube[i].getPosition_1().z)
					
					
					|| (this.getPosition_1().z > cube[i].getPosition_2().z && this.getPosition_2().z < cube[i].getPosition_2().z)
					|| (this.getPosition_1().z < cube[i].getPosition_2().z && this.getPosition_2().z > cube[i].getPosition_2().z)
					|| (this.getPosition_1().z == cube[i].getPosition_2().z) //&& cube1.getPosition_2().z == cube[i].getPosition_2().z)
					|| (this.getPosition_2().z > cube[i].getPosition_2().z && this.getPosition_1().z < cube[i].getPosition_2().z)
					|| (this.getPosition_2().z < cube[i].getPosition_2().z && this.getPosition_1().z > cube[i].getPosition_2().z)
					|| (this.getPosition_2().z == cube[i].getPosition_2().z)
						 	
					|| (this.getPosition_2().z == cube[i].getPosition_2().x && this.getPosition_1().z == cube[i].getPosition_1().z)
					|| (this.getPosition_2().z > cube[i].getPosition_2().z && this.getPosition_1().z < cube[i].getPosition_1().z) // a verifier
					|| (this.getPosition_1().z > cube[i].getPosition_1().z && this.getPosition_2().z < cube[i].getPosition_2().z))){
				return true;
			}
		}
		return false;
	}
	
	
	public int upperThan(Cubes[] cube) {
		for (int i=1; i<cube.length ; i++) {
			 
			 if (((this.getPosition_1().x > cube[i].getPosition_1().x && this.getPosition_2().x < cube[i].getPosition_1().x)
						|| (this.getPosition_1().x < cube[i].getPosition_1().x && this.getPosition_2().x > cube[i].getPosition_1().x)
						|| (this.getPosition_1().x == cube[i].getPosition_1().x) //&& cube1.getPosition_2().y == cube[i].getPosition_1().y)
						|| (this.getPosition_2().x > cube[i].getPosition_1().x && this.getPosition_1().x < cube[i].getPosition_1().x)
						|| (this.getPosition_2().x < cube[i].getPosition_1().x && this.getPosition_1().x > cube[i].getPosition_1().x)
						|| (this.getPosition_2().x == cube[i].getPosition_1().x) //&& this.getPosition_1().y == cube[i].getPosition_1().y)
						
						|| (this.getPosition_1().x > cube[i].getPosition_2().x && this.getPosition_2().x < cube[i].getPosition_2().x)
						|| (this.getPosition_1().x < cube[i].getPosition_2().x && this.getPosition_2().x > cube[i].getPosition_2().x)
						|| (this.getPosition_1().x == cube[i].getPosition_2().x) //&& this.getPosition_2().y == cube[i].getPosition_2().y)
						|| (this.getPosition_2().x > cube[i].getPosition_2().x && this.getPosition_1().x < cube[i].getPosition_2().x)
						|| (this.getPosition_2().x < cube[i].getPosition_2().x && this.getPosition_1().y > cube[i].getPosition_2().x)
						|| (this.getPosition_2().x == cube[i].getPosition_2().x) //&& this.getPosition_1().y == cube[i].getPosition_2().y))
							 
						|| (this.getPosition_2().x == cube[i].getPosition_2().x && this.getPosition_1().x == cube[i].getPosition_1().x)
						|| (this.getPosition_2().x > cube[i].getPosition_2().x && this.getPosition_1().x < cube[i].getPosition_1().x) // a verifier
						|| (this.getPosition_1().x > cube[i].getPosition_1().x && this.getPosition_2().x < cube[i].getPosition_2().x))
						 
					 	&& 
					 
						
					 	(this.getPosition_2().y < cube[i].getPosition_1().y)
						 
					 
						&&
						
							 
						((this.getPosition_1().z > cube[i].getPosition_1().z && this.getPosition_2().z < cube[i].getPosition_1().z)
					 	|| (this.getPosition_1().z < cube[i].getPosition_1().z && this.getPosition_2().z > cube[i].getPosition_1().z)
						|| (this.getPosition_1().z == cube[i].getPosition_1().z) //&& this.getPosition_2().z == cube[i].getPosition_1().z)
						//|| (this.getPosition_1().z > cube[i].getPosition_1().z && this.getPosition_2().z > cube[i].getPosition_1().z)
						|| (this.getPosition_2().z > cube[i].getPosition_1().z && this.getPosition_1().z < cube[i].getPosition_1().z)
						|| (this.getPosition_2().z < cube[i].getPosition_1().z && this.getPosition_1().z > cube[i].getPosition_1().z)
						|| (this.getPosition_2().z == cube[i].getPosition_1().z) //&& this.getPosition_1().z == cube[i].getPosition_1().z)
						
						
						|| (this.getPosition_1().z > cube[i].getPosition_2().z && this.getPosition_2().z < cube[i].getPosition_2().z)
						|| (this.getPosition_1().z < cube[i].getPosition_2().z && this.getPosition_2().z > cube[i].getPosition_2().z)
						|| (this.getPosition_1().z == cube[i].getPosition_2().z) //&& cube1.getPosition_2().z == cube[i].getPosition_2().z)
						|| (this.getPosition_2().z > cube[i].getPosition_2().z && this.getPosition_1().z < cube[i].getPosition_2().z)
						|| (this.getPosition_2().z < cube[i].getPosition_2().z && this.getPosition_1().z > cube[i].getPosition_2().z)
						|| (this.getPosition_2().z == cube[i].getPosition_2().z)
							 	
						|| (this.getPosition_2().z == cube[i].getPosition_2().x && this.getPosition_1().z == cube[i].getPosition_1().z)
						|| (this.getPosition_2().z > cube[i].getPosition_2().z && this.getPosition_1().z < cube[i].getPosition_1().z) // a verifier
						|| (this.getPosition_1().z > cube[i].getPosition_1().z && this.getPosition_2().z < cube[i].getPosition_2().z))) {
				
				return i;
			}
		}
		//System.out.println("JE PASSE");
		return -1;
	}

	public PVector getPosition_1() {
		return Position_1;
	}

	public void setPosition_1(float x, float y, float z) {
		Position_1.x+=x;
		Position_1.y+=y;
		Position_1.z+=z;
	}

	public PVector getPosition_2() {
		return Position_2;
	}

	public void setPosition_2(float x, float y, float z) {
		Position_2.x+=x;
		Position_2.y+=y;
		Position_2.z+=z;
	}

	public PVector getPosition() {
		return position;
	}

	public void setPosition(float x, float y, float z) {
		this.position.x+=x;
		this.position.y+=y;
		this.position.z+=z;
	}
	
	
	public String printObject() {
		return("Position_1 = "+ this.getPosition_1()+ "\n Position_2 = "+this.getPosition_2());
	}
	
//	public void setVelocity(float x, float y, float z) {
//		this.velocity.x=x;
//		this.velocity.y=y;
//		this.velocity.z=z;
//	}
//	
//	public PVector getVelocity() {
//		return this.velocity;
//	}
	
	
}
