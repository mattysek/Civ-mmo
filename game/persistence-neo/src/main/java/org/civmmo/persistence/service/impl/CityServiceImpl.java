package org.civmmo.persistence.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import org.civmmo.contracts.model.BuildingDto;
import org.civmmo.contracts.model.CityDto;
import org.civmmo.contracts.model.TileDto;
import org.civmmo.contracts.model.UnitDto;
import org.civmmo.contracts.services.persistence.CityService;
import org.civmmo.model.City;
import org.civmmo.persistence.repository.CityRepository;
import org.civmmo.persistence.repository.impl.CityRepositoryImpl;

@Stateless
public class CityServiceImpl extends BaseService implements CityService {
    
    private final CityRepository repository = new CityRepositoryImpl(GraphDatabaseServiceBean.getGraphDb());
    
    @Override
    public void create(CityDto dto) {
        runInTransaction(() -> repository.create(translate(dto,TranslateOption.New)));
    }
    
    @Override
    public void update(CityDto dto) {
        runInTransaction(() -> translate(dto, TranslateOption.GetById));
    }

    @Override
    public void delete(CityDto dto) {
        runInTransaction(() -> {
            City action = repository.getById(dto.getId());
            repository.delete(action);
        });
    }

    @Override
    public CityDto getById(Long id) {
        return runInTransaction(() -> translate(repository.getById(id),START_LEVEL));
    }
    
    @Override
    public List<CityDto> getAll() {
        return runInTransaction(() -> repository.getAll().stream().map(e -> translate(e,START_LEVEL)).collect(Collectors.toList()));
    }

    @Override
    public List<CityDto> testGetListNativeQuery(String query) {
        return runInTransaction(() -> repository.getResultListOfNativeQuery(query)
                         .stream().map(e -> translate(e,START_LEVEL)).collect(Collectors.toList()));     
    }

    @Override
    public CityDto testGetSingleNativeQuery(String query) {
        return runInTransaction(() -> translate(repository.getSingleResultOfNativeQuery(query),START_LEVEL)); 
    }

    @Override
    public void constructBuilding(long cityId, BuildingDto building) {
        runInTransaction(() -> {
                City city = repository.getById(cityId);
                city.constructBuilding(translate(building,TranslateOption.GetById));
            });
    }

    @Override
    public void workBuilding(long cityId, BuildingDto building) {
        runInTransaction(() -> {
            City city = repository.getById(cityId);
            city.workBuilding(translate(building,TranslateOption.GetById));
        });
    }

    @Override
    public void constructUnit(long cityId, UnitDto unit) {
        runInTransaction(() -> {
            City city = repository.getById(cityId);
            city.constructUnit(translate(unit,TranslateOption.GetById));
        });
    }

    @Override
    public boolean hasTradeRouteWith(long cityId, long city2Id) {
        return runInTransaction(() -> {
            City city = repository.getById(cityId);
            City city2 = repository.getById(city2Id);
            return city.hasTradeRouteWith(city2);
        });
    }

    @Override
    public void controlTile(long cityId, TileDto tile) {
        runInTransaction(() -> {
            City city = repository.getById(cityId);
            city.controlTile(translate(tile,TranslateOption.GetById));
        });
    }

    @Override
    public void workTile(long cityId, TileDto tile) {
        runInTransaction(() -> {
            City city = repository.getById(cityId);
            city.workTile(translate(tile,TranslateOption.GetById));
        });
    }

    @Override
    public void attackUnit(long cityId, UnitDto unit) {
        runInTransaction(() -> {
            City city = repository.getById(cityId);
            city.attackUnit(translate(unit,TranslateOption.GetById));
        });
    }

    @Override
    public CityDto computeWealthGrowth(long cityId) {
        return runInTransaction(() -> {
            City city = repository.getById(cityId);
            city.computeWealthGrowth();
            return translate(city,START_LEVEL);
        });
    }
}
