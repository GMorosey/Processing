package game_engine2D;

import processing.core.PVector;

public class Physics2D extends GameComponent {

	public PVector velocity;
	public float gravity = 0.095f;
	public BoxCollider2D collider;
	
	public Physics2D(GameObject g) {
		super(g);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void start() {
		velocity = new PVector();
		this.collider = new BoxCollider2D(this.gameObject);

	}

	@Override
	public void render() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		velocity.y += gravity;
		this.transform.position.add(velocity);

	}
	
	public void checkCollison(BoundingBox _bb) {
		this.collider.collisionCheck(_bb);
		velocity = new PVector();
	}

}
