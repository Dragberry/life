package net.dragberry.life.engine.entity;

public class EntityParams<T extends Entity> {
	
	private int x;
	
	private int y;
	
	private int scale;
	
	public EntityParams(int x, int y, int scale) {
		this.x = x;
		this.y = y;
		this.scale = scale;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getScale() {
		return scale;
	}
	
	

}
