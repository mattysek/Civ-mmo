package org.civmmo.persistence.service.impl.test;

import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import org.civmmo.contracts.model.ActionDto;
import org.civmmo.contracts.services.persistence.ActionService;
import org.civmmo.model.Action;
import org.civmmo.persistence.repository.ActionRepository;
import org.civmmo.persistence.repository.impl.ActionRepositoryImpl;
import org.civmmo.persistence.service.impl.ActionServiceImpl;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class ActionServiceOrmDerbyTest {

    @Deployment
    public static Archive<?> createTestArchive() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addPackage(Action.class.getPackage())
                .addPackage(ActionRepository.class.getPackage())
                .addPackage(ActionRepositoryImpl.class.getPackage())
                .addPackage(ActionServiceImpl.class.getPackage())
                .addPackage(ActionService.class.getPackage())
                .addPackage(ActionDto.class.getPackage())
                .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/jboss-deployment-structure.xml", "jboss-deployment-structure.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Inject
    ActionService service;

    @Test
    public void testCreate() {
        ActionDto action = this.getAction("name create");
        service.create(action);
        assertNotNull(action.getId());
    }

    @Test
    public void testGetById() {
        ActionDto action = getAction("name getbyid");
        service.create(action);
        ActionDto fromDB = service.getById(action.getId());

        assertEquals(action.getName(), fromDB.getName());
    }

    @Test
    public void testDelete() {
        ActionDto action = getAction("name delete");
        service.create(action);

        Long id = action.getId();
        service.delete(action);

        assertNull(service.getById(id));
    }

    @Test
    public void testUpdate() {
        ActionDto action = getAction("name update");
        service.create(action);

        action.setName("new name");

        service.update(action);
        
        ActionDto check = service.getById(action.getId());

        assertEquals("new name", check.getName());
    }
    
    @Test
    public void testGetAll() {
        ActionDto action = getAction("name getall 1");
        service.create(action);
        ActionDto another = getAction("name getall 2");
        service.create(another);
        System.out.println(service.getById(another.getId()).getName());
        
        List<Long> result = service.getAll().stream()
                                   .map(e -> e.getId()).collect(Collectors.toList());
        
        assertTrue(result.contains(action.getId()) && result.contains(another.getId()));
    }

    private ActionDto getAction(String name) {
        ActionDto a = new ActionDto();
        a.setName(name);
        return a;
    }

}
