package org.civmmo.persistence.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import org.civmmo.contracts.model.CityDto;
import org.civmmo.contracts.model.PromotionDto;
import org.civmmo.contracts.model.TileDto;
import org.civmmo.contracts.model.UnitDto;
import org.civmmo.contracts.services.persistence.UnitService;
import org.civmmo.model.Unit;
import org.civmmo.persistence.repository.UnitRepository;
import org.civmmo.persistence.repository.impl.UnitRepositoryImpl;

@Stateless
public class UnitServiceImpl extends BaseService implements UnitService {

    private final UnitRepository repository = new UnitRepositoryImpl(GraphDatabaseServiceBean.getGraphDb());
    
    @Override
    public void create(UnitDto dto) {
        runInTransaction(() -> repository.create(translate(dto,TranslateOption.New)));
    }
    
    @Override
    public void update(UnitDto dto) {
        runInTransaction(() -> translate(dto, TranslateOption.GetById));
    }

    @Override
    public void delete(UnitDto dto) {
        runInTransaction(() -> {
            Unit action = repository.getById(dto.getId());
            repository.delete(action);
        });
    }

    @Override
    public UnitDto getById(Long id) {
        return runInTransaction(() -> translate(repository.getById(id)));
    }
    
    @Override
    public List<UnitDto> getAll() {
        return runInTransaction(() -> repository.getAll().stream().map(e -> translate(e)).collect(Collectors.toList()));
    }

    @Override
    public List<UnitDto> testGetListNativeQuery(String query) {
        return runInTransaction(() -> repository.getResultListOfNativeQuery(query)
                         .stream().map(e -> translate(e)).collect(Collectors.toList()));     
    }

    @Override
    public UnitDto testGetSingleNativeQuery(String query) {
        return runInTransaction(() -> translate(repository.getSingleResultOfNativeQuery(query))); 
    }

    @Override
    public void attackUnit(long unitId, long unit2Id) {
        runInTransaction(() -> {
            Unit unit = repository.getById(unitId);
            Unit unit2 = repository.getById(unit2Id);
            unit.attackUnit(unit2);
        });
    }

    @Override
    public void attackCity(long unitId, CityDto city) {
        runInTransaction(() -> {
            Unit unit = repository.getById(unitId);
            unit.attackCity(translate(city, TranslateOption.GetById));
        });
    }

    @Override
    public void promoteUnit(long unitId, PromotionDto promotion) {
        runInTransaction(() -> {
            Unit unit = repository.getById(unitId);
            unit.promoteUnit(translate(promotion, TranslateOption.GetById));
        });
    }

    @Override
    public void moveUnit(long unitId, TileDto tile) {
        runInTransaction(() -> {
            Unit unit = repository.getById(unitId);
            unit.moveUnit(translate(tile, TranslateOption.GetById));
        });
    }

}
