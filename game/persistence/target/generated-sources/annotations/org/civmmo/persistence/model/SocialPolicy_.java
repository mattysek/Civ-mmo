package org.civmmo.persistence.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SocialPolicy.class)
public abstract class SocialPolicy_ {

	public static volatile SingularAttribute<SocialPolicy, Integer> baseCost;
	public static volatile ListAttribute<SocialPolicy, Civilization> currentlyUsedBy;
	public static volatile SingularAttribute<SocialPolicy, String> name;
	public static volatile ListAttribute<SocialPolicy, Policy> policies;
	public static volatile SingularAttribute<SocialPolicy, Long> id;

}

