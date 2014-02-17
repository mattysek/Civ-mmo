package com.redhat.civ.dao.implementation;

import com.redhat.civ.dao.interfaces.PromotionDao;
import com.redhat.civ.entities.Promotion;

public class PromotionDaoImpl extends BaseDaoImpl<Promotion> implements
		PromotionDao {

	@Override
	protected boolean isValid(Promotion object) {
		// TODO Auto-generated method stub
		return true;
	}

}
