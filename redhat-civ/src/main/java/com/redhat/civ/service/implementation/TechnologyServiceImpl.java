package com.redhat.civ.service.implementation;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.redhat.civ.dao.interfaces.TechnologyDao;
import com.redhat.civ.dto.TechnologyDto;
import com.redhat.civ.dto.DtoFactory;
import com.redhat.civ.entities.Technology;
import com.redhat.civ.service.interfaces.TechnologyService;

@Stateless
public class TechnologyServiceImpl implements TechnologyService {

	@Inject
	private TechnologyDao dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void create(TechnologyDto dto) {
		dao.create(DtoFactory.CreateDto(Technology.class, dto));

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(TechnologyDto dto) {
		dao.update(DtoFactory.CreateDto(Technology.class, dto));

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(TechnologyDto dto) {
		dao.delete(DtoFactory.CreateDto(Technology.class, dto));

	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public TechnologyDto getById(Long id) {
		return DtoFactory.CreateDto(TechnologyDto.class, dao.getById(id));
	}
}
