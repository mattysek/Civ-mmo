package org.civmmo.persistence.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Resource.class)
public abstract class Resource_ {

	public static volatile SingularAttribute<Resource, Integer> gold;
	public static volatile ListAttribute<Resource, Unit> requiredByUnits;
	public static volatile SingularAttribute<Resource, Integer> production;
	public static volatile SingularAttribute<Resource, Float> happiness;
	public static volatile SingularAttribute<Resource, String> name;
	public static volatile SingularAttribute<Resource, Resource> revealedBy;
	public static volatile SingularAttribute<Resource, Long> id;
	public static volatile ListAttribute<Resource, Building> requiredByBuildings;
	public static volatile SingularAttribute<Resource, Improvement> improvement;
	public static volatile ListAttribute<Resource, Tile> canBeFoundOnTiles;
	public static volatile SingularAttribute<Resource, Integer> food;

}

