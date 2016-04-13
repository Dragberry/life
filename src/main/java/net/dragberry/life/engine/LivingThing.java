package net.dragberry.life.engine;

public interface LivingThing {

	boolean isAlive();
	
	default boolean isDead() {
		return !isAlive();
	}
	
	void setX(int x);
	
	void setY(int y);
	
	int getX();
	
	int getY();
	
	void resolveNextState(Environment env);
	
	void willDie();
	
	void willAlive();
	
	void live();
	
}
