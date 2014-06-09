package org.civmmo.persistence.repository.impl;

import java.lang.reflect.ParameterizedType;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.civmmo.persistence.repository.BaseRepository;
import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;

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
        Instant start = Instant.now();
    	persist(object);
        Instant end = Instant.now();
        LOGGER.debug("create: " + Duration.between(start, end));
    }

    public void update(T object) 
    {
        Instant start = Instant.now();
        merge(object);
        Instant end = Instant.now();
        LOGGER.debug("update: " + Duration.between(start, end));
    }

    public void delete(T object) 
    {
        Instant start = Instant.now();
        remove(object);
        Instant end = Instant.now();
        LOGGER.debug("delete: " + Duration.between(start, end));
    }

    public T getById(Long id) 
    {
        Instant start = Instant.now();
        em.find(persistentClass, id);
        Instant end = Instant.now();
        LOGGER.debug("get by id: " + Duration.between(start, end));
        
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
    
}