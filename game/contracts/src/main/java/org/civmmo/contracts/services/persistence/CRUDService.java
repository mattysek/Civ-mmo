package org.civmmo.contracts.services.persistence;

import java.util.List;

public interface CRUDService<T> {

	void create(T dto);
	
	void update(T dto);
	
	void delete(T dto);
	
	T getById(Long id);
        
        List<T> getAll();
}
