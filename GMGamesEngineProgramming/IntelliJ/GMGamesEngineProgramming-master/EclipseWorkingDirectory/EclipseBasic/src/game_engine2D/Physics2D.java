package game_engine2D;

import processing.core.*;
import processing.core.PVector;

public class Physics2D extends GameComponent {

	public PVector velocity =  new PVector(0,0);
	public float gravity = 0.95f;

	
	public Physics2D(GameObject g) {
		
		super(g);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void start() {
		

	}
	@Override
	public void update() {
		//velocity.y += gravity;
		//this.transform.position.y += velocity.y;
		 //System.out.println("Work");

	}

	@Override
	public void render() {
		// TODO Auto-generated method stub

	}

	
	
	

}
