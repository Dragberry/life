package net.dragberry.life.engine;

import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

import net.dragberry.life.engine.entity.Glider;

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
//		new Glider(20, 20, scale, true, false).settle(this);
//		new Glider(20, 80, scale, true, true).settle(this);
//		new Glider(80, 80, scale, false, true).settle(this);
//		new Glider(80, 20, scale, false, false).settle(this);
		randomState();
//		setUpGlider();
	}
	
	@Override
	public void paint(Graphics g) {
		for (LivingThing[] ltRow : population) {
			for (LivingThing cell : ltRow) {
				g.setColor(cell.isAlive() ? Color.GREEN : Color.GRAY);
				g.fillOval(cell.getXPosition(), cell.getYPosition(), scale, scale);
			}
		}
	}
	
	private void clearEnvironment() {
		for (int x = 0; x < xUpper; x++) {
			for (int y = 0; y < yUpper; y++) {
				population[x][y] = new Cell(x, y, scale, false);
			}
		}
	}
	
	@Override
	public void randomState() {
		for (int x = 0; x < xUpper; x++) {
			for (int y = 0; y < yUpper; y++) {
				population[x][y] = new Cell(x, y, scale);
			}
		}
	}
	
	@Override
	public void live() {
		CellProcessorAction cpa = new CellProcessorAction(this, xLower, xUpper);
		fkPool.invoke(cpa);
		
		for (LivingThing[] ltRow : population) {
			for (LivingThing cell : ltRow) {
				cell.live();
			}
		}
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

class CellProcessorAction extends RecursiveAction {

	private static final long serialVersionUID = -4755252474458719157L;
	
	private static final int AMOUNT_TO_PROCESS = 5000;
	
	private int start;
	private int end;
	private Environment environment;
	
	public CellProcessorAction(Environment environment, int start, int end) {
		this.environment = environment;
		this.start = start;
		this.end = end;
	}

	@Override
	protected void compute() {
		if (end - start <= (environment.xUpperBorder() * environment.yUpperBorder() / AMOUNT_TO_PROCESS)) {
			System.out.println(Thread.currentThread().getName() + "Start=" + start + " End=" + end);
			for (int i = start; i < end; i++) {
				for (LivingThing cell : environment.getPopulation()[i]) {
					cell.resolveNextState(environment);
				}
			}
		} else {
			int halfWay = ((end - start) / 2) + start;
			CellProcessorAction a1 = new CellProcessorAction(environment, start, halfWay);
			a1.fork();
			CellProcessorAction a2 = new CellProcessorAction(environment, halfWay, end);
			a2.compute();
			a1.join();
		}
	}
	
}
