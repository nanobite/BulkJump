package com.nmuruvi.bulkjump.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.nmuruvi.bulkjump.BulkJump;
import com.nmuruvi.bulkjump.Essentials.Button;
import com.nmuruvi.bulkjump.Essentials.Mouse;

public class MenuState extends State {
    private Texture background;
    //private Texture playBtn;
    private Button playBtn, soundBtn;
    private Mouse mouse;
    private Vector3 mouseTouch;

    public MenuState(com.nmuruvi.bulkjump.Essentials.GameStateManager gsm) {
        super(gsm);
        mouseTouch = new Vector3();
        background = new Texture("bg.png");
        playBtn = new Button("playbtn.png", BulkJump.WIDTH / 2, BulkJump.HEIGHT / 2, true);
        soundBtn = new Button("soundbtn.png", (BulkJump.WIDTH - 20), (BulkJump.HEIGHT - 20));
        mouse = new Mouse();
        cam.setToOrtho(false, BulkJump.WIDTH, BulkJump.HEIGHT);
    }

    /**
     * Handles mouse input from clicks
     */
    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()) {
            cam.unproject(mouseTouch.set(((int) Gdx.input.getX()), ((int) Gdx.input.getY()), 0));
            mouse.setPosition(((int) mouseTouch.x), ((int) mouseTouch.y));
            System.out.println("Mouse: " + mouseTouch.x + " : " + mouseTouch.y);
            System.out.println("Play BTN: " + playBtn.getPosition().x + " : " + playBtn.getPosition().y);
            if (playBtn.getRect().contains(mouse.getPosition().x,mouse.getPosition().y)) {
                System.out.println("Intersects");
                gsm.set(new PlayState(gsm));
                dispose();
            }
        }


    }

    @Override
    public void update(float deltaTime) {
        handleInput();
    }

    /**
     * Renders the
     * @param sb The sprites to be rendered.
     */
    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background, 0, 0);
        sb.draw(playBtn.getTexture(), playBtn.getPosition().x, playBtn.getPosition().y);
        sb.draw(soundBtn.getTexture(), soundBtn.getPosition().x, soundBtn.getPosition().y);
        sb.end();
    }

    /**
     * Disposes of the state when it's not needed.
     */
    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
    }
}
