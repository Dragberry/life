package net.dragberry.life.engine;

public interface LivingThing {

	boolean isAlive();
	
	default boolean isDead() {
		return !isAlive();
	}
	
	int getXPosition();
	
	int getYPosition();
	
	void live(Enviroment env);
	
	
}
