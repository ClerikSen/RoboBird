package com.risenphoenix.robobird.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.risenphoenix.bird.ZBGame;


public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Bird";
		config.width = 272;
		config.height = 408;
		new LwjglApplication(new ZBGame(), config);
	}
}
