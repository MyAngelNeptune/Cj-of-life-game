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
import Character.PlayableCharacter;

public class CharacterSelection implements Screen{
    private DeathGame game;
    private SpriteBatch bat;
    private Sprite sprite;
    private Texture characterScreen;
    private ImageButton kennyB, kaiyuB, edmondB, jonathanB, edwardB, kyleB, calvinB, alexB, darrenB, junyuB;
    private OrthographicCamera camera;
    private Viewport viewport;
    private Stage stage;
    private PlayableCharacter player;
    private Table characterTable;
    private Level level;

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
        bat = new SpriteBatch();
        characterTable = new Table();
        characterTable.top();
        characterTable.setTransform(true);
        characterTable.setPosition(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight() / 1.3f);
        characterScreen = new Texture("Screens/characterselection.png");
        sprite = new Sprite(characterScreen);
        sprite.setPosition(0,0);
        sprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        alexB = makeButton("CharacterIcons/AlexAvatar.jpg");
        calvinB = makeButton("CharacterIcons/CalvinAvatar.jpg");
        darrenB = makeButton("CharacterIcons/DarrenAvatar.jpg");
        edmondB = makeButton("CharacterIcons/EdmondAvatar.jpg");
        edwardB = makeButton("CharacterIcons/EdwardAvatar.jpg");
        jonathanB = makeButton("CharacterIcons/JonathanAvatar.jpg");
        junyuB = makeButton("CharacterIcons/JunyuAvatar.jpg");
        kaiyuB = makeButton("CharacterIcons/KaiyuAvatar.jpg");
        kennyB = makeButton("CharacterIcons/KennyAvatar.jpg");
        kyleB = makeButton("CharacterIcons/KyleAvatar.jpg");

        characterTable.add(alexB);
        characterTable.add(calvinB);
        characterTable.add(darrenB);
        characterTable.add(edmondB);
        characterTable.add(edwardB);
        characterTable.row();
        characterTable.add(jonathanB);
        characterTable.add(junyuB);
        characterTable.add(kaiyuB);
        characterTable.add(kennyB);
        characterTable.add(kyleB);
        characterTable.setScale(2,2);

        stage.addActor(characterTable);
        Gdx.input.setInputProcessor(stage);

        kaiyuB.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
              player = new PlayableCharacter("Characters/kaiyu/kaiyu.png", 10, 10, 100, 50);
              level = new LevelOne(game, "Levels/LevelOne/cave.png", player);
              game.setScreen(level);
            }
        });
        edmondB.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                player = new PlayableCharacter("Characters/Edmond/Edmond.png", 10, 10, 100, 50);
                level = new LevelOne(game, "Levels/LevelOne/cave.png", player);
                game.setScreen(level);
            }
        });
        alexB.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                player = new PlayableCharacter("Characters/Alex/Alex.png", 10, 10, 100, 50);
                level = new LevelOne(game, "Levels/LevelOne/cave.png", player);
                game.setScreen(level);
            }
        });
        calvinB.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                player = new PlayableCharacter("Characters/Calvin/Calvin.png", 10, 10, 100, 50);
                level = new LevelOne(game, "Levels/LevelOne/cave.png", player);
                game.setScreen(level);
            }
        });
        darrenB.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                player = new PlayableCharacter("Characters/Darren/Darren.png", 10, 10, 100, 50);
                level = new LevelOne(game, "Levels/LevelOne/cave.png", player);
                game.setScreen(level);
            }
        });
        jonathanB.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                player = new PlayableCharacter("Characters/Jonathan/Jonathan.png", 10, 10, 100, 50);
                level = new LevelOne(game, "Levels/LevelOne/cave.png", player);
                game.setScreen(level);
            }
        });
        edwardB.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                player = new PlayableCharacter("Characters/Edward/Edward.png", 10, 10, 100, 50);
                level = new LevelOne(game, "Levels/LevelOne/cave.png", player);
                game.setScreen(level);
            }
        });
        junyuB.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                player = new PlayableCharacter("Characters/Junyu/Junyu.png", 10, 10, 100, 50);
                level = new LevelOne(game, "Levels/LevelOne/cave.png", player);
                game.setScreen(level);
            }
        });
        kennyB.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                player = new PlayableCharacter("Characters/Kenny/Kenny.png", 10, 10, 100, 50);
                level = new LevelOne(game, "Levels/LevelOne/cave.png", player);
                game.setScreen(level);
            }
        });
        kyleB.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                player = new PlayableCharacter("Characters/Kyle/Kyle.png", 10, 10, 100, 50);
                level = new LevelOne(game, "Levels/LevelOne/cave.png", player);
                game.setScreen(level);
            }
        });
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        bat.begin();
        sprite.draw(bat);
        bat.end();

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
    public ImageButton makeButton(String s){
      Texture img = new Texture(s);
      TextureRegion imgRegion= new TextureRegion(img);
      TextureRegionDrawable imgRegionDrawable = new TextureRegionDrawable(imgRegion);
      ImageButton imageButton = new ImageButton(imgRegionDrawable);
      return imageButton;
    }

}
