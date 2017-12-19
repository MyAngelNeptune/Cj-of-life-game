package Character;

import com.badlogic.gdx.physics.box2d.World;

public class Kaiyu extends PlayableCharacter{
    public Kaiyu(String texture, int velocityX, int velocityY, int HP, int attack, World world){
        super(texture, velocityX, velocityY, HP, attack, world);
    }
}
