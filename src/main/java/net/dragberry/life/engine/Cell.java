package net.dragberry.life.engine;

public class Cell implements LivingThing {
	
	private boolean alive;
	
	private int x;
	
	private int y;
	
	private int scale;
	
	public Cell(int x, int y, int scale, boolean alive) {
		this.x = x;
		this.y = y;
		this.scale = scale;
		this.alive = alive;
	}
	
	public Cell(int x, int y, int scale) {
		this(x, y, scale, Math.random() > 0.5);
	}
	
	public Cell(int x, int y) {
		this(x, y, 1);
	}

	@Override
	public boolean isAlive() {
		return alive;
	}

	@Override
	public int getXPosition() {
		return x * scale;
	}

	@Override
	public int getYPosition() {
		return y * scale;
	}

	@Override
	public void live(Enviroment ctx) {
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
			alive = true;
		} else if  (liveNeighborCount == 2 && alive) {
			alive = true;
		} else {
			alive = false;
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
}
