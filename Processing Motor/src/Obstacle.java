import processing.core.PVector;
public class Obstacle {
	private Cubes obstacle;
	private PVector velocity = new PVector(0,0,0); 
	public Obstacle(Cubes cube) {
		this.obstacle=cube;
	}
	public Cubes getObstacle() {
		return obstacle;
	}
	public void setObstacle(Cubes obstacle) {
		this.obstacle = obstacle;
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
