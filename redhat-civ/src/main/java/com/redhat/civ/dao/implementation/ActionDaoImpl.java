package com.redhat.civ.dao.implementation;

import com.redhat.civ.dao.interfaces.ActionDao;
import com.redhat.civ.entities.Action;

public class ActionDaoImpl extends BaseDaoImpl<Action> implements ActionDao {

	@Override
	protected boolean isValid(Action object) {
		// TODO Auto-generated method stub
		return true;
	}

}
