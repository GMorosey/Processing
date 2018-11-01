/**
 * 
 */
package game_engine2D;

import processing.core.PVector;

/**
 * @author Rod Martin r.martin1@salford.ac.uk
 *
 */
public class Transform {

	public Transform() {
		
	}
	public boolean collided = false;
	public PVector position = new PVector(0,0);
	public PVector rotation = new PVector(0,0);
	public PVector scale = new PVector(0,0);
	public PVector size = new PVector(0,0);
	public PVector velocity = new PVector(0,0);
	public BoundingBox boundingBox = new BoundingBox();
	public BoundingBox _BoundingBox() {
		BoundingBox bb = new BoundingBox();
		bb.left = this.position.x + boundingBox.left;
		bb.right = this.position.x + boundingBox.right;
		bb.top = this.position.y + boundingBox.top;
		bb.bottom = this.position.y + boundingBox.bottom;
		return bb;
		
	}
	

}
