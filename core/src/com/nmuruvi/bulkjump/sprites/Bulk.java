package com.nmuruvi.bulkjump.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.nmuruvi.bulkjump.BulkJump;

/**
 * Created by Nano on 06/12/2015.
 */
public class Bulk {
    private Vector3 position;
    private Vector3 velocity;
    private Texture bulkTexture;
    private static final int GRAVITY = -15;
    private int MIN_JUMPHEIGHT = 250, MAX_JUUMPHEIGHT = 610;//min of around 250
    private int HEIGHT, WIDTH;
    private boolean doubleJumped;
    public enum JUMPSTATE {
        IN_AIR, ON_GROUND
    }
    private JUMPSTATE jumpstate;
    public Bulk(int x, int y) {
        jumpstate = JUMPSTATE.ON_GROUND;
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, 0, 0);
        bulkTexture = new Texture("bulk.png");
        WIDTH = bulkTexture.getWidth();
        HEIGHT = bulkTexture.getHeight();
    }

    public void update(float deltaTime) {
        //Above frame of view
        if (position.y + bulkTexture.getHeight() > BulkJump.HEIGHT / 2) {

            position.y = ((BulkJump.HEIGHT / 2) - bulkTexture.getHeight());
            velocity.y = 0;
        }
        //Adds velocity for acceleration
        if (position.y > 0) {
            jumpstate = JUMPSTATE.IN_AIR;
            velocity.add(0, GRAVITY, 0);
        }
        velocity.scl(deltaTime);
        position.add(0, velocity.y, 0);
        velocity.scl(1 / deltaTime);
        //Makes sure they don't go below the ground.
        if (position.y < 0) {
            jumpstate = JUMPSTATE.ON_GROUND;
            position.y = 0;
        }
    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getTexture() {
        return bulkTexture;
    }

    public void jump() {
        velocity.y = MIN_JUMPHEIGHT;
    }

    public void jump(double multiplier) {
        if(jumpstate==JUMPSTATE.ON_GROUND){
            doubleJumped = false;
        }
        if(!doubleJumped) {
            doubleJumped = jumpstate == JUMPSTATE.IN_AIR;
            int jumpHeight = (int) (1 + multiplier) * MIN_JUMPHEIGHT;
            if (jumpHeight > MAX_JUUMPHEIGHT) {
                jumpHeight = MAX_JUUMPHEIGHT;
            }
            velocity.y = jumpHeight;
            //System.out.println("JUMP: " + (int) (1 + multiplier) * MIN_JUMPHEIGHT);

        }
    }
}
