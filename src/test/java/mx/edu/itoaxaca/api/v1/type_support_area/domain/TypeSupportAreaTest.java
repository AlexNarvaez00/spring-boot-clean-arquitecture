package mx.edu.itoaxaca.api.v1.type_support_area.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.shared.domain.WithTimestampsTest;
import mx.edu.itoaxaca.api.v1.type_support_area.infrastructure.persistence.PostgresTypeSupportArea;

import org.junit.jupiter.api.Test;

public class TypeSupportAreaTest {

    @Test
    void testCreateTypeSupportArea() {
        PostgresTypeSupportArea temp = TypeSupportAreaMother.random();
        assertNotNull(temp.getId());
    }

    @Test
    void testCreateTypeSupportAreaWithNullValue() {
        PostgresTypeSupportArea temp = new PostgresTypeSupportArea();
        assertNull(temp.getId());
    }

    @Test
    void testCompareTypeSupportArea() {
        PostgresTypeSupportArea temp = TypeSupportAreaMother.random();
        PostgresTypeSupportArea temp2 = temp;
        assertTrue(temp.equals(temp2));
        assertInstanceOf(Integer.class, temp2.hashCode());
    }

    @Test
    void testToString() {
        PostgresTypeSupportArea type_support_area = TypeSupportAreaMother.random();
        assertTrue(type_support_area.toString().contains(type_support_area.getId().toString()));
    }

    @Test
    void testNotCompareTypeSupportArea() {
        PostgresTypeSupportArea temp = TypeSupportAreaMother.random();
        PostgresTypeSupportArea temp2 = TypeSupportAreaMother.random();
        assertFalse(temp.equals(temp2));
    }

    @Test
    void testSettingValues() {
        PostgresTypeSupportArea type_support_area = new PostgresTypeSupportArea();

        UUID uuid = UUID.randomUUID();
        type_support_area.setId(uuid);
        assertInstanceOf(UUID.class, type_support_area.getId());
    }

    @Test
    void testTimestamps() {
        PostgresTypeSupportArea type_support_area = TypeSupportAreaMother.random();
        var type_support_areaAssert = new WithTimestampsTest<PostgresTypeSupportArea>();
        type_support_areaAssert.assertWithTimestamp(type_support_area);

        PostgresTypeSupportArea type_support_area2 = type_support_area;
        type_support_areaAssert.assertEqualsTimestamps(type_support_area, type_support_area2);
    }

}
