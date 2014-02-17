package com.redhat.civ.dao.implementation;

import com.redhat.civ.dao.interfaces.CivilizationDao;
import com.redhat.civ.entities.Civilization;

public class CivilizationDaoImpl extends BaseDaoImpl<Civilization> implements
		CivilizationDao {

	@Override
	protected boolean isValid(Civilization object) {
		// TODO Auto-generated method stub
		return true;
	}

}
