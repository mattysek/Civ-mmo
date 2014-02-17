package com.redhat.civ.dao.implementation.test;



import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import com.redhat.civ.dao.implementation.ActionDaoImpl;
import com.redhat.civ.dao.interfaces.ActionDao;
import com.redhat.civ.entities.*;


@RunWith(Arquillian.class)
public class ActionDaoTest {
	@Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
        		.addPackage(Action.class.getPackage())
        		.addPackage(ActionDao.class.getPackage())
        		.addPackage(ActionDaoImpl.class.getPackage())
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
            .addAsManifestResource("META-INF/MANIFEST.MF")
            .addAsResource("META-INF/test-orm-persistence.xml", "META-INF/persistence.xml");
    }
	private Action action;

	@PersistenceContext
	EntityManager em;
	
	@Inject
    UserTransaction utx;
	
	@Inject
	ActionDao dao;
	    
	@Before
	public void preparePersistenceTest(){
	    startTransaction();
	}

	@After
	public void commitTransaction(){
	    try {
			utx.commit();
			em.clear();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void startTransaction() {
	    try {
			utx.begin();
			em.joinTransaction();
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	}
	
	@Test
    public void testCreate()
    {
    	action = this.getAction();
    	dao.create(action);
        assertNotNull(action.getId());
        
    }
	
	@Test
	public void testGetById(){
		action = this.getAction();
		dao.create(action);
		Long id = action.getId();
		
		Action fromDB = dao.getById(id);
		
		assertEquals(action,fromDB);
	}
	
	@Test
	public void testDelete(){
		action = this.getAction();
		dao.create(action);
		Long id = action.getId();
		
		dao.delete(action);
		
		Action fromDB = dao.getById(id);
		
		assertNull(fromDB);
	}
    
	@Test
	public void testUpdate(){
		action = this.getAction();
		dao.create(action);
		
		action.setName("new name");
		Long id = action.getId();
		
		Action check = dao.getById(id);
		
		assertEquals("new name", check.getName());
	}
	
	@Test
	public void testGetAll(){
		action = this.getAction();
		dao.create(action);
		Action another = this.getAction();
		dao.create(another);
		assertTrue(dao.getAll().contains(action)&&dao.getAll().contains(another));
	}
    
    public Action getAction(){
    	Action  a  = new Action();
    	a.setName("Fortify");
    	return a;
    }
    
	
}
