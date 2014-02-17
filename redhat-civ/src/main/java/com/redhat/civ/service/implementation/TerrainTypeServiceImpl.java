package com.redhat.civ.service.implementation;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.redhat.civ.dao.interfaces.TerrainTypeDao;
import com.redhat.civ.dto.TerrainTypeDto;
import com.redhat.civ.dto.DtoFactory;
import com.redhat.civ.entities.TerrainType;
import com.redhat.civ.service.interfaces.TerrainTypeService;

@Stateless
public class TerrainTypeServiceImpl implements TerrainTypeService {

	@Inject
	private TerrainTypeDao dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void create(TerrainTypeDto dto) {
		dao.create(DtoFactory.CreateDto(TerrainType.class, dto));

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(TerrainTypeDto dto) {
		dao.update(DtoFactory.CreateDto(TerrainType.class, dto));

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(TerrainTypeDto dto) {
		dao.delete(DtoFactory.CreateDto(TerrainType.class, dto));

	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public TerrainTypeDto getById(Long id) {
		return DtoFactory.CreateDto(TerrainTypeDto.class, dao.getById(id));
	}
}
