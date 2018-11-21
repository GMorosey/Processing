package game_engine2D;

import processing.core.PApplet;
import processing.core.PVector;

import java.awt.*;
import java.security.cert.PKIXCertPathValidatorResult;

public class Camera2D extends GameObject{

    public GameObject follow;
    float limit = 100;

    public Camera2D(PApplet p, GameObject g){
        super(p);
        follow = g;
    }
    @Override
    public void start() {

    }

    @Override
    public void render() {

    }

    @Override
    public void update() {
        lateUpdate();
    }

    public void lateUpdate(){
        //GameManager.ScreenCentre.copy();
        //Add offset to centre
        //System.out.println("IM here too");
        PVector centre = GameManager.ScreenCentre.copy();
        centre.add(GameManager.offset);
        PVector vPlayer = GameManager.offset.copy();
        vPlayer.add(this.follow.transform.position);
        float d = centre.dist(vPlayer);
        System.out.println(d);
        if(d > limit) {
            centre.sub(vPlayer);
            centre.add(new PVector(0, 90));
            GameManager.offset.lerp(centre, 0.05f);
        }

    }

}
