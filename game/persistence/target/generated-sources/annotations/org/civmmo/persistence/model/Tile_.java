package org.civmmo.persistence.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Tile.class)
public abstract class Tile_ {

	public static volatile ListAttribute<Tile, TradeRoute> tradeRoutes;
	public static volatile ListAttribute<Tile, River> rivers;
	public static volatile ListAttribute<Tile, City> visibleForCities;
	public static volatile ListAttribute<Tile, Unit> controledByUnit;
	public static volatile SingularAttribute<Tile, TerrainFeature> terrainFeature;
	public static volatile SingularAttribute<Tile, City> city;
	public static volatile SingularAttribute<Tile, Resource> resource;
	public static volatile SingularAttribute<Tile, Improvement> improvement;
	public static volatile SingularAttribute<Tile, Unit> militaryUnit;
	public static volatile SingularAttribute<Tile, Unit> civilUnit;
	public static volatile ListAttribute<Tile, Unit> visibleForUnits;
	public static volatile ListAttribute<Tile, City> controledByCity;
	public static volatile SingularAttribute<Tile, TerrainType> terrainType;
	public static volatile SingularAttribute<Tile, Long> x;
	public static volatile SingularAttribute<Tile, Long> y;
	public static volatile SingularAttribute<Tile, Long> id;
	public static volatile SingularAttribute<Tile, Region> region;
	public static volatile ListAttribute<Tile, City> workedBy;

}

