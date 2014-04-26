package com.harsay.ludumdare29.world;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.harsay.ludumdare29.MyGame;
import com.harsay.ludumdare29.assets.Graphic;

public class Level {
	
	public static enum Tile {
		NOTHING, ROCK
	}
	
	public List<ArrayList<Tile>> map = new ArrayList<ArrayList<Tile>>();
	
	public Level() {
		
	}
	
	public void generate() {
		for(int x=0; x<=30; x++) {
			ArrayList<Tile> list = new ArrayList<Tile>();
			for(int y=0; y<=16; y++) {
				if(y > 3) 
					list.add(Tile.ROCK);
				else
					list.add(Tile.NOTHING);
			}
			map.add(list);
		}
		Collections.reverse(map);
	}
	
	public void render(SpriteBatch sb) {
		for(int x=0; x<map.size(); x++) {
			for(int y=0; y<map.get(x).size(); y++) {
				Tile t = map.get(x).get(y);
				Graphic.tile.setPosition(x*MyGame.UNIT, y*MyGame.UNIT);
				if(t.equals(Tile.ROCK)) {
					Graphic.tile.draw(sb);
				}
				// TODO: moar tiles
			}
		}
	}

}