package org.civmmo.persistence.service;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.civmmo.contracts.model.ImprovementDto;
import org.civmmo.contracts.services.persistence.ImprovementService;
import org.civmmo.persistence.model.Improvement;
import org.civmmo.persistence.repository.ImprovementRepository;

@Stateless
public class ImprovementServiceImpl extends BaseService implements ImprovementService {
    
    @Inject
    private ImprovementRepository repository;
    
    public void create(ImprovementDto dto) {
        Improvement imp = translate(dto);
        repository.create(imp);
        dto.setId(imp.getId());
        
    }
    
    public void update(ImprovementDto dto) {
        repository.update(translate(dto));
        
    }
    
    public void delete(ImprovementDto dto) {
        repository.delete(translate(dto));
        
    }
    
    public ImprovementDto getById(Long id) {
        return translate(repository.getById(id));
    }
    
    public List<ImprovementDto> getAll() {
        return repository.getAll().stream().map(e -> translate(e)).collect(Collectors.toList());
    }
}