package dev.nichlasandre.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	public static BufferedImage dirt, grass, stone, endstone, glowstone, brick, bedrock, log, dragon_egg;
	
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.jpg"));
		
	}

}
