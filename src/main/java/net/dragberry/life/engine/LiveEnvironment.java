package net.dragberry.life.engine;

import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.ForkJoinPool;

import net.dragberry.life.engine.entity.Glider;
import net.dragberry.life.engine.entity.Ship;
import net.dragberry.life.engine.entity.Ship.Size;
import net.dragberry.life.engine.processor.CellLivingAction;
import net.dragberry.life.engine.processor.CellProcessorAction;
import net.dragberry.life.engine.processor.CellProcessorFactory;
import net.dragberry.life.engine.processor.CheckNeighborsAction;

public class LiveEnvironment implements Environment {

	private int xLower;
	
	private int yLower;
	
	private int xUpper;
	
	private int yUpper;
	
	private int scale;
	
	private LivingThing[][] population;
	
	private ForkJoinPool fkPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
	
	public LiveEnvironment() {
		scale = DEFAULT_SCALE;
		xLower = DEFAULT_LOWER_BORDER / scale;
		yLower = DEFAULT_LOWER_BORDER / scale;
		xUpper = DEFAULT_UPPER_BORDER / scale;
		yUpper = DEFAULT_UPPER_BORDER / scale;
		
		population = new LivingThing[xUpper][yUpper];
		clearEnvironment();
//		new Glider(34, 20, true, false).settle(this);
//		new Glider(20, 80, true, true).settle(this);
//		new Glider(80, 80, false, true).settle(this);
//		new Glider(80, 20, false, false).settle(this);
		new Ship(30, 30, Size.HUGE).settle(this);
//		randomState();
	}
	
	@Override
	public void paint(Graphics g) {
		for (LivingThing[] ltRow : population) {
			for (LivingThing cell : ltRow) {
				g.setColor(cell.isAlive() ? Color.GREEN : Color.GRAY);
				g.fillOval(cell.getX() * scale, cell.getY() * scale, scale, scale);
			}
		}
	}
	
	private void clearEnvironment() {
		for (int x = 0; x < xUpper; x++) {
			for (int y = 0; y < yUpper; y++) {
				population[x][y] = new Cell(x, y, false);
			}
		}
	}
	
	@Override
	public void randomState() {
		for (int x = 0; x < xUpper; x++) {
			for (int y = 0; y < yUpper; y++) {
				population[x][y] = new Cell(x, y);
			}
		}
	}
	
	@Override
	public void live() {
		CellProcessorAction cpaNeighbors = CellProcessorFactory.createProcessor(CheckNeighborsAction.class, "Check neighbors", this, xLower, xUpper);
		CellProcessorAction cpaLive = CellProcessorFactory.createProcessor(CellLivingAction.class, "Living action", this, xLower, xUpper);
		fkPool.invoke(cpaNeighbors);
		fkPool.invoke(cpaLive);
	}
	
	@Override
	public int xLowerBorder() {
		return xLower;
	}

	@Override
	public int yLowerBorder() {
		return yLower;
	}

	@Override
	public int xUpperBorder() {
		return xUpper;
	}

	@Override
	public int yUpperBorder() {
		return yUpper;
	}

	@Override
	public LivingThing[][] getPopulation() {
		return population;
	}
	
	@Override
	public int getScale() {
		return scale;
	}

}
