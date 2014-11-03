package org.civmmo.persistence.repository.impl.test;

import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.civmmo.model.Action;
import org.civmmo.persistence.model.ActionEntity;
import org.civmmo.persistence.repository.ActionRepository;
import org.civmmo.persistence.repository.impl.ActionRepositoryImpl;
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
public class ActionRepositoryOrmPostgreTest {

    @Deployment
    public static Archive<?> createTestArchive() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addPackage(Action.class.getPackage())
                .addPackage(ActionRepository.class.getPackage())
                .addPackage(ActionRepositoryImpl.class.getPackage())
                .addAsResource("META-INF/test-persistence-postgresql.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/jboss-deployment-structure.xml", "jboss-deployment-structure.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    private Action action;

    @Inject
    ActionRepository repository;

    @Inject
    UserTransaction utx;

    @PersistenceContext
    EntityManager em;

    @Before
    public void preparePersistenceTest() {
        startTransaction();
    }

    @After
    public void commitTransaction() {
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
    public void testCreate() {
        action = this.getAction();
        repository.create(action);
        assertNotNull(action.getId());

    }

    @Test
    public void testGetById() {
        action = this.getAction();
        repository.create(action);
        Long id = action.getId();

        Action fromDB = repository.getById(id);

        assertEquals(action, fromDB);
    }

    @Test
    public void testDelete() {
        action = this.getAction();
        repository.create(action);
        Long id = action.getId();

        repository.delete(action);

        Action fromDB = repository.getById(id);

        assertNull(fromDB);
    }

    @Test
    public void testUpdate() {
        action = this.getAction();
        repository.create(action);

        action.setName("new name");
        Long id = action.getId();

        Action check = repository.getById(id);

        assertEquals("new name", check.getName());
    }

    @Test
    public void testGetAll() {
        action = this.getAction();
        repository.create(action);
        Action another = this.getAction();
        repository.create(another);
                
        List<Long> result = repository.getAll().stream()
                                      .map(e -> e.getId()).collect(Collectors.toList());
        
        assertTrue(result.contains(action.getId()) && result.contains(another.getId()));
    }

    public Action getAction() {
        Action a = new ActionEntity();
        a.setName("Fortify");
        return a;
    }

}
