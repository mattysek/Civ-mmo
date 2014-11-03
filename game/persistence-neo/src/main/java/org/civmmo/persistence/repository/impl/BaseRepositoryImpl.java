package org.civmmo.persistence.repository.impl;

import java.io.PrintWriter;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.civmmo.persistence.repository.BaseRepository;
import org.neo4j.cypher.ExecutionEngine;
import org.neo4j.cypher.ExecutionResult;
import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.ResourceIterable;
import org.neo4j.kernel.impl.util.StringLogger;
import org.neo4j.tooling.GlobalGraphOperations;
import scala.collection.Iterator;

public abstract class BaseRepositoryImpl<T> implements BaseRepository<T>
{   
    protected final GraphDatabaseService graphDb;
    protected final ExecutionEngine engine;
    
    protected abstract T translate(Node node);
    protected abstract void createObject(T object);
    protected abstract void deleteObject(T object);
        
    BaseRepositoryImpl(GraphDatabaseService graphDb)
    {
        this.graphDb = graphDb;
        engine = new ExecutionEngine(this.graphDb,StringLogger.wrap(new PrintWriter(System.out)));
    }
    
    protected Class<T> persistentClass = figureOutPersistentClass();
    
    @SuppressWarnings("unchecked")
	private Class<T> figureOutPersistentClass() 
    {
        Class<T> result = (Class<T>)((ParameterizedType) (getClass().getGenericSuperclass())).getActualTypeArguments()[0];
        return result;
    }
        
    private ExecutionResult getResultOfQuery(String query)
    {
        return engine.execute(query);
    }

    @Override
    public void create(T object) {
        createObject(object);
    }
    
    @Override
    public void delete(T object) {
        deleteObject(object);
    }

    @Override
    public T getById(Long id) {
        ResourceIterable<Node> result = graphDb.findNodesByLabelAndProperty(DynamicLabel.label(persistentClass.getSimpleName()), "id", id);
        Optional<Node> node = StreamSupport.stream(result.spliterator(), true).findFirst();
        if(node.isPresent())
        {
            return translate(node.get());
        }
        else
        {
            return null;
        }
    }

    @Override
    public List<T> getAll() {
//        ResourceIterable<Node> result = GlobalGraphOperations.at(graphDb).getAllNodesWithLabel(DynamicLabel.label(persistentClass.getSimpleName()));
//        
//        List<T> res =  StreamSupport.stream(result.spliterator(), false)
//                                       .map(this::translate).collect(Collectors.toList());
//        
//        return res;
        List<T> result = new ArrayList();
        ResourceIterable<Node> res = GlobalGraphOperations.at(graphDb).getAllNodesWithLabel(DynamicLabel.label(persistentClass.getSimpleName()));
        res.forEach(e -> result.add(translate(e)));
        return result;
    }

    @Override
    public T getSingleResultOfNativeQuery(String query) {
        Iterator<Node> iterator = getResultOfQuery(query).columnAs("n");
        if(iterator.hasNext())
        {
            return translate(iterator.next());
        }
        return null;
    }

    @Override
    public List<T> getResultListOfNativeQuery(String query) {
        List<T> result = new ArrayList();
        for (Iterator<Node> iterator = getResultOfQuery(query).columnAs("n"); iterator.hasNext();) {
            Node next = iterator.next();
            result.add(translate(next));
        }
        return result;
    }
    
}