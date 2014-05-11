package org.civmmo.contracts.services.persistence;

public interface CRUDService<T> {

	void create(T dto);
	
	void update(T dto);
	
	void delete(T dto);
	
	T getById(Long id);
}
