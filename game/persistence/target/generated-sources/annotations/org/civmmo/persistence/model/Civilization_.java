package org.civmmo.persistence.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Civilization.class)
public abstract class Civilization_ {

	public static volatile ListAttribute<Civilization, City> cities;
	public static volatile SingularAttribute<Civilization, SocialPolicy> currentPolicy;
	public static volatile ListAttribute<Civilization, Civilization> enemies;
	public static volatile ListAttribute<Civilization, SocialPolicy> availableSocialPolicies;
	public static volatile ListAttribute<Civilization, Unit> units;
	public static volatile SingularAttribute<Civilization, Long> gold;
	public static volatile SingularAttribute<Civilization, Float> happiness;
	public static volatile SingularAttribute<Civilization, Long> culture;
	public static volatile ListAttribute<Civilization, Technology> knownTechnologies;
	public static volatile SingularAttribute<Civilization, Long> science;
	public static volatile ListAttribute<Civilization, Policy> unlockedPolicies;
	public static volatile SingularAttribute<Civilization, String> name;
	public static volatile SingularAttribute<Civilization, Long> id;
	public static volatile SingularAttribute<Civilization, Technology> currentlyStudiedTechnology;
	public static volatile ListAttribute<Civilization, Civilization> allies;

}

