package org.civmmo.persistence.repository;

import java.util.List;

/**
 *  Interface BaseDao serves as general DAO object interface.
 *  Is meant to be extended by unique interface for each DAO object.
 */

public interface BaseRepository <T>{
    /**
     * Method create saves given object in database. While saved, object is
     * given a unique id.
     * @param object instance of class T to be created
     * @throws IllegalArgumentException when object is already in db (id is not null)
     */
    void create(T object);
    /**
     * Method update updates state of given object in database.
     * @param object instance of class T to be updated
     * @throws IllegalArgumentException when object isn't stored in db (id is null)
     */
    void update(T object);
    /**
     * Method delete deletes given object from database.
     * @param object instance of class T to be removed
     * @throws IllegalArgumentException when the given object isn't in db (id is null)
     */
    void delete(T object);
    /**
     * Method getById retrieves instance of class T with specified id from db.
     * @param id id of instance of class T
     * @return instance of class T with specified id
     * @throws IllegalArgumentException when the given id is less than 0.
     */
    T getById(Long id);
    /**
     * Method getAll fetches all the instances of class T in db.
     * @return list of instances of class T
     */
    List<T> getAll();
}
