package com.nmuruvi.bulkjump.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.nmuruvi.bulkjump.sprites.Bulk;
import com.nmuruvi.bulkjump.BulkJump;

import java.util.Timer;
import java.util.TimerTask;

public class PlayState extends State {
    private Bulk bulk;
    private Texture bg;
    private Timer t;
    private boolean click;
    private TimerTask timerTask;
    private Vector2 mousePos;
    public PlayState(GameStateManager gsm) {
        super(gsm);
        bulk = new Bulk(50, 300);
        bg = new Texture("bg.png");
        cam.setToOrtho(false, BulkJump.WIDTH / 2, BulkJump.HEIGHT / 2);
        t = new Timer();
        click = false;
        timerTask = new TimerTask() {
            @Override
            public void run() {
                enableClick();
            }
        };
        t.schedule(timerTask,2000);
        mousePos = new Vector2();
    }

    private void enableClick() {
        click = true;
    }

    @Override
    protected void handleInput() {
        if (click) {
            if (Gdx.input.justTouched()) {

                bulk.jump();
            }
        }

    }

    @Override
    public void update(float deltaTime) {
        handleInput();
        bulk.update(deltaTime);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(bulk.getTexture(), bulk.getPosition().x, bulk.getPosition().y);
        sb.end();
    }

    @Override
    public void dispose() {
    }
}
