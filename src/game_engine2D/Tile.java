package game_engine2D;

import processing.core.PApplet;
import processing.core.PConstants;

public class Tile extends Sprite {
	
	int strokeColour;
	int fillColour;
	public BoundingBox bb;
	String name = "tile";
	public Tile(PApplet p) {
		super(p);
		// TODO Auto-generated constructor stub
	}

	public Tile(PApplet p, int x, int y, int w, int h) {
		super(p, x, y);
		this.transform.size.x = w;
		this.transform.size.y = h;
		this.strokeColour = parent.color(255, 255, 255);
		this.fillColour = parent.color(0, 0, 0);
		bb = new BoundingBox();
		bb.fromSize(this.transform.size);
		super.name = name;
		// TODO Auto-generated constructor stub
	}
	public void start() {
		
	}

	@Override
	public void update() {

	}
	
	public void render() {
		super.render();
		parent.pushMatrix(); // reset the translation and rotation
		parent.translate(this.transform.position.x, this.transform.position.y);
		parent.stroke(this.strokeColour);
		parent.fill(this.fillColour);
		parent.rectMode(PConstants.CENTER);
		parent.rect(0, 0, this.transform.size.x, this.transform.size.y);
		parent.fill(0,255,0);
		parent.rectMode(PConstants.CORNERS);
		parent.rect(this.transform.position.x + this.transform.boundingBox.left,this.transform.position.y + this.transform.boundingBox.top,this.transform.position.x +this.transform.boundingBox.right,this.transform.position.y + this.transform.boundingBox.bottom);
		//parent.ellipse(this.transform.position.x,this.transform.position.y,3,3);
		parent.popMatrix();
}


}
