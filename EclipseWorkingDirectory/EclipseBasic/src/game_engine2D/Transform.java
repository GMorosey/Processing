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
	public PVector position = new PVector(0,0);
	public PVector rotation = new PVector(0,0);
	public PVector scale = new PVector(0,0);;
	public BoundingBox boundingBox = new BoundingBox(-1,1,-1,1);
	public BoundingBox WorldBoundingBox() {
		BoundingBox bBox = new BoundingBox();
		bBox.left = position.x + boundingBox.left;
		bBox.right = position.x + boundingBox.right;
		bBox.top = position.y + boundingBox.top;
		bBox.bottom = position.y + boundingBox.bottom;
		return bBox;
		
	}
}
