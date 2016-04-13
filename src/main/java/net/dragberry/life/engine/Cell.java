package net.dragberry.life.engine;

import java.text.MessageFormat;

public class Cell implements LivingThing {
	
	private boolean alive;
	
	private boolean  willAlive;
	
	private int x;
	
	private int y;
	
	
	public Cell(int x, int y, boolean alive) {
		this.x = x;
		this.y = y;
		this.alive = alive;
	}
	
	public Cell(int x, int y) {
		this(x, y, Math.random() > 0.5);
	}
	
	@Override
	public boolean isAlive() {
		return alive;
	}

	@Override
	public void resolveNextState(Environment ctx) {
		LivingThing[][] population = ctx.getPopulation();
		int liveNeighborCount = 0;
		if (population[resolvePosition(x - 1, ctx.xLowerBorder(), ctx.xUpperBorder())][resolvePosition(y - 1, ctx.yLowerBorder(), ctx.yUpperBorder())].isAlive()) {
			liveNeighborCount++;
		}
		if (population[resolvePosition(x, ctx.xLowerBorder(), ctx.xUpperBorder())][resolvePosition(y - 1, ctx.yLowerBorder(), ctx.yUpperBorder())].isAlive()) {
			liveNeighborCount++;
		}
		if (population[resolvePosition(x + 1, ctx.xLowerBorder(), ctx.xUpperBorder())][resolvePosition(y - 1, ctx.yLowerBorder(), ctx.yUpperBorder())].isAlive()) {
			liveNeighborCount++;
		}
		if (population[resolvePosition(x + 1, ctx.xLowerBorder(), ctx.xUpperBorder())][resolvePosition(y, ctx.yLowerBorder(), ctx.yUpperBorder())].isAlive()) {
			liveNeighborCount++;
		}
		if (population[resolvePosition(x + 1, ctx.xLowerBorder(), ctx.xUpperBorder())][resolvePosition(y + 1, ctx.yLowerBorder(), ctx.yUpperBorder())].isAlive()) {
			liveNeighborCount++;
		}
		if (population[resolvePosition(x, ctx.xLowerBorder(), ctx.xUpperBorder())][resolvePosition(y + 1, ctx.yLowerBorder(), ctx.yUpperBorder())].isAlive()) {
			liveNeighborCount++;
		}
		if (population[resolvePosition(x - 1, ctx.xLowerBorder(), ctx.xUpperBorder())][resolvePosition(y + 1, ctx.yLowerBorder(), ctx.yUpperBorder())].isAlive()) {
			liveNeighborCount++;
		}
		if (population[resolvePosition(x - 1, ctx.xLowerBorder(), ctx.xUpperBorder())][resolvePosition(y, ctx.yLowerBorder(), ctx.yUpperBorder())].isAlive()) {
			liveNeighborCount++;
		}
		
		if (liveNeighborCount == 3) {
			willAlive();
		} else if  (liveNeighborCount == 2 && alive) {
			willAlive();
		} else {
			willDie();
		}
	}

	
	private int resolvePosition(int input, int lower, int upper) {
		if (input < lower) {
			return upper - 1;
		} else if (input >= upper) {
			return lower;
		} else {
			return input;
		}
	}

	@Override
	public void willDie() {
		willAlive = false;
	}

	@Override
	public void willAlive() {
		willAlive = true;
	}

	@Override
	public void live() {
		alive = willAlive;
	}
	
	@Override
	public String toString() {
		return MessageFormat.format("[x={0},y={1},alive={2}]", x, y, alive);
	}

	@Override
	public void setX(int x) {
		this.x = x;
	}

	@Override
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}
}
