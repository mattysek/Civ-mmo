package org.civmmo.contracts.services.persistence;

import java.util.List;

public interface QueryableService<T> {
    
    List<T> getAll();
}
