package org.civmmo.persistence.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CombatModifier.class)
public abstract class CombatModifier_ {

	public static volatile SingularAttribute<CombatModifier, Long> id;
	public static volatile SingularAttribute<CombatModifier, Double> value;
	public static volatile SingularAttribute<CombatModifier, Action> afectedAction;

}

