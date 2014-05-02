package org.civmmo.persistence.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Building.class)
public abstract class Building_ {

	public static volatile SingularAttribute<Building, Integer> cost;
	public static volatile ListAttribute<Building, Technology> requiredTechnologies;
	public static volatile ListAttribute<Building, City> currentlyConstructedBy;
	public static volatile SingularAttribute<Building, String> name;
	public static volatile SingularAttribute<Building, Long> id;
	public static volatile ListAttribute<Building, City> workedBy;
	public static volatile SingularAttribute<Building, Integer> specialistsSlots;
	public static volatile ListAttribute<Building, Resource> requiredResources;
	public static volatile SingularAttribute<Building, Integer> maintenence;

}

