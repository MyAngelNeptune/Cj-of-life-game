package screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.death.DeathGame;
import Character.PlayableCharacter;


public class Level implements Screen {
    private Stage mainStage;
    private Stage UIStage;
    private DeathGame game;
    private OrthographicCamera camera;
    private Viewport viewport;
    private Texture background;
    private Batch batch;
    private Sprite screen, playerSprite;
    private PlayableCharacter player;

    public Level(DeathGame game, String bg, PlayableCharacter player){
        this.player = player;
        this.game = game;
        this.background = new Texture(bg);
        camera = new OrthographicCamera();
        viewport = new StretchViewport(1920,1080,camera);
        viewport.apply();
        camera.position.set(camera.viewportWidth/2, camera.viewportWidth/2,0);
        mainStage = new Stage(viewport);
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        screen = new Sprite(getBG());
        playerSprite = new Sprite(player.getTexture());
        screen.setPosition(0,0);
        playerSprite.setPosition(100,300);
        playerSprite.setSize(300, 300);
        screen.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.input.setInputProcessor(mainStage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        screen.draw(batch);
        playerSprite.draw(batch);
        batch.end();

        mainStage.draw();
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

    public Texture getBG(){
        return this.background;
    }
}
