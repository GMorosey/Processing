package game_engine2D;

import java.util.ArrayList;

import processing.core.PVector;

public class BoundingBox {

	public float left;
	public float right;
	public float top;
	public float bottom;
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
		left = -size.x/2;
		right = size.x/2;
		top = 	size.y/2;
		left = -size.x/2;
		
	}
	

}
