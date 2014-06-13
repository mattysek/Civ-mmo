package org.civmmo.persistence.service.impl.test;

import java.time.Duration;
import java.time.Instant;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.inject.Inject;
import org.civmmo.contracts.model.ActionDto;
import org.civmmo.contracts.model.BuildingDto;
import org.civmmo.contracts.model.CombatModifierDto;
import org.civmmo.contracts.model.UnitDto;
import org.civmmo.contracts.services.persistence.ActionService;
import org.civmmo.contracts.services.persistence.BuildingService;
import org.civmmo.persistence.model.Action;
import org.civmmo.persistence.repository.ActionRepository;
import org.civmmo.persistence.repository.impl.ActionRepositoryImpl;
import org.civmmo.persistence.service.impl.ActionServiceImpl;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.logging.Logger;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class DeleteOrmDerbyTest {

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

    private final static Logger LOGGER = Logger.getLogger("ogm-test-logger");
    private static String OPERATION = "";

    @Inject
    ActionService actionService;
    @Inject
    BuildingService buildingService;

    @Test
    public void testCreateOne() {
        OPERATION = "testCreateOne";

        ActionDto a = supplyActionDto();
        BuildingDto b = supplyBuildingDto();

        actionService.create(a);
        buildingService.create(b);
        
        b.setName(UUID.randomUUID().toString());
        
        runAndLogDuration(actionService::delete, a);
        runAndLogDuration(buildingService::delete, b);

        assertTrue(true);
    }

    @Test
    public void testCreateOneWithManySubentities() {
        OPERATION = "testCreateOneWithManySubentities";

        ActionDto a = supplyActionDto(100);
        BuildingDto b = supplyBuildingDto(100);
        
        actionService.create(a);
        buildingService.create(b);
        
        runAndLogDuration(actionService::delete, a);
        runAndLogDuration(buildingService::delete, b);

        assertTrue(true);
    }

    @Test
    public void testCreateMany() {
        OPERATION = "testCreateMany";
        long count = 100;

        Stream<ActionDto> actions = supplyListOfCount(count, this::supplyActionDto);
        actions.forEach(a -> actionService.create(a));
        Stream<BuildingDto> buildings = supplyListOfCount(count, this::supplyBuildingDto);
        buildings.forEach(a -> buildingService.create(a));
        
        actions.forEach(a -> runAndLogDuration(actionService::delete, a));
        buildings.forEach(a -> runAndLogDuration(buildingService::delete, a));
    }

    private <T> void runAndLogDuration(Consumer<T> consumer, T consumable) {
        Instant start = Instant.now();
        consumer.accept(consumable);
        Instant end = Instant.now();
        LOGGER.debug(OPERATION + " " + consumable.getClass().getName() + ": " + Duration.between(start, end));
    }

    private <T> Stream<T> supplyListOfCount(long count, Supplier<T> supplier) {
        return Stream.generate(supplier).limit(count);
    }

    private ActionDto supplyActionDto() {
        return supplyActionDto(0);
    }

    private ActionDto supplyActionDto(long listCount) {
        ActionDto result = new ActionDto();

        result.setName(UUID.randomUUID().toString());
        result.setAplicableTo(supplyListOfCount(listCount, this::supplyUnitDto)
                .collect(Collectors.toList()));
        result.setCombatModifiers(supplyListOfCount(listCount, this::supplyCombatModifierDto)
                .collect(Collectors.toList()));

        return result;
    }

    private BuildingDto supplyBuildingDto() {
        return supplyBuildingDto(0);
    }

    private BuildingDto supplyBuildingDto(long listCount) {
        BuildingDto result = new BuildingDto();
        result.setName(UUID.randomUUID().toString());
        result.setCost(800);
        result.setMaintenence(20);
        result.setSpecialistsSlots(3);
//        set(result::setCurrentlyConstructedBy,
//                object::getCurrentlyConstructedBy,
//                e -> translate(e));
//        set(result::setRequiredResources,
//                object::getRequiredResources,
//                e -> translate(e));
//        set(result::setRequiredTechnologies,
//                object::getRequiredTechnologies,
//                e -> translate(e));
//        set(result::setWorkedBy,
//                object::getWorkedBy,
//                e -> translate(e));

        return result;
    }

    private UnitDto supplyUnitDto() {
        UnitDto result = new UnitDto();

//        set(result::setActions,
//                object::getActions,
//                e -> translate(e));
        result.setCombatStrength(10);
//        set(result::setControledTiles,
//                object::getControledTiles,
//                e -> translate(e));
        result.setCost(500);
//        set(result::setCurrentlyConstructedBy,
//                object::getCurrentlyConstructedBy,
//                e -> translate(e));
        result.setExperience(100);
        result.setHitPoints(20);
        result.setMovementPoints(5);
        result.setName(UUID.randomUUID().toString());
//        result.setOwnedBy(translate(object.getOwnedBy()));
//        result.setPosition(translate(object.getPosition()));
//        set(result::setPromotions,
//                object::getPromotions,
//                e -> translate(e));
        result.setRange(1);
        result.setRangedCombatStrength(0);
//        set(result::setTypes,
//                object::getTypes,
//                e -> translate(e));
//        set(result::setVisibleTiles,
//                object::getVisibleTiles,
//                e -> translate(e));
        return result;
    }

    private CombatModifierDto supplyCombatModifierDto() {
        CombatModifierDto result = new CombatModifierDto();

        result.setValue(2);

        return result;
    }
}
