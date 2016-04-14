package net.dragberry.life.engine.entity;

import net.dragberry.life.engine.Environment;
import net.dragberry.life.engine.LivingThing;

public abstract class Entity {

	private int xStart;
	
	private int yStart;
	
	protected LivingThing[] content;
	
	public Entity(int x, int y) {
		this.xStart = x;
		this.yStart = y;
	}
	
	protected abstract void create();
	
	public int getXstart() {
		return xStart;
	}
	
	public int getYstart() {
		return yStart;
	}
	
	public void settle(Environment env) {
		for (LivingThing cell : content) {
			cell.setX(cell.getX() + xStart);
			cell.setY(cell.getY() + yStart);
			env.getPopulation()[cell.getX()][cell.getY()] = cell;
		}
	}
	
	public static class Params {
		
	}
}
