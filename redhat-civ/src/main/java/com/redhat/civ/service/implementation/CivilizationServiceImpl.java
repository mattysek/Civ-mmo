package com.redhat.civ.service.implementation;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.redhat.civ.dao.interfaces.CivilizationDao;
import com.redhat.civ.dto.CivilizationDto;
import com.redhat.civ.dto.DtoFactory;
import com.redhat.civ.entities.Civilization;
import com.redhat.civ.service.interfaces.CivilizationService;

@Stateless
public class CivilizationServiceImpl implements CivilizationService {

	@Inject
	private CivilizationDao dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void create(CivilizationDto dto) {
		dao.create(DtoFactory.CreateDto(Civilization.class, dto));

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(CivilizationDto dto) {
		dao.update(DtoFactory.CreateDto(Civilization.class, dto));

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(CivilizationDto dto) {
		dao.delete(DtoFactory.CreateDto(Civilization.class, dto));

	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public CivilizationDto getById(Long id) {
		return DtoFactory.CreateDto(CivilizationDto.class, dao.getById(id));
	}
}
