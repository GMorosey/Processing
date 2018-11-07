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
		BoundingBox gBB = g.transform._BoundingBox();
		for(BoundingBox bbA : bbs) {

			if(gBB.left < bbA.right && gBB.right > bbA.left) {
				if(gBB.top > bbA.bottom  /*gBB.top < bbA.bottom*/){
					g.transform.position.y = bbA.bottom - (g.transform.size.y/2 + bbA.objectSize.y/2);
					System.out.println(g.transform.position.y);
					System.out.println(bbA.top);
					return true;
					}
}
		}
		return false;
	}
}
