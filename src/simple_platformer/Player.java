/**
 * 
 */
package simple_platformer;

import game_engine2D.*;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PVector;


/**
 * @author Rod Martin r.martin1@salford.ac.uk
 *
 */
public class Player extends Sprite {
	float speed = 3f;
	float gravity = 0.095f;
	public int stroke = parent.color(120,120,255);
	public int fill = parent.color(255);
	public BoundingBox bb;
	String name = "player";
	/**
	 * @param p
	 */
	public Player(PApplet p) {
		super(p);
		// TODO Auto-generated constructor stub
	}
	 public Player(PApplet p, float x, float y, float w, float h) {
	        super(p);
	        super.name = name;
	        speed = 3.0f;
		 this.transform.size = new PVector(12,12);
	        bb = new BoundingBox();
			 bb.fromSize(this.transform.size);
	    }
	 public void start() {

		 this.transform.position.x = parent.width / 2;
		 this.transform.position.y = parent.height / 2;
		 physics = new Physics2D();
		 currentState = objectStates.idle;
		
		 
	 }
	/* (non-Javadoc)
	 * @see game_engine2D.Sprite#update()
	 */
	@Override
	public void update() {
		if(this.physics.velocity.x ==0) currentState = objectStates.idle;
		//System.out.println(currentState);


	}
	@Override
	public void render(){
		parent.fill(this.fill);
		parent.stroke(this.stroke);
		parent.rectMode(PConstants.CENTER);
		//parent.rect(this.transform.position.x, this.transform.position.y, this.transform.size.x, this.transform.size.y);
		parent.fill(0,255,0);
		parent.rectMode(PConstants.CORNERS);

		//System.out.println(this.transform.boundingBox.top + " " +this.transform.boundingBox.bottom);
		parent.rect(this.transform.position.x + this.transform.boundingBox.left,this.transform.position.y + this.transform.boundingBox.bottom,this.transform.position.x +this.transform.boundingBox.right,this.transform.position.y + this.transform.boundingBox.top);

		//parent.ellipse(this.transform.boundingBox.top,this.transform.boundingBox.top,3,3);

	}
	public void keyPressed(char key, int keyCode){
		if(keyCode == PApplet.UP){
			this.physics.jump();
			currentState = objectStates.jumping;
			//System.out.println("UP");
		}
		if(keyCode == PApplet.LEFT){
			//System.out.println("LEFT");
			physics.applyForce(-1);
			if(this.physics.IsGrounded)currentState = objectStates.moving;
		}
		if(keyCode == PApplet.RIGHT){
			//System.out.println("RIGHT");
			physics.applyForce(1);
			if(this.physics.IsGrounded)currentState = objectStates.moving;
		}
	}

	public void keyReleased(char key, int keyCode){
		if((keyCode == PApplet.LEFT || keyCode == PApplet.RIGHT)&& this.physics.IsGrounded) {
			this.physics.keyUp();
		}
		}

}
