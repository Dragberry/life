package net.dragberry.life.engine.processor;

import java.lang.reflect.InvocationTargetException;

import net.dragberry.life.engine.Environment;

public final class CellProcessorFactory {
	
	private CellProcessorFactory() {}
	
	public static <T extends CellProcessorAction> T createProcessor(Class<T> clazz, String name, Environment env, int start, int end) {
		try {
			return clazz.getDeclaredConstructor(String.class, Environment.class, int.class, int.class).newInstance(name, env, start, end);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return null;
	}
}