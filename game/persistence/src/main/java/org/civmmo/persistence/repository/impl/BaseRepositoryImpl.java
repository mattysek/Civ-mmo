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

public abstract class BaseRepositoryImpl<T> implements BaseRepository<T>
{   
    @PersistenceContext
    private EntityManager em;
    
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
    	persist(object);
    }

    public void update(T object) 
    {
        merge(object);
    }

    public void delete(T object) 
    {
        remove(object);
    }

    public T getById(Long id) 
    {
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
    
//    public T getByIdUsingMongo(Long id) 
//    {
//        return (T) em.createNativeQuery("{'_id':" + id + "}",persistentClass).getSingleResult();
//    }
//
//    public List<T> getAllUsingMongo() 
//    {
//        return (List<T>) em.createNativeQuery("",persistentClass).getResultList();
//    }
//    
//    public T getByIdUsingSQL(Long id) 
//    {
//        return (T) em.createNativeQuery(" SELECT * FROM " + persistentClass.getSimpleName() +" WHERE id=" + id,persistentClass).getSingleResult();
//    }
//
//    public List<T> getAllUsingSQL() 
//    {
//        return (List<T>) em.createNativeQuery("SELECT * FROM " + persistentClass.getSimpleName(),persistentClass).getResultList();
//    }
//    
//    public T getByIdUsingNeo(Long id) 
//    {
//        return (T) em.createNativeQuery("MATCH (n:" + persistentClass.getSimpleName() + ":ENTITY { id: " + id + "}) RETURN n",persistentClass).getSingleResult();
//    }
//
//    public List<T> getAllUsingNeo() 
//    {
//        return (List<T>) em.createNativeQuery("MATCH (n:" + persistentClass.getSimpleName() + ":ENTITY) RETURN n",persistentClass).getResultList();
//    }
        
    @Override
    public T getSingleResultOfNativeQuery(String query)
    {
        return (T) em.createNativeQuery(query,persistentClass).getSingleResult();
    }
        
    @Override
    public List<T> getResultListOfNativeQuery(String query)
    {
        return (List<T>) em.createNativeQuery(query,persistentClass).getResultList();
    }
    
}