package org.civmmo.persistence.repository.impl.test;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.inject.Inject;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;
import org.civmmo.model.Action;
import org.civmmo.persistence.model.ActionEntity;
import org.civmmo.persistence.repository.ActionRepository;
import org.civmmo.persistence.repository.impl.ActionRepositoryImpl;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.engine.transaction.jta.platform.spi.JtaPlatform;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class ActionRepositoryOgmNeoTest {

    @Deployment
    public static Archive<?> createTestArchive() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addPackage(Action.class.getPackage())
                .addPackage(ActionRepository.class.getPackage())
                .addPackage(ActionRepositoryImpl.class.getPackage())
                .addAsResource("META-INF/test-persistence-ogm-neo.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/jboss-deployment-structure.xml", "jboss-deployment-structure.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    private Action action;

    @Inject
    ActionRepository repository;
    
    @PersistenceUnit 
    EntityManagerFactory emf;
    
    @PersistenceContext
    EntityManager em;
    
    private static TransactionManager extractJBossTransactionManager(EntityManagerFactory factory) {
    SessionFactoryImplementor sessionFactory =
        (SessionFactoryImplementor) ( (HibernateEntityManagerFactory) factory ).getSessionFactory();
    return sessionFactory.getServiceRegistry().getService( JtaPlatform.class ).retrieveTransactionManager();
}
    
    @Test
    public void testCreate() {
        try {
            TransactionManager tm = extractJBossTransactionManager(emf);
            tm.begin();
            EntityManager em2 = emf.createEntityManager();
            action = this.getAction();
            //repository.create(action);
            System.out.println("-----------------------------------------------" + action.getId());
            em2.persist(action);
            System.out.println("-----------------------------------------------" + action.getId());
            tm.commit();
            System.out.println("-----------------------------------------------" + action.getId());
            assertNotNull(action.getId());
        } catch (NotSupportedException ex) {
            System.out.println("chybachybachyba");
        } catch (SystemException ex) {
            System.out.println("chybachybachyba2222222222222");
        } catch (RollbackException ex) {
            System.out.println("chybachybachyba33333333333332");
        } catch (HeuristicMixedException ex) {
            System.out.println("chybachybachyba254444444444444444444444222");
        } catch (HeuristicRollbackException ex) {
            System.out.println("chybachybachyba222255555555555555555555555555555555522222");
        } catch (SecurityException ex) {
            System.out.println("chybachybachyba2226666666666666666666622222");
        } catch (IllegalStateException ex) {
            System.out.println("chybachybachyba2222777777777777777777777777222");
        }

    }

//    @Test
//    public void testGetById() {
//        action = this.getAction();
//        repository.create(action);
//        Long id = action.getId();
//
//        Action fromDB = repository.getById(id);
//
//        assertEquals(action, fromDB);
//    }
//
//    @Test
//    public void testDelete() {
//        action = this.getAction();
//        repository.create(action);
//        Long id = action.getId();
//
//        repository.delete(action);
//
//        Action fromDB = repository.getById(id);
//
//        assertNull(fromDB);
//    }
//
//    @Test
//    public void testUpdate() {
//        action = this.getAction();
//        repository.create(action);
//
//        action.setName("new name");
//        Long id = action.getId();
//
//        Action check = repository.getById(id);
//
//        assertEquals("new name", check.getName());
//    }
//
//    @Test
//    public void testGetAll() {
//        action = this.getAction();
//        repository.create(action);
//        Action another = this.getAction();
//        repository.create(another);
//                
//        List<Long> result = repository.getAll().stream()
//                                      .map(e -> e.getId()).collect(Collectors.toList());
//        
//        assertTrue(result.contains(action.getId()) && result.contains(another.getId()));
//    }

    public Action getAction() {
        Action a = new ActionEntity();
        a.setName("Fortify");
        return a;
    }

}
