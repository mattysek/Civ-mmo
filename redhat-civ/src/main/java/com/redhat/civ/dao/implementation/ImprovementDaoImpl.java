package com.redhat.civ.dao.implementation;

import com.redhat.civ.dao.interfaces.ImprovementDao;
import com.redhat.civ.entities.Improvement;

public class ImprovementDaoImpl extends BaseDaoImpl<Improvement> implements
		ImprovementDao {

	@Override
	protected boolean isValid(Improvement object) {
		// TODO Auto-generated method stub
		return true;
	}

}
