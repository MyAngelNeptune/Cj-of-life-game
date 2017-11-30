package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.death.DeathGame;

public class Credits implements Screen {
    private DeathGame game;
    private SpriteBatch batch;
    private Texture img, returnTexture;
    private TextureRegion returnRegion;
    private TextureRegionDrawable returnDrawable;
    private Sprite sprite, returnSkin;
    private OrthographicCamera camera;
    private Viewport viewport;
    private Stage stage;
    private Table table;
    private ImageButton returnButton;

    public Credits(DeathGame game){
        this.game = game;
        camera = new OrthographicCamera();
        viewport = new StretchViewport(1920,1080,camera);
        viewport.apply();

        camera.position.set(camera.viewportWidth/2, camera.viewportWidth/2,0);
        stage = new Stage(viewport);

    }

    @Override
    public void show() {
        table = new Table();
        table.top();
        table.setPosition(450,200);
		batch = new SpriteBatch();
		img = new Texture("Screens/creditpage.png");
		returnTexture = new Texture("Buttons/return.png");
		returnRegion = new TextureRegion(returnTexture);
		returnDrawable = new TextureRegionDrawable(returnRegion);
		returnButton = new ImageButton(returnDrawable);
		table.add(returnButton);
		sprite = new Sprite(img);
  		sprite.setPosition(0,0);
		sprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		stage.addActor(table);
        Gdx.input.setInputProcessor(stage);

		returnButton.addListener(new ChangeListener(){
		    @Override
            public void changed(ChangeEvent e, Actor a){
                game.setScreen(new Title(game));
            }
        });

    }

    @Override
    public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		sprite.draw(batch);
		batch.end();
		stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
