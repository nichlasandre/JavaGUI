package dev.nichlasandre.tilegame;

import dev.nichlasandre.tilegame.display.Display;

public class Launcher {

	public static void main(String[] args) {
		
		Game game = new Game("TileGame!", 512, 512);
		game.start();
		
	}
	
}
