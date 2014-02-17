package com.redhat.civ;

import javax.inject.Inject;

import com.redhat.civ.dao.interfaces.TileDao;

/**
 * Hello world!
 *
 */
public class App 
{
	@Inject
	static TileDao dao;
    public static void main( String[] args )
    {
        System.out.println(dao);
    }
}
