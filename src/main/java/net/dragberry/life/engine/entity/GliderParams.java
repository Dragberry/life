package net.dragberry.life.engine.entity;

public class GliderParams extends EntityParams<Glider> {
	
	public GliderParams(int x, int y, int scale) {
		super(x, y, scale);
	}

	private boolean up;
	
	private boolean right;

	public boolean isUp() {
		return up;
	}

	public boolean isRight() {
		return right;
	}
	

}
