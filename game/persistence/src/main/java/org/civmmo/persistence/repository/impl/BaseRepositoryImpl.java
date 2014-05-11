package org.civmmo.persistence.repository.impl;

import java.util.List;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.civmmo.persistence.repository.BaseRepository;

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
        return em.find(persistentClass, id);
    }

    @SuppressWarnings("unchecked")
	public List<T> getAll() 
    {
        Query q = em.createQuery("SELECT o FROM " + 
                persistentClass.getSimpleName() + " o");
        return (List<T>) q.getResultList();
    }
    
}