package org.civmmo.persistence.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.civmmo.contracts.model.PromotionDto;
import org.civmmo.contracts.services.persistence.PromotionService;
import org.civmmo.model.Promotion;
import org.civmmo.persistence.repository.PromotionRepository;

@Stateless
public class PromotionServiceImpl extends BaseService implements PromotionService {
    
    @Inject
    private PromotionRepository repository;
    
    public void create(PromotionDto dto) {
        Promotion promo = translate(dto);
        repository.create(promo);
        dto.setId(promo.getId());
        
    }
    
    public void update(PromotionDto dto) {
        repository.update(translate(dto));
        
    }
    
    public void delete(PromotionDto dto) {
        repository.delete(translate(dto));
        
    }
    
    public PromotionDto getById(Long id) {
        return translate(repository.getById(id),START_LEVEL);
    }
    
    public List<PromotionDto> getAll() {
        return repository.getAll().stream().map(e -> translate(e,START_LEVEL)).collect(Collectors.toList());
    }
    
    @Override
    public List<PromotionDto> testGetListNativeQuery(String query) {
        return repository.getResultListOfNativeQuery(query)
                         .stream().map(e -> translate(e,START_LEVEL)).collect(Collectors.toList());     
    }

    @Override
    public PromotionDto testGetSingleNativeQuery(String query) {
        return translate(repository.getSingleResultOfNativeQuery(query),START_LEVEL); 
    }
}
