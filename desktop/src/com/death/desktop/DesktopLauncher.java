package com.death.desktop;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.death.DeathGame;

public class DesktopLauncher {

	private final static int WIDTH = 1920;
	private final static int HEIGHT = 1080;
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "DEATH GAME";
		config.width = WIDTH;
		config.height = HEIGHT;
		new LwjglApplication(new DeathGame(), config);

	}
}
