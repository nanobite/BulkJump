package com.nmuruvi.bulkjump.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by Nano on 06/12/2015.
 */
public abstract class State {

    protected OrthographicCamera cam;
    protected Vector3 mouse;
    protected com.nmuruvi.bulkjump.Essentials.GameStateManager gsm;
    protected State(com.nmuruvi.bulkjump.Essentials.GameStateManager gsm){
        this.gsm = gsm;
        cam = new OrthographicCamera();
        mouse = new Vector3();
    }
    protected abstract void handleInput();
    public abstract void update(float deltaTime);
    public abstract void render(SpriteBatch sb);
    public abstract void dispose();

}
