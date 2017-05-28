package dev.nichlasandre.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int WIDTH = 16, HEIGHT = 16;
	public static BufferedImage dirt, grass, stone, endstone, glowstone, brick, bedrock, log, dragon_egg;
	
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.jpg"));
		
		dirt = sheet.crop(0, 0, WIDTH, HEIGHT);
		grass = sheet.crop(WIDTH, 0, WIDTH, HEIGHT);
		stone = sheet.crop(WIDTH*2, 0, WIDTH, HEIGHT);
		endstone = sheet.crop(WIDTH*3, 0, WIDTH, HEIGHT);
		glowstone = sheet.crop(WIDTH*4, 0, WIDTH*4, HEIGHT*4);
		brick = sheet.crop(0, HEIGHT, WIDTH*2, HEIGHT*2);
		bedrock = sheet.crop(WIDTH*2, HEIGHT, WIDTH*2, HEIGHT*2);
		log = sheet.crop(0, HEIGHT*4, WIDTH, HEIGHT);
		dragon_egg = sheet.crop(WIDTH*4, HEIGHT*4, WIDTH*4, HEIGHT*4);
		
	}
	
	
}
