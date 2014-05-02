package org.civmmo.persistence.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Unit.class)
public abstract class Unit_ {

	public static volatile ListAttribute<Unit, UnitType> types;
	public static volatile SingularAttribute<Unit, Integer> cost;
	public static volatile SingularAttribute<Unit, Integer> range;
	public static volatile SingularAttribute<Unit, Integer> experience;
	public static volatile ListAttribute<Unit, Tile> visibleTiles;
	public static volatile SingularAttribute<Unit, Integer> combatStrength;
	public static volatile ListAttribute<Unit, Promotion> promotions;
	public static volatile SingularAttribute<Unit, Integer> movementPoints;
	public static volatile SingularAttribute<Unit, Integer> rangedCombatStrength;
	public static volatile ListAttribute<Unit, City> currentlyConstructedBy;
	public static volatile SingularAttribute<Unit, String> name;
	public static volatile SingularAttribute<Unit, Integer> hitPoints;
	public static volatile SingularAttribute<Unit, Long> id;
	public static volatile SingularAttribute<Unit, Tile> position;
	public static volatile ListAttribute<Unit, Tile> controledTiles;
	public static volatile ListAttribute<Unit, Action> actions;
	public static volatile SingularAttribute<Unit, Civilization> ownedBy;

}

