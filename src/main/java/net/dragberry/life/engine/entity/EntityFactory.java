package net.dragberry.life.engine.entity;

public class EntityFactory {
	
	private EntityFactory() {}
	
	public static <T extends Entity> Entity createEntity(Class<T> clazz, int x, int y, EntityParams<T> params) {
		if (clazz == Glider.class) {
			GliderParams gParams = (GliderParams) params;
			if (params != null) {
				return new Glider(x, y);
			} else {
				return new Glider(x, y);
			}
		}
		return null; 
	}

}
