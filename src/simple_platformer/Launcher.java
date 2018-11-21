package simple_platformer;


import game_engine2D.*;
import processing.core.PApplet;


public class Launcher extends BaseLauncher{

	public Launcher(PApplet p) {
		super(p);
	}

	public void StartGame(){
		super.StartGame();
        Player player = new Player(parent, parent.width/2,parent.height/2,60, 60);
        player.transform.boundingBox.fromSize(player.transform.size);
        player.start();
        this.gameManager.addPlayer(player);
        //this.gameManager.addBoundingBox(player);
        Camera2D camera = new Camera2D(parent,player);
        this.gameManager.addObject(camera);
   
        int platforms = 18;
        for(int i = 0; i < platforms; i++){
            Tile platform = new Tile(parent, 50 + i * 55, parent.height-50,50, 20);
            platform.start();
            platform.transform.boundingBox.fromSize(platform.transform.size);
            this.gameManager.addObject(platform);
            this.gameManager.addBoundingBox(platform);
            //platform.transform.boundingBox.fromSize(platform.transform.size);
        }
    }
	  public void UpdateAll(){
	        super.UpdateAll();
	    }

}
