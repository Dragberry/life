package net.dragberry.life.engine.entity.config;

import net.dragberry.life.engine.Cell;
import net.dragberry.life.engine.LivingThing;

public class EntityParser {
	
	public static LivingThing[] parse(EntityConfig config, Transformation... transformation) {
		LivingThing[] entities = parse(config);
		for (Transformation transform : transformation) {
			switch (transform) {
			case INVERSE_HORIZOTAL:
				entities = inverseHorizontally(entities, config);
				break;
			case INVERSE_VERTICAL:
				break;
			default:
				break;
			}
		}
		return entities;
	}
	
	public static LivingThing[] parse(EntityConfig config) {
		LivingThing[] entities = new LivingThing[config.getHeight() * config.getWidth()];
		int cellCounter = 0;
		for (int y = 0; y < config.getHeight(); y++) {
			 for (int x = 0; x < config.getWidth(); x++) {
				 entities[cellCounter++] = new Cell(x, y, config.isAliveAt(x, y));
			 }
		}
		return entities;
	}
	
	private static LivingThing[] inverseHorizontally(LivingThing[] input, EntityConfig config) {
		int width = config.getWidth();
		int height = config.getHeight();
		LivingThing[] output = new LivingThing[input.length];
		int cellCounter = 0;
		for (int y = 0; y < height; y++) {
			for (int absoluteX = (width * (y + 1) - 1), x = width - 1; absoluteX >= width * y; absoluteX--, x--) {
				output[cellCounter] = input[width * y + x];
				output[cellCounter].setX(cellCounter % width);
				output[cellCounter].setY(cellCounter / width);
				cellCounter++;
			}
		}
		return output;
	}
}