package com.redhat.civ.service.implementation;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.redhat.civ.dao.interfaces.PolicyDao;
import com.redhat.civ.dto.PolicyDto;
import com.redhat.civ.dto.DtoFactory;
import com.redhat.civ.entities.Policy;
import com.redhat.civ.service.interfaces.PolicyService;

@Stateless
public class PolicyServiceImpl implements PolicyService {

	@Inject
	private PolicyDao dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void create(PolicyDto dto) {
		dao.create(DtoFactory.CreateDto(Policy.class, dto));

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(PolicyDto dto) {
		dao.update(DtoFactory.CreateDto(Policy.class, dto));

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(PolicyDto dto) {
		dao.delete(DtoFactory.CreateDto(Policy.class, dto));

	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public PolicyDto getById(Long id) {
		return DtoFactory.CreateDto(PolicyDto.class, dao.getById(id));
	}
}
