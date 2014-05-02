package org.civmmo.persistence.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Promotion.class)
public abstract class Promotion_ {

	public static volatile SingularAttribute<Promotion, String> name;
	public static volatile ListAttribute<Promotion, Technology> prerequisities;
	public static volatile SingularAttribute<Promotion, Long> id;
	public static volatile ListAttribute<Promotion, Unit> units;
	public static volatile ListAttribute<Promotion, UnitType> affectedBy;

}

