package org.civmmo.persistence.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(City.class)
public abstract class City_ {

	public static volatile SingularAttribute<City, Integer> production;
	public static volatile SingularAttribute<City, Tile> center;
	public static volatile SingularAttribute<City, Building> currentlyConstructedBuilding;
	public static volatile ListAttribute<City, Building> constructedBuildings;
	public static volatile SingularAttribute<City, Integer> range;
	public static volatile ListAttribute<City, Building> workedBuildings;
	public static volatile ListAttribute<City, TradeRoute> tradeRoutesFrom;
	public static volatile SingularAttribute<City, Integer> food;
	public static volatile ListAttribute<City, Tile> visibleTiles;
	public static volatile SingularAttribute<City, Integer> gold;
	public static volatile SingularAttribute<City, Integer> culture;
	public static volatile ListAttribute<City, TradeRoute> tradeRoutesTo;
	public static volatile SingularAttribute<City, Integer> science;
	public static volatile SingularAttribute<City, String> name;
	public static volatile SingularAttribute<City, Building> currentlyConstructedUnit;
	public static volatile SingularAttribute<City, Integer> hitPoints;
	public static volatile SingularAttribute<City, Long> id;
	public static volatile ListAttribute<City, Tile> controledTiles;
	public static volatile ListAttribute<City, Tile> workedTiles;
	public static volatile SingularAttribute<City, Civilization> ownedBy;
	public static volatile SingularAttribute<City, Integer> citizens;

}

