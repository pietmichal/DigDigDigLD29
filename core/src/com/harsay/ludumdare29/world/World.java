package com.harsay.ludumdare29.world;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.harsay.ludumdare29.MyGame;
import com.harsay.ludumdare29.other.Controller;

public class World {
	
	public static SpriteBatch sb = new SpriteBatch();
	public static ShapeRenderer sr = new ShapeRenderer();
	public static List<Entity> entities = new ArrayList<Entity>();
	
	public static OrthographicCamera cam = new OrthographicCamera(MyGame.WIDTH, MyGame.HEIGHT);
	
	public static Level level = new Level();
	
	public World() {
		cam.position.set(MyGame.WIDTH / 2, MyGame.HEIGHT / 2, 0);
		cam.setToOrtho(true, MyGame.WIDTH, MyGame.HEIGHT);
		level.generate();
	}
	
	public static void update(float delta) {
		for(int i = 0; i < entities.size(); i++) {
			Entity ent = entities.get(i);
			ent.update(delta);
		}
	}
	
	public static void render() {
		cam.update();
		sb.begin();
		sb.setProjectionMatrix(cam.combined);
		level.render(sb);
		for(int i = 0; i < entities.size(); i++) {
			Entity ent = entities.get(i);
			ent.render(sb);
		}
		sb.end();
		sr.setProjectionMatrix(cam.combined); // <--- That took me over 3 hours to figure out that I forgot to use it.
		sr.begin(ShapeType.Line);
		Controller.drawCursor(sr);
		sr.end();
	}
	
	public static void clear() {
		
	}
	
	public static void add(Entity ent) {
		entities.add(ent);
	}
	
}
