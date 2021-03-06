package asteroids.n.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import asteroids.n.MainClass;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = 720;
        config.width = 720;
		config.resizable = false;
		config.title = "AsteroidsN";
		new LwjglApplication(new MainClass(), config);
	}
}
