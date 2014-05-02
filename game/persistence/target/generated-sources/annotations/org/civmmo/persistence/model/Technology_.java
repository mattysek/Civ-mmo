package org.civmmo.persistence.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Technology.class)
public abstract class Technology_ {

	public static volatile SingularAttribute<Technology, Long> cost;
	public static volatile ListAttribute<Technology, Resource> revealsResources;
	public static volatile SingularAttribute<Technology, String> name;
	public static volatile ListAttribute<Technology, Unit> revealsUnits;
	public static volatile ListAttribute<Technology, Technology> prerequisities;
	public static volatile ListAttribute<Technology, Civilization> knownBy;
	public static volatile SingularAttribute<Technology, Long> id;
	public static volatile ListAttribute<Technology, Building> revealsBuildings;

}

