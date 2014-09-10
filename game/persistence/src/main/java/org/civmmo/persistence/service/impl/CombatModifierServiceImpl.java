package org.civmmo.persistence.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.civmmo.contracts.model.CombatModifierDto;
import org.civmmo.contracts.services.persistence.CombatModifierService;
import org.civmmo.persistence.model.CombatModifier;
import org.civmmo.persistence.repository.CombatModifierRepository;

@Stateless
public class CombatModifierServiceImpl extends BaseService implements CombatModifierService {

    @Inject
    private CombatModifierRepository repository;

    public void create(CombatModifierDto dto) {
        CombatModifier modifier = translate(dto);
        repository.create(modifier);
        dto.setId(modifier.getId());

    }

    public void update(CombatModifierDto dto) {
        repository.update(translate(dto));

    }

    public void delete(CombatModifierDto dto) {
        repository.delete(translate(dto));

    }

    public CombatModifierDto getById(Long id) {
        return translate(repository.getById(id));
    }
    
    public List<CombatModifierDto> getAll() {
        return repository.getAll().stream().map(e -> translate(e)).collect(Collectors.toList());
    }
    
    @Override
    public List<CombatModifierDto> getAllSQL() {
        return repository.getAllUsingSQL().stream().map(e -> translate(e)).collect(Collectors.toList());
    }

    @Override
    public List<CombatModifierDto> getAllMongo() {
        return repository.getAllUsingMongo().stream().map(e -> translate(e)).collect(Collectors.toList());
    }

    @Override
    public List<CombatModifierDto> getAllNeo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public CombatModifierDto getByIdSQL(long id) {
        return translate(repository.getByIdUsingSQL(id));
    }

    @Override
    public CombatModifierDto getByIdMongo(long id) {
        return translate(repository.getByIdUsingMongo(id));
    }

    @Override
    public CombatModifierDto getByIdNeo(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CombatModifierDto> testGetListNativeQuery(String query) {
        return repository.getResultListOfNativeQuery(query)
                         .stream().map(e -> translate(e)).collect(Collectors.toList());     
    }

    @Override
    public CombatModifierDto testGetSingleNativeQuery(String query) {
        return translate(repository.getSingleResultOfNativeQuery(query)); 
    }
}
