package com.nmuruvi.bulkjump.Items;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import java.awt.Rectangle;

/**
 * Created by Nano on 07/12/2015.
 */
public class Button {
    private Vector2 position;
    private Rectangle rect;
    private int rectWidth = 10, rectHeight = 10;
    private Texture texture;

    public Button(String texturePath) {
        this.texture = new Texture(texturePath);
        position = new Vector2();

    }

    public Rectangle getRect() {
        rect = new Rectangle((int)position.x, (int)position.y, rectWidth, rectHeight);
        return rect;
    }

    public Texture getTexture() {
        return texture;
    }

    public Vector2 getPosition() {
        return position;
    }
    public void dispose(){
        texture.dispose();
    }
}
