package Character;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.death.DeathGame;


import java.awt.*;

public class PlayableCharacter extends Actor {

    public World world;
    public Body b2body;

    private String playerTexture;
    private int HP;
    private int exp;
    private int strength;
    private int level;
    private TextureRegion region;
    private Rectangle boundary;
    private float velocityX;
    private float velocityY;
    private Texture character, healthy, damaged, dead;
    private Sprite characterSprite, healthySprite, damagedSprite, deadSprite;
    private Vector2 velocity = new Vector2();
    private float speed = 60 * 2, gravity = 60 * 1.8f;
    private boolean canJump;

    public PlayableCharacter(String texture, float velocityX, float velocityY, int HP, int strength, World world ){
        this.playerTexture = texture;
        this.velocityX = velocityX;
        this.velocityY = velocityY;

        this.world = world;
        defineCharacter();
        region = new TextureRegion();
        boundary = new Rectangle();
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        healthy = new Texture(texture);
        character = healthy;
        characterSprite = new Sprite(character);
        this.HP = HP;
        this.strength = strength;
    }

    public void defineCharacter(){
        BodyDef bdef = new BodyDef();
        bdef.position.set(3, 3);
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(1);

        fdef.shape = shape;
        b2body.createFixture(fdef);

    }

    public void update(float delta){

    }

    public void setTexture(Texture t){
        this.character = t;
        int width = t.getWidth();
        int height = t.getHeight();
        setWidth(width);
        setHeight(height);
        region.setRegion(t);
    }

    public Texture getTexture(){
        return this.character;
    }

    public Sprite getSprite(){
        return this.characterSprite;
    }

    public Rectangle getBoundingRectangle(){
        boundary.set(getX(), getY(), getWidth(), getHeight());
        return boundary;
    }

//    @Override
//    public boolean keyDown(int keycode) {
//        switch(keycode) {
//            case Keys.W:
//                if(canJump) {
//                    velocity.y = speed;
//                    canJump = false;
//                }
//                break;
//            case Keys.A:
//                velocity.x = -speed;
//                break;
//            case Keys.D:
//                velocity.x = speed;
//        }
//        return true;
//    }
//
//    @Override
//    public boolean keyUp(int keycode) {
//        switch(keycode) {
//            case Keys.A:
//            case Keys.D:
//                velocity.x = 0;
//        }
//        return true;
//    }

    public void draw(Batch b, float x, float y){
        update(Gdx.graphics.getDeltaTime());
        if(HP > 50){
            b.draw(healthy, x, y);
        }
        if(HP <= 50){
            b.draw(damaged, x, y);
        }
        else{
            b.draw(dead, x, y);
        }
    }
    public void setSize(float xRatio, float yRatio){

    }

    public String getStringTexture(){
        return playerTexture;
    }

    public void act(float dt){
        super.act(dt);
        moveBy(velocityX * dt, velocityY * dt);
    }

    public int getLevel(){
        return level;
    }

    public int levelUp(int level){
        return level++;
    }

    public int getHP(){
        return HP;
    }
    public int getEXP(){
        return exp;
    }
    public int damage(int damage){
        return HP -= damage;
    }
    public int heal(int heal){
        return HP += heal;
    }
    public boolean isAlive(){
        return (HP > 0);
    }
    public float getVelocityX(){
        return this.velocityX;
    }
    public float getVelocityY(){
        return this.velocityY;
    }
}
