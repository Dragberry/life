package net.dragberry.life.engine.processor;

import net.dragberry.life.engine.Environment;
import net.dragberry.life.engine.LivingThing;

public class CheckNeighborsAction extends CellProcessorAction {

	private static final long serialVersionUID = 6997182802898709650L;

	public CheckNeighborsAction(String name, Environment environment, int start, int end) {
		super(name, environment, start, end);
	}

	@Override
	protected void processAction() {
		for (int i = start; i < end; i++) {
			for (LivingThing cell : environment.getPopulation()[i]) {
				cell.resolveNextState(environment);
			}
		}
	}
	
}