package screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.death.DeathGame;


public class Title implements Screen{

    private DeathGame game;
    private SpriteBatch batch;
    private Sprite titleSplash;
    private Sprite playSkin, exitSkin, creditsSkin;
    private Texture playTexture, exitTexture, creditsTexture;
    private TextureRegion playRegion, exitRegion, creditsRegion;
    private TextureRegionDrawable playDrawable, exitDrawable, creditsDrawable;
    private OrthographicCamera camera;
    private Viewport viewport;
    private Stage stage;
    private Table table;
    private ImageButton buttonPlay, buttonExit, buttonCredits;
    private Label heading;


    public Title(DeathGame game) {
        this.game = game;
        camera = new OrthographicCamera();
        viewport = new StretchViewport(1920,1080,camera);
        viewport.apply();

        camera.position.set(camera.viewportWidth/2, camera.viewportWidth/2,0);
        stage = new Stage(viewport);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);

        table = new Table();
        table.top();
        table.setPosition(Gdx.graphics.getWidth() - Gdx.graphics.getWidth() / 5, Gdx.graphics.getHeight() / 1.5f);


        playTexture = new Texture("Buttons/play.png");
        exitTexture = new Texture("Buttons/quit.png");
        creditsTexture = new Texture("Buttons/credits.png");

        playRegion = new TextureRegion(playTexture);
        exitRegion = new TextureRegion(exitTexture);
        creditsRegion = new TextureRegion(creditsTexture);

        playDrawable = new TextureRegionDrawable(playRegion);
        exitDrawable = new TextureRegionDrawable(exitRegion);
        creditsDrawable = new TextureRegionDrawable(creditsRegion);

        buttonPlay = new ImageButton(playDrawable);
        buttonExit = new ImageButton(exitDrawable);
        buttonCredits = new ImageButton(creditsDrawable);

        table.add(buttonPlay);
        table.row();
        table.row();
        table.add(buttonExit);
        table.row();
        table.row();
        table.add(buttonCredits);
        stage.addActor(table);
//        playSkin = new Sprite(playTexture);
//        exitSkin = new Sprite(exitSkin);
//        creditsSkin = new Sprite(creditsSkin);

        batch = new SpriteBatch();
        Texture title = new Texture("Screens/Title.png");
        titleSplash = new Sprite(title);
        Gdx.input.setInputProcessor(stage); //Start taking input from the ui
        titleSplash.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        //Adds listeners for all buttons
        buttonPlay.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new CharacterSelection(game));
            }
        });
        buttonExit.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.exit();
            }
        });
        buttonCredits.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new Credits(game));
            }
        });
    }
    @Override
    public void render(float delta) {
        batch.begin();
        stage.act(Gdx.graphics.getDeltaTime()); //Perform ui logic
        titleSplash.draw(batch);
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
