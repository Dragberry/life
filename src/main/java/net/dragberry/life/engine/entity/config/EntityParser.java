package net.dragberry.life.engine.entity.config;

import net.dragberry.life.engine.Cell;
import net.dragberry.life.engine.LivingThing;

public class EntityParser {
	
	public static LivingThing[] parse(EntityConfig config) {
		LivingThing[] entities = new LivingThing[config.getHeight() * config.getWidth()];
		int cellCounter = 0;
		for (int y = 0; y < config.getHeight(); y++) {
			 for (int x = 0; x < config.getWidth(); x++) {
				 entities[cellCounter++] = new Cell(y, x, config.isAliveAt(x, y));
			 }
		}
		return entities;
	}
	
	private static void inverse() {
		
	}
}