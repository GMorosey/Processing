package game_engine2D;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PVector;

public class BoxCollider2D extends ProcessingEntity {
	
	//Spublic BoundingBox bb;
	private Transform transform;
	public BoxCollider2D(GameObject g) {
		super(g.parent);
		this.transform = g.transform;
		// TODO Auto-generated constructor stub
	}
	
} 

