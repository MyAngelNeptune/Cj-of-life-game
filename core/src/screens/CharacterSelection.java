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

public class CharacterSelection implements Screen{
    private DeathGame game;
    private SpriteBatch batch;
    private Sprite sprite;
    private Texture characterScreen, kenny, kaiyu, edmond, jonathan, edward, kyle, calvin, alex;
    private TextureRegion kennyR, kaiyuR, edmondR, jonathanR, edwardR, kyleR, calvinR, alexR;
    private TextureRegionDrawable kennyD, kaiyuD, edmondD, jonathanD, edwardD, kyleD, calvinD, alexD;
    private ImageButton kennyB, kaiyuB, edmondB, jonathanB, edwardB, kyleB, calvinB, alexB;
    private OrthographicCamera camera;
    private Viewport viewport;
    private Stage stage;
    private Table table;

    public CharacterSelection(DeathGame game){
        this.game = game;
        camera = new OrthographicCamera();
        viewport = new StretchViewport(1920,1080,camera);
        viewport.apply();

        camera.position.set(camera.viewportWidth/2, camera.viewportWidth/2,0);
        stage = new Stage(viewport);
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        characterScreen = new Texture("Screens/characterselection.png");
        sprite = new Sprite(characterScreen);
        sprite.setPosition(0,0);
        sprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
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
