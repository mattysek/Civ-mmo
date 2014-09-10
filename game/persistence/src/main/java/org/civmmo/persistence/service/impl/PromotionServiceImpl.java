package org.civmmo.persistence.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.civmmo.contracts.model.PromotionDto;
import org.civmmo.contracts.services.persistence.PromotionService;
import org.civmmo.persistence.model.Promotion;
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
        return translate(repository.getById(id));
    }
    
    public List<PromotionDto> getAll() {
        return repository.getAll().stream().map(e -> translate(e)).collect(Collectors.toList());
    }
    
    @Override
    public List<PromotionDto> getAllSQL() {
        return repository.getAllUsingSQL().stream().map(e -> translate(e)).collect(Collectors.toList());
    }

    @Override
    public List<PromotionDto> getAllMongo() {
        return repository.getAllUsingMongo().stream().map(e -> translate(e)).collect(Collectors.toList());
    }

    @Override
    public List<PromotionDto> getAllNeo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public PromotionDto getByIdSQL(long id) {
        return translate(repository.getByIdUsingSQL(id));
    }

    @Override
    public PromotionDto getByIdMongo(long id) {
        return translate(repository.getByIdUsingMongo(id));
    }

    @Override
    public PromotionDto getByIdNeo(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PromotionDto> testGetListNativeQuery(String query) {
        return repository.getResultListOfNativeQuery(query)
                         .stream().map(e -> translate(e)).collect(Collectors.toList());     
    }

    @Override
    public PromotionDto testGetSingleNativeQuery(String query) {
        return translate(repository.getSingleResultOfNativeQuery(query)); 
    }
}
