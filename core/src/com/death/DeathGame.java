package com.death;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import screens.Title;


public class DeathGame extends Game {
	private DeathGame game;
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private Texture img;
	private Sprite sprite;
	private Animation animation;
	private BitmapFont dieText;
	private Viewport viewport;
	private static final float SCALE_X = (float) 0.5;
	private static final float SCALE_Y = (float) 0.5;
	private float elapsedTime = 0;
	private boolean isDead = false;

	public DeathGame(){
		game = this;
	}
	@Override
	public void create () {
		setScreen(new Title(game));

//		batch = new SpriteBatch();
//		img = new Texture("kaiyu.png");
//		sprite = new Sprite(img);
//		dieText = new BitmapFont();
//		dieText.setColor(Color.RED);
//		dieText.getData().setScale(4, 4);

		camera = new OrthographicCamera();
		viewport = new StretchViewport(1920,1080,camera);
		viewport.apply();

		camera.position.set(camera.viewportWidth/2, camera.viewportWidth/2,0);
//		sprite.setPosition(0,0);
//		sprite.setSize(600,600);

	}

	@Override
	public void render () {
		super.render();
		camera.update();
//		Gdx.gl.glClearColor(1, 1, 1, 1);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		elapsedTime += Gdx.graphics.getDeltaTime();
//		batch.setProjectionMatrix(camera.combined);
//		batch.begin();
//		sprite.draw(batch);
//		dieText.draw(batch, "CLICK TO DIE", 1000, 700);
//		if(Gdx.input.isButtonPressed((Input.Buttons.LEFT))){
//			sprite.setColor(0,0,0,0);
//			img = new Texture("kaiyu_dead.png");
//			sprite = new Sprite(img);
//			sprite.setPosition(0,0);
//			sprite.setSize(600,600);
//			sprite.draw(batch);
//		}
//		batch.end();
	}
	
	@Override
	public void dispose () {
		super.dispose();
//		batch.dispose();
//		dieText.dispose();
	}

	@Override
	public void resize(int width, int height){
		super.resize(width, height);
		viewport.update(width,height);
		camera.position.set(camera.viewportWidth/2, camera.viewportHeight/2, 0);

	}

}
