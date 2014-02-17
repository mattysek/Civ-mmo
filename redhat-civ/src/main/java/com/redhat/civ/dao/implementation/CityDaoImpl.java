package com.redhat.civ.dao.implementation;

import com.redhat.civ.dao.interfaces.CityDao;
import com.redhat.civ.entities.City;

public class CityDaoImpl extends BaseDaoImpl<City> implements CityDao {

	@Override
	protected boolean isValid(City object) {
		// TODO Auto-generated method stub
		return true;
	}


}
