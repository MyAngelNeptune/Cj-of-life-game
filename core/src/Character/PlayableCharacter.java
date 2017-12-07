package Character;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.math.Rectangle;

import java.awt.*;

public class PlayableCharacter extends Actor {
    private int HP;
    private int exp;
    private int attack;
    private TextureRegion region;
    private Rectangle boundary;
    private float velocityX;
    private float velocityY;
    private Texture character;
    private Texture healthy;
    private Texture damaged;
    private Texture dead;
    public PlayableCharacter(String texture, int velocityX, int velocityY, int HP, int attack ){
        super();
        region = new TextureRegion();
        boundary = new Rectangle();
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        healthy = new Texture(texture);
        character = healthy;
        this.HP = HP;
        this.attack = attack;
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
    public Rectangle getBoundingRectangle(){
        boundary.set(getX(), getY(), getWidth(), getHeight());
        return boundary;
    }
    public void draw(Batch b, float x, float y){
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
    public void act(float dt){
        super.act(dt);
        moveBy(velocityX * dt, velocityY * dt);
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
}
