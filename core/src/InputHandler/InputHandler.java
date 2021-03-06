package InputHandler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class InputHandler {

    public static boolean UP_TOUCHED;
    public static boolean DOWN_TOUCHED;
    public static boolean LEFT_TOUCHED;
    public static boolean RIGHT_TOUCHED;

    public void update(){
        // reset all variables
        UP_TOUCHED = false;
        DOWN_TOUCHED = false;
        LEFT_TOUCHED = false;
        RIGHT_TOUCHED = false;

        // set boolean to true if key is touched
        if (Gdx.input.isKeyPressed(Keys.LEFT)) {
            LEFT_TOUCHED = true;
        }
        if (Gdx.input.isKeyPressed(Keys.DOWN)) {
            DOWN_TOUCHED = true;
        }
        if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
            RIGHT_TOUCHED = true;
        }
        if (Gdx.input.isKeyPressed(Keys.UP)) {
            UP_TOUCHED = true;
        }
    }
}
