package net.dragberry.life.engine.entity;

public class EntityFactory {
	
	private EntityFactory() {}
	
	public static <T extends Entity> Entity createEntity(Class<T> clazz, int x, int y, int scale, EntityParams<T> params) {
		if (clazz == Glider.class) {
			GliderParams gParams = (GliderParams) params;
			if (params != null) {
				return new Glider(x, y, scale, gParams.isRight(), gParams.isUp());
			} else {
				return new Glider(x, y, scale);
			}
		}
		return null; 
	}

}
