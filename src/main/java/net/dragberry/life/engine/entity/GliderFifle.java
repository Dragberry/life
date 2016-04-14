package net.dragberry.life.engine.entity;

import net.dragberry.life.engine.entity.config.EntityConfig;
import net.dragberry.life.engine.entity.config.EntityParser;

public class GliderFifle extends Entity {
	
	private static final String[] CONFIG = { 
			"000000000001000000000000000000000000",
			"000000000001100000000000000000000000",
			"110000001100000000000011000000000000",
			"100000011100000000000000100000000000",
			"000000001100000000000000010000000000",
			"000000000001100000000000010000000011",
			"000000000001000000000000010000000010",
			"000000000000000000000000100000000000",
			"000000000000000000000011000000000000"
		};

	public GliderFifle(int x, int y) {
		super(x, y);
		create();
	}

	@Override
	protected void create() {
		content = EntityParser.parse(new EntityConfig(CONFIG, 36, 9));
	}

}
