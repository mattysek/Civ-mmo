package org.civmmo.persistence.repository.impl;

import java.lang.reflect.ParameterizedType;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.civmmo.persistence.repository.BaseRepository;
import org.hibernate.search.Search;
import org.jboss.logging.Logger;

public abstract class BaseRepositoryImpl<T> implements BaseRepository<T>
{   
    @PersistenceContext
    private EntityManager em;
    
    private final static Logger LOGGER = Logger.getLogger("ogm-repository-logger"); 

    public EntityManager getEntityManager() {
        return em;
    }

    public void setEntityManager(EntityManager entityManager) {
        em = entityManager;
    }
          
    private Class<T> persistentClass = figureOutPersistentClass();
    
    @SuppressWarnings("unchecked")
	private Class<T> figureOutPersistentClass() 
    {
        Class<T> result = (Class<T>)((ParameterizedType) (getClass().getGenericSuperclass())).getActualTypeArguments()[0];
        return result;
    }
    
    private void persistObject(T object)
    {
        em.persist(object);
    }
    
    private void removeObject(T object)
    {
        em.remove(em.merge(object));
    }
    
    private void mergeObject(T object)
    {
        em.merge(object);
    }
    
    private void log(String operation, String object, Instant start, Instant end)
    {
        LOGGER.debug(operation + " " + object + ": " + Duration.between(start, end));
    }
    
    protected void persist(T object)
    {
        persistObject(object);
    }
    
    protected void remove(T object)
    {
        removeObject(object);
    }
    
    protected void merge(T object)
    {
        mergeObject(object);
    }
        
    public void create(T object) 
    {
        //Instant start = Instant.now();
    	persist(object);
        //Instant end = Instant.now();
        //log("create",object.getClass().getName(),start,end);
    }

    public void update(T object) 
    {
        //Instant start = Instant.now();
        merge(object);
        //Instant end = Instant.now();
        //log("update",object.getClass().getName(),start,end);
    }

    public void delete(T object) 
    {
        //Instant start = Instant.now();
        remove(object);
        //Instant end = Instant.now();
        //log("delete",object.getClass().getName(),start,end);
    }

    public T getById(Long id) 
    {
        //Instant start = Instant.now();
        em.find(persistentClass, id);
        //Instant end = Instant.now();
        //log("delete",persistentClass.getName(),start,end);
        
        T result = em.find(persistentClass, id);
        return result;
    }

    @SuppressWarnings("unchecked")
    public List<T> getAll() 
    {
        Query q = em.createQuery("SELECT o FROM " +
                persistentClass.getSimpleName() + " o");
        return (List<T>) q.getResultList();
    }
    
    public T getByIdUsingMongo(Long id) 
    {
        return (T) em.createNativeQuery("{'_id':" + id + "}",persistentClass).getSingleResult();
    }

    public List<T> getAllUsingMongo() 
    {
        return (List<T>) em.createNativeQuery("",persistentClass).getResultList();
    }
    
    public T getByIdUsingSQL(Long id) 
    {
        return (T) em.createNativeQuery(" SELECT * FROM " + persistentClass.getSimpleName() +" WHERE id=" + id,persistentClass).getSingleResult();
    }

    public List<T> getAllUsingSQL() 
    {
        return (List<T>) em.createNativeQuery("SELECT * FROM " + persistentClass.getSimpleName(),persistentClass).getResultList();
    }
    
    @Override
    public T getSingleResultOfQuery(String query)
    {
        return (T) em.createQuery(query).getSingleResult();
    }
    
    @Override
    public T getSingleResultOfNativeQuery(String query)
    {
        return (T) em.createNativeQuery(query,persistentClass).getSingleResult();
    }
    
    @Override
    public List<T> getResultListOfQuery(String query)
    {
        return (List<T>) em.createQuery(query).getResultList();
    }
    
    @Override
    public List<T> getResultListOfNativeQuery(String query)
    {
        return (List<T>) em.createNativeQuery(query,persistentClass).getResultList();
    }
    
}