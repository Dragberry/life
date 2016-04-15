package net.dragberry.life.engine.entity.config;

import net.dragberry.life.engine.Cell;
import net.dragberry.life.engine.LivingThing;

public class EntityParser {
	
	public static LivingThing[] parse(EntityConfig config, Transformation... transformation) {
		LivingThing[] entities = parse(config);
		boolean transponed = false;
		for (Transformation transform : transformation) {
			switch (transform) {
			case INVERSE_HORIZOTAL:
				entities = inverseHorizontal(entities, config, transponed);
				break;
			case INVERSE_VERTICAL:
				entities = inverseVertical(entities, config, transponed);
				break;
			case TRANSPONE:
				 entities = transpone(entities, config, transponed);
				 transponed = !transponed;
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
	
	private static LivingThing[] inverseHorizontal(LivingThing[] input, EntityConfig config, boolean transponed) {
		int width = !transponed ? config.getWidth() : config.getHeight();
		int height = !transponed ? config.getHeight() : config.getWidth();
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
	
	private static LivingThing[] inverseVertical(LivingThing[] input, EntityConfig config, boolean transponed) {
		LivingThing[] output = new LivingThing[input.length];
		int width = !transponed ? config.getWidth() : config.getHeight();
		int height = !transponed ? config.getHeight() : config.getWidth();
		for (int ySrc = height - 1, y = 0; ySrc >= 0; ySrc--, y++) {
			System.arraycopy(input, width * ySrc, output, width * y, width);
		}
		int cellCounter = 0;
		for (LivingThing cell : output) {
			cell.setX(cellCounter % width);
			cell.setY(cellCounter / width);
			cellCounter++;
		}
		return output;
	}
	
	private static LivingThing[] transpone(LivingThing[] input, EntityConfig config, boolean transponed) {
		LivingThing[] output = new LivingThing[input.length];
		int width = !transponed ? config.getWidth() : config.getHeight();
		int height = !transponed ? config.getHeight() : config.getWidth();
		for (int scrOffset = 0, row = 0; scrOffset < width * height; scrOffset += width, row++) {
			for (int col = 0;  col < width; col++) {
				output[col * height + row] = input[scrOffset + col];
			}
		}
		int cellCounter = 0;
		for (LivingThing cell : output) {
			cell.setX(cellCounter % height);
			cell.setY(cellCounter / height);
			cellCounter++;
		}
		return output;
	}
}