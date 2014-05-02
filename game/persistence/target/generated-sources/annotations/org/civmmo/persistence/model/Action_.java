package org.civmmo.persistence.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Action.class)
public abstract class Action_ {

	public static volatile ListAttribute<Action, Unit> aplicableTo;
	public static volatile SingularAttribute<Action, String> name;
	public static volatile ListAttribute<Action, CombatModifier> combatModifiers;
	public static volatile SingularAttribute<Action, Long> id;

}

