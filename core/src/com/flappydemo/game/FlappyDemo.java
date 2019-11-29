package com.flappydemo.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.flappydemo.game.states.GameStateManager;
import com.flappydemo.game.states.MenuState;

public class FlappyDemo extends ApplicationAdapter {

    public static final int WIDTH = 480;
    public static final int HEIGHT = 800;

    public static final String TITLE = "Flappy Demo";

    private GameStateManager gsm;

    private SpriteBatch batch;
    private BitmapFont font;

    private Music music;

    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        gsm = new GameStateManager();

        music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
        music.setLooping(true);
        music.setVolume(0.1f);
        music.play();

        Gdx.gl.glClearColor(1, 0, 0, 1);
        gsm.push(new MenuState(gsm));
    }

    @Override
    public void render() {

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gsm.update(Gdx.graphics.getDeltaTime());
        gsm.render(batch, font);
    }

    @Override
    public void dispose() {
        batch.dispose();
        music.dispose();
        font.dispose();
    }
}
