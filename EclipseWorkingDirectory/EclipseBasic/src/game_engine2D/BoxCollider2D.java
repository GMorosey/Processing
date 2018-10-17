package game_engine2D;

import processing.core.PApplet;

public class BoxCollider2D extends ProcessingEntity {

	public BoundingBox boundingBox;
	public Transform transform;
	
	public BoxCollider2D(GameObject g) {
		super(g.parent);
		// TODO Auto-generated constructor stub
	}
	
	public boolean collisionCheck(BoundingBox other_bb) {
		this.boundingBox = this.transform.WorldBoundingBox();
		if(other_bb.left < this.boundingBox.right && other_bb.right > this.boundingBox.left) {
			if(other_bb.top > this.boundingBox.bottom) {
				this.transform.position.y = other_bb.top - this.transform.boundingBox.bottom;
				return true;
			}
			
		}
		return false;
		
	}
}
