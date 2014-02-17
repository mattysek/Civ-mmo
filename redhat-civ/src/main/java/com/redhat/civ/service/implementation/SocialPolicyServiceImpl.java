package com.redhat.civ.service.implementation;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.redhat.civ.dao.interfaces.SocialPolicyDao;
import com.redhat.civ.dto.SocialPolicyDto;
import com.redhat.civ.dto.DtoFactory;
import com.redhat.civ.entities.SocialPolicy;
import com.redhat.civ.service.interfaces.SocialPolicyService;

@Stateless
public class SocialPolicyServiceImpl implements SocialPolicyService {

	@Inject
	private SocialPolicyDao dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void create(SocialPolicyDto dto) {
		dao.create(DtoFactory.CreateDto(SocialPolicy.class, dto));

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(SocialPolicyDto dto) {
		dao.update(DtoFactory.CreateDto(SocialPolicy.class, dto));

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(SocialPolicyDto dto) {
		dao.delete(DtoFactory.CreateDto(SocialPolicy.class, dto));

	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public SocialPolicyDto getById(Long id) {
		return DtoFactory.CreateDto(SocialPolicyDto.class, dao.getById(id));
	}
}
