package game_engine2D;

import java.util.ArrayList;

import processing.core.PVector;

public class BoundingBox {

	public float left;
	public float right;
	public float top;
	public float bottom;
	public PVector objectSize = new PVector(0,0);
	String name;
	public BoundingBox()
	{
		
	}
	public BoundingBox(int l,int r, int t, int b) {
		left = l;
		right = r;
		top = t;
		bottom = b;
	}
	
	public void fromSize(PVector size) {
		objectSize = size;
		left = -size.x/2f;
		right = size.x/2f;
		top = 	size.y/2f;
		bottom = -size.y/2f;
		
	}
	

}
