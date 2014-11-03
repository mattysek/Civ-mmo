package org.civmmo.persistence.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.civmmo.contracts.model.CityDto;
import org.civmmo.contracts.model.PromotionDto;
import org.civmmo.contracts.model.TileDto;
import org.civmmo.contracts.model.UnitDto;
import org.civmmo.contracts.services.persistence.UnitService;
import org.civmmo.model.Unit;
import org.civmmo.persistence.repository.UnitRepository;

@Stateless
public class UnitServiceImpl extends BaseService implements UnitService {

    @Inject
    private UnitRepository repository;

    public void create(UnitDto dto) {
        Unit unit = translate(dto);
        repository.create(unit);
        dto.setId(unit.getId());

    }

    public void update(UnitDto dto) {
        repository.update(translate(dto));

    }

    public void delete(UnitDto dto) {
        repository.delete(translate(dto));

    }

    public UnitDto getById(Long id) {
        return translate(repository.getById(id));
    }
    
    public List<UnitDto> getAll() {
        return repository.getAll().stream().map(e -> translate(e)).collect(Collectors.toList());
    }
    
    @Override
    public List<UnitDto> testGetListNativeQuery(String query) {
        return repository.getResultListOfNativeQuery(query)
                         .stream().map(e -> translate(e)).collect(Collectors.toList());     
    }

    @Override
    public UnitDto testGetSingleNativeQuery(String query) {
        return translate(repository.getSingleResultOfNativeQuery(query)); 
    }

    @Override
    public void attackUnit(long unitId, long unit2Id) {
        Unit unit = repository.getById(unitId);
        Unit unit2 = repository.getById(unit2Id);
        unit.attackUnit(unit2);
        repository.update(unit);
        repository.update(unit2);
        
    }

    @Override
    public void attackCity(long unitId, CityDto city) {
        Unit unit = repository.getById(unitId);
        unit.attackCity(translate(city));
        repository.update(unit);
    }

    @Override
    public void promoteUnit(long unitId, PromotionDto promotion) {
        Unit unit = repository.getById(unitId);
        unit.promoteUnit(translate(promotion));
        repository.update(unit);
    }

    @Override
    public void moveUnit(long unitId, TileDto tile) {
        Unit unit = repository.getById(unitId);
        unit.moveUnit(translate(tile));
        repository.update(unit);
    }

}
