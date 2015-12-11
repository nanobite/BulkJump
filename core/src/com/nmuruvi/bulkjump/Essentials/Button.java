package com.nmuruvi.bulkjump.Essentials;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Rectangle;

public class Button {
    private Vector2 position;
    private Rectangle rect;
    private int rectWidth = 10, rectHeight = 10;
    private Texture texture;

    public Button(String texturePath,int x, int y) {
        this.texture = new Texture(texturePath);
        position = new Vector2(x,y);
        rect = new Rectangle(x,y,texture.getWidth(),texture.getHeight());
    }
    public Button(String texturePath,int x, int y,boolean centre) {
        if(centre){
            this.texture = new Texture(texturePath);
            x -= (texture.getWidth()/2);
            y -= (texture.getHeight()/2);
            position = new Vector2(x,y);
            rect = new Rectangle(x,y,texture.getWidth(),texture.getHeight());
        }else{
            this.texture = new Texture(texturePath);
            position = new Vector2(x,y);
            rect = new Rectangle(x,y,texture.getWidth(),texture.getHeight());
        }

    }

    public Rectangle getRect() {
        return rect;
    }

    public Texture getTexture() {
        return texture;
    }

    public Vector2 getPosition() {
        return position;
    }
    public void setPosition(int x, int y){
        position.x = x;
        position.y = y;
        rect.x = x;
        rect.y = y;
    }
    public void dispose(){
        texture.dispose();
    }
}
