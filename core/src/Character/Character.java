package Character;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Character extends Actor {
    private int HP;
    private int exp;
    private Texture character;
    private Texture healthy;
    private Texture damaged;
    private Texture dead;
    public Character(){
        super();
        character = healthy;
        HP = 100;
    }

    public void setTexture(Texture t){
        this.character = t;
    }
    public Texture getTexture(){
        return this.character;
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
