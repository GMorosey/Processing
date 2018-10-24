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
    }

    private ArrayList<GameObject> gameObjects;
    private ArrayList<BoundingBox> boundingBoxes;


    public void addObject(GameObject g){
        gameObjects.add(g);
    }
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
    	
        for(int i = 0; i < gameObjects.size(); i++){
            GameObject g = gameObjects.get(i);
            g.start();
        }
    }
    public void UpdateAll() {

    	parent.background(background);
        for(int i = 0; i < gameObjects.size(); i++){
        	
            GameObject g = gameObjects.get(i);
            g.update();
            g.render();
        }
        
    	for(GameObject go : gameObjects) {
    		 go.collided = go.colCheck(go,boundingBoxes);
    		 System.out.println(go.name + " " + go.collided);
      		
      	}
    }
}

