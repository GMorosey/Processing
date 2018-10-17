package game_engine2D;

import processing.core.PApplet;

public abstract class GameComponent extends ProcessingEntity {

	public GameObject gameObject;
	public Transform transform;
	public abstract void start();
	public abstract void render();
	public abstract void update();
	
	public GameComponent(GameObject g) {
		super(g.parent);
		this.gameObject = g;
	}

}
