package dev.nichlasandre.tilegame;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.nichlasandre.tilegame.display.Display;
import dev.nichlasandre.tilegame.gfx.Assets;
import dev.nichlasandre.tilegame.states.GameState;
import dev.nichlasandre.tilegame.states.MenuState;
import dev.nichlasandre.tilegame.states.SettingState;
import dev.nichlasandre.tilegame.states.State;

// Run everything, close everything.. contain everything
public class Game implements Runnable{

	private Display display;
	
	public int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	// States
	private State gameState;
	private State menuState;
	private State settingState;
	
	
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
	}
	
	private void init() {
		// Init all graphics for the game
		display = new Display(title, width, height);
		Assets.init();
		
		gameState = new GameState();
		menuState = new MenuState();
		settingState = new SettingState();
		State.setState(gameState);
		
	}
	
	
	private void tick() {
		if(State.getState() != null) {
			State.getState().tick();
		}
	}
	
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		// Clear screen
		g.clearRect(0, 0, width, height);
		
		
		if(State.getState() != null) {
			State.getState().render(g);
		}
		// Draw here:
		
		// End drawing.. Must be done!
		bs.show();
		g.dispose();
		
		
	}
	
	public void run() {
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			if(delta >= 1) {
				tick();
				render();
				ticks++;
				delta--;
			}
			if(timer >= 1000000000) {
				System.out.println("Ticks and frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
		stop();
		
	}
	
	public synchronized void start() {
		if(running) 
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
		
	}
	
	public synchronized void stop() {
		if(!running) 
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}




