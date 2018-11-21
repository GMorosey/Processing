package game_engine2D;
import processing.core.*;
import java.util.ArrayList;
/* Example of basic Launch processing applet*/
public class GameManager {
    public PApplet parent; // The parent PApplet that we will render ourselves onto
    public int background = 0;
    boolean collided;
    public GameManager(PApplet p){
        parent = p;
        gameObjects = new ArrayList<GameObject>();
        boundingBoxes = new ArrayList<BoundingBox>();
        players = new ArrayList<GameObject>();
        ScreenCentre.x = parent.width/2;
        ScreenCentre.y = parent.height/2;


    }

    private ArrayList<GameObject> gameObjects;
    private ArrayList<GameObject> players;
    private ArrayList<BoundingBox> boundingBoxes;

    public static PVector ScreenCentre = new PVector(0,0);
    public static PVector offset = new PVector(0,0);

    public void addObject(GameObject g){
        gameObjects.add(g);
    }
    public void addPlayer(GameObject g){players.add(g);}
    public void removeObject(GameObject g){
        gameObjects.remove(gameObjects.lastIndexOf(g));
    }
    
    public void addBoundingBox(GameObject b) {
    	boundingBoxes.add(b.transform._BoundingBox());
    }
    public void removeBoundingBox(GameObject b) {
    	boundingBoxes.remove(b.transform._BoundingBox());
    }
    public void StartAll() {

        //ScreenCentre =
    	
        for(int i = 0; i < gameObjects.size(); i++){
            GameObject g = gameObjects.get(i);
            g.start();
        }
    }
    public void UpdateAll() {
        System.out.print(offset);
        parent.pushMatrix();
        parent.translate(offset.x,offset.y);

    	parent.background(background);
        for(int i = 0; i < gameObjects.size(); i++){
        	
            GameObject g = gameObjects.get(i);
            g.update();
            g.render();
        }
        for(int i = 0; i < players.size(); i++){

            GameObject g = players.get(i);
            g.update();
            g.render();
        }
        
    	for(GameObject go : players) {
    		 if(go.physics.colCheck(go,boundingBoxes) && go.physics.CollideInfo == "TOP"){
                 go.physics.velocity.y =0;
             }else {
                 go.physics.applyGravity();
             }

             go.physics.updatePos(go);
    		 //System.out.println(go.name + " " + go.collided);
      		
      	}
      	parent.popMatrix();
    }

    public void createTile(float x, float y){
        Tile platform = new Tile(parent, Math.round(x), Math.round(y),50, 20);
        platform.start();
        platform.transform.boundingBox.fromSize(platform.transform.size);
        addObject(platform);
        addBoundingBox(platform);
    }

    public void keyPressed(char key, int keyCode){
        for(int i = 0; i < players.size(); i++){
            GameObject g = players.get(i);
            g.keyPressed(key, keyCode);
        }
    }
    public void mousePressed(float mouseX,float mouseY) {

        createTile(mouseX, mouseY);
    }
    public void keyReleased(char key, int keyCode) {
        for (int i = 0; i < players.size(); i++) {
            GameObject g = players.get(i);
            g.keyReleased(key, keyCode);
        }
    }
}

