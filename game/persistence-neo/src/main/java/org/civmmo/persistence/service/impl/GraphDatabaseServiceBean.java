/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.civmmo.persistence.service.impl;

import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

/**
 *
 * @author Mattysek
 */
@Startup
@Singleton
public final class GraphDatabaseServiceBean {
    
    private static final String DB_PATH = "D:\\_Prog\\Neo4j\\_DB_2";
    
    private static final GraphDatabaseService graphDb = new GraphDatabaseFactory().newEmbeddedDatabase( DB_PATH );
        
    public static GraphDatabaseService getGraphDb()
    {
        return graphDb;
    }
    
    @PreDestroy
    private static void applicationShutDown() {
        graphDb.shutdown();
    }
    
}
