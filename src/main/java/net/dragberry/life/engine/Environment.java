package net.dragberry.life.engine;

public interface Environment extends LivingPainter {
	
	int DEFAULT_LOWER_BORDER = 0;
	
	int DEFAULT_UPPER_BORDER = 1000;
	
	int DEFAULT_SCALE = 5;
	
	void live();
	
	void randomState();
	
	int xLowerBorder();
	
	int yLowerBorder();
	
	int xUpperBorder();
	
	int yUpperBorder();
	
	int getScale();
	
	LivingThing[][] getPopulation();
	
	void switchState();
	
	boolean isPaused();

}
