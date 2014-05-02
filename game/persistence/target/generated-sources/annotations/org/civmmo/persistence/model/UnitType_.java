package org.civmmo.persistence.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UnitType.class)
public abstract class UnitType_ {

	public static volatile SingularAttribute<UnitType, Promotion> affectedPromotion;
	public static volatile SingularAttribute<UnitType, String> name;
	public static volatile SingularAttribute<UnitType, Long> id;
	public static volatile ListAttribute<UnitType, Unit> units;

}

