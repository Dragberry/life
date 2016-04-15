package net.dragberry.life.engine.processor;

import java.util.concurrent.RecursiveAction;

import net.dragberry.life.engine.Environment;

public abstract class CellProcessorAction extends RecursiveAction {

	private static final long serialVersionUID = -4755252474458719157L;
	
	private static final int AMOUNT_TO_PROCESS = 2000;
	
	private String processorName;
	protected int start;
	protected int end;
	protected Environment environment;
	
	public CellProcessorAction(String name, Environment environment, Integer start, Integer end) {
		this.processorName = name;
		this.environment = environment;
		this.start = start;
		this.end = end;
	}
	
	protected abstract void processAction();

	@Override
	protected void compute() {
		if (end - start <= (environment.xUpperBorder() * environment.yUpperBorder() / AMOUNT_TO_PROCESS)) {
			processAction();
		} else {
			int halfWay = ((end - start) / 2) + start;
			CellProcessorAction a1 = CellProcessorFactory.createProcessor(getClass(), processorName, environment, start, halfWay);
			a1.fork();
			CellProcessorAction a2 = CellProcessorFactory.createProcessor(getClass(), processorName, environment, halfWay, end);
			a2.compute();
			a1.join();
		}
	}
	
}