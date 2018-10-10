import processing.core.PApplet;
public class Main extends PApplet {

	int formerX =0;
	int formerY= 0;
	int changeyboi = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("Main");
	}
	public void setup() {
	background(0, 0, 0);
	}
	public void draw() {
		
		formerX = mouseX;
		formerY = mouseY;
	}
	public void settings() {
	size(640,480);	
	}
	public void mouseDragged()
	{
		line(formerX, formerY, mouseX, mouseY);
		//ellipse(formerX, formerY, mouseX, mouseY);
		stroke(mouseX, mouseY, 155);
		strokeWeight(4);
		
	}
}

