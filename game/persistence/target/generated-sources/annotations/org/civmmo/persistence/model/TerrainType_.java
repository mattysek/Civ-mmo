package org.civmmo.persistence.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TerrainType.class)
public abstract class TerrainType_ {

	public static volatile SingularAttribute<TerrainType, Integer> gold;
	public static volatile SingularAttribute<TerrainType, Integer> production;
	public static volatile SingularAttribute<TerrainType, String> name;
	public static volatile SingularAttribute<TerrainType, Integer> movementCost;
	public static volatile SingularAttribute<TerrainType, Long> id;
	public static volatile ListAttribute<TerrainType, Tile> ofTiles;
	public static volatile SingularAttribute<TerrainType, Integer> food;
	public static volatile SingularAttribute<TerrainType, CombatModifier> combatModifier;

}

