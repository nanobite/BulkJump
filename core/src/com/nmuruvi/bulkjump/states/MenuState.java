package com.nmuruvi.bulkjump.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nmuruvi.bulkjump.BulkJump;
import com.nmuruvi.bulkjump.Items.Button;

public class MenuState extends State {
    private Texture background;
    //private Texture playBtn;
    private Button playBtn;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("bg.png");
        playBtn = new Button("playbtn.png");
        cam.setToOrtho(false, BulkJump.WIDTH, BulkJump.HEIGHT);
    }
    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){
            gsm.set(new PlayState(gsm));
            dispose();
        }
    }

    @Override
    public void update(float deltaTime) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background, 0, 0, BulkJump.WIDTH, BulkJump.HEIGHT);
        sb.draw(playBtn.getImage(), (BulkJump.WIDTH / 2) - (playBtn.getImage().getWidth() / 2), (BulkJump.HEIGHT / 2) - (playBtn.getImage().getHeight() / 2));
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
    }
}
