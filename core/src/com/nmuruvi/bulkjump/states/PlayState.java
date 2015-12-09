package com.nmuruvi.bulkjump.states;
/**
 * @author Nano
 * This is the state which is active while playing the game.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.nmuruvi.bulkjump.BulkJump;
import com.nmuruvi.bulkjump.sprites.Bulk;

import java.util.Timer;
import java.util.TimerTask;

public class PlayState extends State {
    private Bulk bulk;
    private Texture bg;
    private Timer t;
    private boolean click;
    private TimerTask timerTask;
    private Vector2 mousePos;
    double pressLength;
    private int startDelay = 500;

    public PlayState(GameStateManager gsm) {

        super(gsm);
        System.out.println((BulkJump.WIDTH / 8));

        bulk = new Bulk(((BulkJump.WIDTH / 8)), BulkJump.HEIGHT);
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
        t.schedule(timerTask, 500);
        mousePos = new Vector2();
    }

    private void enableClick() {
        click = true;
    }

    boolean touch;

    @Override
    protected void handleInput() {
        if (click) {
            if (Gdx.input.isTouched()) {

                touch = true;
                pressLength += 0.1;
            } else {
                if (touch) {
                    bulk.jump(pressLength);
                    touch = false;
                }
                pressLength = 0;
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
