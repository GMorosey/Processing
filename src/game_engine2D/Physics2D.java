package game_engine2D;

import processing.core.*;
import processing.core.PVector;

import java.util.ArrayList;

public class Physics2D {

	public PVector velocity =  new PVector(0,0);
	public float gravity = 0.095f;
	private float speed = 2;
	public float friction = 0.9f;
	public float frictionOverride = 1;
	public float frictionNormal = 0.9f;
	public String CollideInfo = " ";
	public boolean IsGrounded = false;


	public boolean Collided = false;


	public Physics2D() {

	}
	public boolean colCheck(GameObject g, ArrayList<BoundingBox> bbs) {
		BoundingBox gBB = g.transform._BoundingBox();
		for(BoundingBox bbA : bbs) {

			if(gBB.left < bbA.right && gBB.right > bbA.left) {
				if(gBB.top > bbA.bottom  && gBB.bottom < bbA.bottom){
					g.transform.position.y = bbA.bottom - (g.transform.size.y/2 + bbA.objectSize.y/2);
					//System.out.println(g.transform.position.y);
					//System.out.println(bbA.top);
					CollideInfo = "TOP";
					return true;
				}
			}else CollideInfo = "NONE";
		}
		return false;
	}

	public void updatePos(GameObject go) {
		if(CollideInfo == "TOP") IsGrounded = true;
		if(CollideInfo == "NONE")IsGrounded = false;
		if(velocity.x <0.1 && velocity.x > 0) velocity.x =0;
		else if(velocity.x >-0.1 && velocity.x < 0) velocity.x =0;
		if(IsGrounded)velocity.y =0;
		//if(IsGrounded && go.currentState == GameObject.objectStates.moving) friction = frictionOverride;
		if(go.currentState == GameObject.objectStates.jumping) friction = frictionNormal;
		go.transform.position.y += velocity.y;
		if(IsGrounded)velocity.x *= friction;
		go.transform.position.x += velocity.x;
		//System.out.println(velocity);
	}

	public void applyGravity(){
		velocity.y += gravity;
	}

	public void applyForce( float dir){
		friction = frictionOverride;
		velocity.x = dir * speed;
	}

	public void keyUp(){
		System.out.println("KEYRELEASED");
		friction = frictionNormal;
	}

	public void jump(){
		if(IsGrounded){
			//System.out.println("JUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUMP");
			IsGrounded = false;
			velocity.y -= 5;
		}

	}

	
	
	

}
