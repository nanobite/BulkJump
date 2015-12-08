package com.nmuruvi.bulkjump.Items;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import java.awt.Rectangle;

/**
 * Created by Nano on 07/12/2015.
 */
public class Mouse {
    private Vector2 mousePos;
    private Rectangle rect;
    private int rectWidth =10, rectHeight = 10;
    public Mouse(){
        mousePos = new Vector2();
        rect = new Rectangle();
    }
    public Rectangle getRect(){
        rect.width = rectWidth;
        rect.height = rectHeight;
        rect.x =(int) mousePos.x-(rect.width/2);
        rect.y =(int) mousePos.y-(rect.height/2);
        return rect;
    }
    public Vector2 getMousePos() {
        mousePos.x = Gdx.input.getX();
        mousePos.y = Gdx.input.getY();
        return mousePos;
    }
}
