package com.redhat.civ.service.implementation;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.redhat.civ.dao.interfaces.ImprovementDao;
import com.redhat.civ.dto.ImprovementDto;
import com.redhat.civ.dto.DtoFactory;
import com.redhat.civ.entities.Improvement;
import com.redhat.civ.service.interfaces.ImprovementService;

@Stateless
public class ImprovementServiceImpl implements ImprovementService {

	@Inject
	private ImprovementDao dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void create(ImprovementDto dto) {
		dao.create(DtoFactory.CreateDto(Improvement.class, dto));

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(ImprovementDto dto) {
		dao.update(DtoFactory.CreateDto(Improvement.class, dto));

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(ImprovementDto dto) {
		dao.delete(DtoFactory.CreateDto(Improvement.class, dto));

	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ImprovementDto getById(Long id) {
		return DtoFactory.CreateDto(ImprovementDto.class, dao.getById(id));
	}
}
