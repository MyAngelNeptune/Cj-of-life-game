package Weapon;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import Weapon.Weapon;



public class Weapon extends Actor{
    private TextureRegion region;
    private Rectangle boundary;
    private Texture weapon;
    private Sprite weaponSprite;
    private int damage, xPosition, yPosition;

    public Weapon(String texture, int damage){
        super();
        region = new TextureRegion();
        boundary = new Rectangle();
        weapon = new Texture(texture);
        weaponSprite = new Sprite(weapon);
        this.damage = damage;
    }

    public void draw(Batch b, float x, float y){
        b.draw(weaponSprite, x, y);
    }


    public Sprite getWeaponSprite(){
        return this.weaponSprite;
    }

    public Texture getWeapon(){
      return this.weapon;
    }

    private void moveRight(){
        xPosition++;
        weaponSprite.setPosition(xPosition, yPosition);
    }

    private void moveLeft(){
        xPosition--;
        weaponSprite.setPosition(xPosition, yPosition);
    }

    private void moveUp(){
        yPosition++;
        weaponSprite.setPosition(xPosition, yPosition);
    }

    private void moveDownt(){
        yPosition--;
        weaponSprite.setPosition(xPosition, yPosition);
    }


    private void setWeaponSprite(String texture){
        this.weapon = new Texture(texture);
        this.weaponSprite = new Sprite(this.getWeapon());
    }

    public Rectangle getBoundingRectangle(){
        boundary.set(getX(), getY(), getWidth(), getHeight());
        return boundary;
    }
}
