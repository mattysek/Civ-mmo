package org.civmmo.persistence.repository.impl;

import org.civmmo.persistence.repository.CityRepository;
import org.civmmo.model.City;
import org.civmmo.persistence.model.CityNode;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;

public class CityRepositoryImpl extends BaseRepositoryImpl<City> implements CityRepository {

    public CityRepositoryImpl(GraphDatabaseService graphDb) {
        super(graphDb);
    }

    @Override
    protected City translate(Node node) {
        return new CityNode(node);
    }

    @Override
    protected void deleteObject(City object) {
        ((CityNode)object).getUnderlyingNode().delete();
    }
    
    @Override
    protected void createObject(City object) {
        Node node = ((CityNode)object).getUnderlyingNode();
        object.setId(node.getId());
    }
	
}
