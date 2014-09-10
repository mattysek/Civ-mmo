package org.civmmo.contracts.services.persistence;

import java.util.List;

public interface QueryableService<T> {
    
    List<T> getAllSQL();
    List<T> getAllMongo();
    List<T> getAllNeo();
    
    T getByIdSQL(long id);
    T getByIdMongo(long id);
    T getByIdNeo(long id);
    
    List<T> testGetListNativeQuery(String query);
    T testGetSingleNativeQuery(String query);
}
