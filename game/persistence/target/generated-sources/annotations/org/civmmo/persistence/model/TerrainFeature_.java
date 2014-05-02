package org.civmmo.persistence.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TerrainFeature.class)
public abstract class TerrainFeature_ {

	public static volatile SingularAttribute<TerrainFeature, Integer> gold;
	public static volatile SingularAttribute<TerrainFeature, Integer> production;
	public static volatile SingularAttribute<TerrainFeature, String> name;
	public static volatile SingularAttribute<TerrainFeature, Integer> movementCost;
	public static volatile SingularAttribute<TerrainFeature, Long> id;
	public static volatile ListAttribute<TerrainFeature, Tile> ofTiles;
	public static volatile SingularAttribute<TerrainFeature, Integer> food;
	public static volatile SingularAttribute<TerrainFeature, CombatModifier> combatModifier;

}

