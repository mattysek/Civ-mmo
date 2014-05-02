package org.civmmo.persistence.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Improvement.class)
public abstract class Improvement_ {

	public static volatile SingularAttribute<Improvement, String> name;
	public static volatile SingularAttribute<Improvement, Long> id;
	public static volatile ListAttribute<Improvement, Tile> ofTiles;

}

