package net.dragberry.life.engine.entity;

import net.dragberry.life.engine.Cell;
import net.dragberry.life.engine.LivingThing;

public class Ship extends Entity {

	public Ship(int x, int y) {
		super(x, y);
		create();
	}

	@Override
	protected void create() {
		content = new LivingThing[20];
		content[0] = new Cell(0, 0, true);
		content[1] = new Cell(1, 0, false);
		content[2] = new Cell(2, 0, false);
		content[3] = new Cell(3, 0, true);
		content[4] = new Cell(4, 0, false);
		
		content[5] = new Cell(0, 1, false);
		content[6] = new Cell(1, 1, false);
		content[7] = new Cell(2, 1, false);
		content[8] = new Cell(3, 1, false);
		content[9] = new Cell(4, 1, true);
		
		content[10] = new Cell(0, 2, true);
		content[11] = new Cell(1, 2, false);
		content[12] = new Cell(2, 2, false);
		content[13] = new Cell(3, 2, false);
		content[14] = new Cell(4, 2, true);
		
		content[15] = new Cell(0, 3, false);
		content[16] = new Cell(1, 3, true);
		content[17] = new Cell(2, 3, true);
		content[18] = new Cell(3, 3, true);
		content[19] = new Cell(4, 3, true);
	}

}
