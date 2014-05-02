package org.civmmo.persistence.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TradeRoute.class)
public abstract class TradeRoute_ {

	public static volatile ListAttribute<TradeRoute, Tile> tiles;
	public static volatile SingularAttribute<TradeRoute, City> from;
	public static volatile SingularAttribute<TradeRoute, Long> id;
	public static volatile SingularAttribute<TradeRoute, City> to;

}

