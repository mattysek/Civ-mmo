package org.civmmo.persistence.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Policy.class)
public abstract class Policy_ {

	public static volatile SingularAttribute<Policy, Integer> cost;
	public static volatile SingularAttribute<Policy, String> name;
	public static volatile SingularAttribute<Policy, Long> Id;
	public static volatile SingularAttribute<Policy, SocialPolicy> socialPolicy;

}

