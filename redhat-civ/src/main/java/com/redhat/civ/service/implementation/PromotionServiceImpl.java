package com.redhat.civ.service.implementation;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.redhat.civ.dao.interfaces.PromotionDao;
import com.redhat.civ.dto.PromotionDto;
import com.redhat.civ.dto.DtoFactory;
import com.redhat.civ.entities.Promotion;
import com.redhat.civ.service.interfaces.PromotionService;

@Stateless
public class PromotionServiceImpl implements PromotionService {

	@Inject
	private PromotionDao dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void create(PromotionDto dto) {
		dao.create(DtoFactory.CreateDto(Promotion.class, dto));

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(PromotionDto dto) {
		dao.update(DtoFactory.CreateDto(Promotion.class, dto));

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(PromotionDto dto) {
		dao.delete(DtoFactory.CreateDto(Promotion.class, dto));

	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public PromotionDto getById(Long id) {
		return DtoFactory.CreateDto(PromotionDto.class, dao.getById(id));
	}
}
