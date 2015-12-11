package com.nmuruvi.bulkjump.Essentials;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class Mouse {
    private Vector2 position;

    public Mouse() {
        position = new Vector2(0, 0);
    }

    public void setPosition(int x, int y) {
        position.x = x;
        position.y = y;
    }


    public Vector2 getPosition() {
        position.x = Gdx.input.getX();
        position.y = Gdx.input.getY();
        return position;
    }

    public void dispose() {
        this.dispose();
    }
}
