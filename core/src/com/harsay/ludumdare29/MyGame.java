package com.harsay.ludumdare29;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.harsay.ludumdare29.assets.Graphic;
import com.harsay.ludumdare29.assets.Sound;
import com.harsay.ludumdare29.other.Controller;
import com.harsay.ludumdare29.screens.BasicScreen;
import com.harsay.ludumdare29.screens.GameScreen;
import com.harsay.ludumdare29.world.Player;
import com.harsay.ludumdare29.world.World;

/*
 * Hello.
 * I made this game for Ludum Dare 29 in 48 hours!
 * ...
 * 
 */

public class MyGame extends Game {
	
	public static final int WIDTH = 960;
	public static final int HEIGHT = 540;
	public static final int UNIT = 32;
	
	public static Controller controller = new Controller();
	public static Sound sound = new Sound();
	public static Graphic graphic = new Graphic();
	
	public Player player;
	
	public World world;

	@Override
	public void create() {
		Gdx.input.setInputProcessor(controller);
		sound.init();
		graphic.init();
		player = new Player(this);
		world = new World(this);
		
		setScreen(new GameScreen(this));
	}
}
