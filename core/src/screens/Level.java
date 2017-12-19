package screens;

import a.d.D;
import a.d.G;
import com.badlogic.gdx.Input;
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
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.death.DeathGame;
import Character.PlayableCharacter;
import Weapon.Weapon;


public class Level implements Screen {
    private static final int XMOVEMENT = 250;
    private Stage mainStage;
    private Stage UIStage;
    private DeathGame game;
    private OrthographicCamera camera;
    private Viewport viewport;
    private Texture background;
    private Batch batch;
    private Weapon weapon;
    private Sprite screen, playerSprite, weaponSprite;
    private PlayableCharacter player;
    private World world;
    private Box2DDebugRenderer b2dr;

    private TmxMapLoader mapLoader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;

    public Level(DeathGame game, String bg, PlayableCharacter player, Weapon weapon, String mapFile){
        this.game = game;
        this.weapon = weapon;
        this.background = new Texture(bg);
        camera = new OrthographicCamera();
        viewport = new FitViewport(1920, 1080, camera);

        BodyDef bdef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fdef = new FixtureDef();
        b2dr = new Box2DDebugRenderer();

        mapLoader = new TmxMapLoader();
        map = mapLoader.load(mapFile);
        renderer = new OrthogonalTiledMapRenderer(map);

        this.world = new World(new Vector2(0,-60), true);

        this.player = new PlayableCharacter(player.getStringTexture(),player.getVelocityX(), player.getVelocityY(),5,5,this.world);

        Body body;

        //Creates platforms fixtures
        for(MapObject object : map.getLayers().get(2).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject) object ).getRectangle();

            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set((rect.getX() + rect.getWidth() / 2) , (rect.getY() + rect.getHeight() / 2) );

            body = world.createBody(bdef);
            shape.setAsBox((rect.getWidth() / 2)/ DeathGame.PPM, (rect.getHeight() / 2)/ DeathGame.PPM);
            fdef.shape = shape;
            body.createFixture(fdef);
        }


    }

    @Override
    public void show() {
        batch = new SpriteBatch();
//        screen = new Sprite(getBG());
//        playerSprite = new Sprite(player.getSprite());
//        weaponSprite = new Sprite(weapon.getWeaponSprite());
//        screen.setPosition(0,0);
//        playerSprite.setPosition(Gdx.graphics.getWidth() / 100,0);
//        weaponSprite.setPosition((playerSprite.getX() + 170), playerSprite.getY() + 100);
//        playerSprite.setSize(Gdx.graphics.getWidth() / 6.5f, Gdx.graphics.getHeight() / 3.5f);
//        weaponSprite.setSize(playerSprite.getWidth()/2f, playerSprite.getHeight() / 2f);
//        screen.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.input.setInputProcessor(mainStage);
    }

    @Override
    public void render(float delta) {
        update(delta);
        camera.update();
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.render();

//        //Renders box2D
        b2dr.render(world, camera.combined);

//        batch.begin();
//        playerSprite.draw(batch);
//        weaponSprite.draw(batch);
//        batch.end();

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

    public void handleInput(float dt){
        if(Gdx.input.isKeyPressed(Keys.LEFT)){
            player.b2body.applyLinearImpulse(new Vector2(-player.getVelocityX(), 0), player.b2body.getWorldCenter(), true);
        }
        if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
            player.b2body.applyLinearImpulse(new Vector2(player.getVelocityX(), 0), player.b2body.getWorldCenter(), true);
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){
            player.b2body.applyLinearImpulse(new Vector2(0, player.getVelocityY()), player.b2body.getWorldCenter(), true);
        }


    }

    public World getWorld(){
        return this.world;
    }

    public void update(float dt){
        handleInput(dt);

        world.step(1/60f, 6, 2);

        camera.position.x = player.b2body.getPosition().x;
        camera.update();
        renderer.setView(camera);

    }
}
