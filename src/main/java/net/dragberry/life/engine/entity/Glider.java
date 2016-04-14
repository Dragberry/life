package net.dragberry.life.engine.entity;

import net.dragberry.life.engine.entity.config.EntityConfig;
import net.dragberry.life.engine.entity.config.EntityParser;

public class Glider extends Entity {
	
	private static final String[] CONFIG = { 
		"010",
		"001", 
		"111"
	};
	
	public Glider(int x, int y) {
		super(x, y);
		create();
	}
	
	@Override
	protected void create() {
		content = EntityParser.parse(new EntityConfig(CONFIG, 3, 3));
	}

}
