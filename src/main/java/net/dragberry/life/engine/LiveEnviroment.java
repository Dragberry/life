package net.dragberry.life.engine;

import java.awt.Color;
import java.awt.Graphics;

public class LiveEnviroment implements Enviroment {

	private int xLower;
	
	private int yLower;
	
	private int xUpper;
	
	private int yUpper;
	
	private int scale;
	
	private LivingThing[][] population;
	
	public LiveEnviroment() {
		scale = DEFAULT_SCALE;
		xLower = DEFAULT_LOWER_BORDER / scale;
		yLower = DEFAULT_LOWER_BORDER / scale;
		xUpper = DEFAULT_UPPER_BORDER / scale;
		yUpper = DEFAULT_UPPER_BORDER / scale;
		
		population = new LivingThing[xUpper][yUpper];
//		randomState();
		setUpGlider();
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
	
	private void setUpGlider() {
		for (int x = 0; x < xUpper; x++) {
			for (int y = 0; y < yUpper; y++) {
				population[x][y] = new Cell(x, y, scale, false);
			}
		}
		population[50][52] = new Cell(50, 52, scale, true);
		population[51][52] = new Cell(51, 52, scale, true);
		population[52][52] = new Cell(52, 52, scale, true);
		population[52][51] = new Cell(52, 51, scale, true);
		population[51][50] = new Cell(51, 50, scale, true);
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
		for (LivingThing[] ltRow : population) {
			for (LivingThing cell : ltRow) {
				cell.live(this);
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
