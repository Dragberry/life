package net.dragberry.life.engine.entity;

import net.dragberry.life.engine.Environment;
import net.dragberry.life.engine.LivingThing;
import net.dragberry.life.engine.entity.config.Transformation;

public abstract class Entity {

	private int xStart;
	
	private int yStart;
	
	protected LivingThing[] content;
	
	protected Transformation[] transformations;
	
	public Entity(int x, int y, Transformation...transformations) {
		this.xStart = x;
		this.yStart = y;
		this.transformations = transformations;
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
