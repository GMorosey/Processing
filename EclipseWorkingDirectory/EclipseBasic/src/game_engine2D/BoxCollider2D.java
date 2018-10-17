package game_engine2D;

import processing.core.PApplet;
import processing.core.PVector;

public class BoxCollider2D extends ProcessingEntity {
	
	private BoundingBox bb;
	private Transform transform;
	public BoxCollider2D(GameObject g) {
		super(g.parent);
		this.transform = g.transform;
		// TODO Auto-generated constructor stub
	}
	public boolean colCheck(BoundingBox other, BoundingBox _bb) {
		this.bb = _bb;
		if(other.left <this.bb.right && other.right > this.bb.left) {
			if(other.top < this.bb.bottom) {
				return true;
			}		
	 }
		return false;
	}
} 

