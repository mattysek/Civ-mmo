package com.redhat.civ.dao.implementation;

import com.redhat.civ.dao.interfaces.UnitDao;
import com.redhat.civ.entities.Unit;

public class UnitDaoImpl extends BaseDaoImpl<Unit> implements UnitDao {

	@Override
	protected boolean isValid(Unit object) {
		// TODO Auto-generated method stub
		return true;
	}

}
