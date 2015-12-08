package com.nmuruvi.bulkjump.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.nmuruvi.bulkjump.BulkJump;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = BulkJump.WIDTH;
		config.height = BulkJump.HEIGHT;
		new LwjglApplication(new BulkJump(), config);
	}
}
