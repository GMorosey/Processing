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
	background(255, 255, 255);
	}
	public void draw() {
		
		formerX = mouseX;
		formerY = mouseY;
		
	
		/*if (changeyboi == 5) {
			background(mouseX, mouseY, 155);
			changeyboi = 0;
		}
		changeyboi++;*/
		
	}
	public void settings() {
	size(640,480);	
	}
	public void mouseDragged()
	{
		line(formerX, formerY, mouseX, mouseY);
		
	}
}

