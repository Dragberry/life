package net.dragberry.life.engine.entity;

import net.dragberry.life.engine.entity.config.EntityConfig;
import net.dragberry.life.engine.entity.config.EntityParser;

public class Ship extends Entity {
	
	private static final String[] SMALL_CONFIG = { 
		"00010",
		"00001", 
		"10001",
		"01111" 
	};
	
	private static final String[] MEDIUM_CONFIG = { 
			"000010",
			"000001", 
			"100001",
			"011111" 
		};
	
	private static final String[] HUGE_CONFIG = { 
			"0000010",
			"0000001", 
			"1000001",
			"0111111" 
		};
	
	public static enum Size {
		
		SMALL(SMALL_CONFIG, 5, 4), MEDIUM(MEDIUM_CONFIG, 6, 4), HUGE(HUGE_CONFIG, 7, 4);
		
		private EntityConfig config;
		
		private Size(String[] content, int width, int height) {
			config = new EntityConfig(content, width, height);
		}
		
		public EntityConfig getConfig() {
			return config;
		}
	}
	
	private Size size = Size.SMALL;

	public Ship(int x, int y) {
		super(x, y);
		create();
	}
	
	public Ship(int x, int y, Size size) {
		super(x, y);
		this.size = size;
		create();
	}

	@Override
	protected void create() {
		content = EntityParser.parse(size.getConfig());
	}

}
