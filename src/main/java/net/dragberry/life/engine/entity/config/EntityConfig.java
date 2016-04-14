package net.dragberry.life.engine.entity.config;

public class EntityConfig {
	
	private String[] content;
	private int width;
	private int height;
	
	public EntityConfig(String[] content, int width, int height) {
		this.content = content;
		this.width = width;
		this.height = height;
	}
	
	public boolean isAliveAt(int x, int y) {
		return content[y].charAt(x) == '1';
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
}