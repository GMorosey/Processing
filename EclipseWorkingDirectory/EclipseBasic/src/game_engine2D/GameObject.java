package game_engine2D;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PVector;

public abstract class GameObject extends ProcessingEntity {
	public ArrayList<GameComponent> components;
	public BoxCollider2D boxCol;
	public BoundingBox bb;
	public boolean collided;
	public GameObject(PApplet p) {
		super(p);
		this.components = new ArrayList<GameComponent>();
	}

	public String name;
	public String tag;
	public Transform transform = new Transform();
	public abstract void start();
	public abstract void update();
	public abstract void render();
	public String ToString() {
		return this.name;
	}
	public boolean colCheck(GameObject g, ArrayList<BoundingBox> bbs) {
		BoundingBox bbB = g.transform.boundingBox;
		for(BoundingBox bbA : bbs) {
			if(bbB.left < bbA.right && bbB.right > bbA.left) {
			if(bbA.top > bbB.bottom) {
				this.transform.position.y = bbB.top - this.transform.boundingBox.bottom;
				return true;
			}
}
		}
		return false;
	}
}
