package mx.edu.itoaxaca.api.v1.workshop.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.shared.domain.WithTimestampsTest;
import org.junit.jupiter.api.Test;

public class WorkshopTest {

    @Test
    void testCreateWorkshop() {
        Workshop temp = WorkshopMother.random();
        assertNotNull(temp.getId());
    }

    @Test
    void testCreateWorkshopWithNullValue() {
        Workshop temp = new Workshop();
        assertNull(temp.getId());
    }

    @Test
    void testCompareWorkshop() {
        Workshop temp = WorkshopMother.random();
        Workshop temp2 = temp;
        assertTrue(temp.equals(temp2));
        assertInstanceOf(Integer.class, temp2.hashCode());
    }

    @Test
    void testToString() {
        Workshop workshop = WorkshopMother.random();
        assertTrue(workshop.toString().contains(workshop.getId().toString()));
    }

    @Test
    void testNotCompareWorkshop() {
        Workshop temp = WorkshopMother.random();
        Workshop temp2 = WorkshopMother.random();
        assertFalse(temp.equals(temp2));
    }

    @Test
    void testSettingValues() {
        Workshop workshop = new Workshop();

        UUID uuid = UUID.randomUUID();
        workshop.setId(uuid);
        assertInstanceOf(UUID.class, workshop.getId());
    }

    @Test
    void testTimestamps() {
        Workshop workshop = WorkshopMother.random();
        var workshopAssert = new WithTimestampsTest<Workshop>();
        workshopAssert.assertWithTimestamp(workshop);

        Workshop workshop2 = workshop;
        workshopAssert.assertEqualsTimestamps(workshop, workshop2);
    }

}
