package com.redhat.civ.service.implementation;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.redhat.civ.dao.interfaces.TerrainFeatureDao;
import com.redhat.civ.dto.TerrainFeatureDto;
import com.redhat.civ.dto.DtoFactory;
import com.redhat.civ.entities.TerrainFeature;
import com.redhat.civ.service.interfaces.TerrainFeatureService;

@Stateless
public class TerrainFeatureServiceImpl implements TerrainFeatureService {

	@Inject
	private TerrainFeatureDao dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void create(TerrainFeatureDto dto) {
		dao.create(DtoFactory.CreateDto(TerrainFeature.class, dto));

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(TerrainFeatureDto dto) {
		dao.update(DtoFactory.CreateDto(TerrainFeature.class, dto));

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(TerrainFeatureDto dto) {
		dao.delete(DtoFactory.CreateDto(TerrainFeature.class, dto));

	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public TerrainFeatureDto getById(Long id) {
		return DtoFactory.CreateDto(TerrainFeatureDto.class, dao.getById(id));
	}
}
