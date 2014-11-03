package org.civmmo.persistence.repository;

import java.util.List;

public interface BaseRepository <T>{
    
    void create(T object);
    
    void delete(T object);
    
    T getById(Long id);
    
    List<T> getAll();
    
    T getSingleResultOfNativeQuery(String query);
    
    List<T> getResultListOfNativeQuery(String query);
}
