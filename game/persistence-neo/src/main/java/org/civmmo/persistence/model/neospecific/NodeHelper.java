/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.civmmo.persistence.model.neospecific;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Node;

/**
 *
 * @author Mattysek
 */
public class NodeHelper {
    public static <T> T getProperty(Node node, String name)
    {
        return (T)node.getProperty(name);
    }
    
    public static <T> void setProperty(Node node, String name, T value)
    {
        node.setProperty(name, value);
    }
    
    public static <T> List<T> getRelationship(Node node, RelationshipType type, Function<Node, T> translator)
    {
        List<T> result = new ArrayList();
        node.getRelationships(type).forEach(e -> result.add(translator.apply(e.getEndNode())));
        return result;
    }
    
    public static <T> void setRelationship(Node node, List<T> list, RelationshipType type, Function<T,Node> translator)
    {
        list.forEach(e -> node.createRelationshipTo(translator.apply(e), type));
    }
    
    public static <T> T getSingleRelationship(Node node, RelationshipType type, Function<Node, T> translator)
    {
        return translator.apply(node.getSingleRelationship(type, Direction.BOTH).getEndNode());
    }
    
    public static <T> void setSingleRelationship(Node node, T item, RelationshipType type, Function<T,Node> translator)
    {
        node.createRelationshipTo(translator.apply(item), type);
    }
}
