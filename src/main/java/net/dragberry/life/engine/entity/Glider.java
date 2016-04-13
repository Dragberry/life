package net.dragberry.life.engine.entity;

import net.dragberry.life.engine.Cell;
import net.dragberry.life.engine.LivingThing;

public class Glider extends Entity {
	
	private boolean up = true;
	
	private boolean right = true;

	public Glider(int x, int y) {
		super(x, y);
	}
	
	public Glider(int x, int y, boolean right, boolean up) {
		super(x, y);
		this.up = up;
		this.right = right;
		create();
	}

	@Override
	protected void create() {
		content = new LivingThing[9];
		content[0] = new Cell(0, 0, up);
		content[1] = new Cell(1, 0, true);
		content[2] = new Cell(2, 0, up);
		content[3] = new Cell(0, 1, !right);
		content[4] = new Cell(1, 1, false);
		content[5] = new Cell(2, 1, right);
		content[6] = new Cell(0, 2, !up);
		content[7] = new Cell(1, 2, true);
		content[8] = new Cell(2, 2, !up);
		
	}

}
