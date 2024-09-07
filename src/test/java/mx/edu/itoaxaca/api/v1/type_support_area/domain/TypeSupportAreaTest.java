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
        TypeSupportArea temp = TypeSupportAreaMother.random();
        assertNotNull(temp.id());
    }

    @Test
    void testCreateTypeSupportAreaWithNullValue() {
        TypeSupportArea temp = new TypeSupportArea(null, null);
        assertNull(temp.id());
    }

    @Test
    void testCompareTypeSupportArea() {
        TypeSupportArea temp = TypeSupportAreaMother.random();
        TypeSupportArea temp2 = temp;
        assertTrue(temp.equals(temp2));
        assertInstanceOf(Integer.class, temp2.hashCode());
    }

    @Test
    void testToString() {
        TypeSupportArea type_support_area = TypeSupportAreaMother.random();
        assertTrue(
            type_support_area
                .toString()
                .contains(type_support_area.id().toString())
        );
    }

    @Test
    void testNotCompareTypeSupportArea() {
        TypeSupportArea temp = TypeSupportAreaMother.random();
        TypeSupportArea temp2 = TypeSupportAreaMother.random();
        assertFalse(temp.equals(temp2));
    }

    @Test
    void testSettingValues() {
        UUID uuid = UUID.randomUUID();
        TypeSupportArea type_support_area = new TypeSupportArea(uuid, null);

        assertInstanceOf(UUID.class, type_support_area.id());
    }

    @Test
    void testTimestamps() {
        var temp = TypeSupportAreaMother.random();

        PostgresTypeSupportArea type_support_area = null;
        var type_support_areaAssert = new WithTimestampsTest<
            PostgresTypeSupportArea
        >();
        type_support_areaAssert.assertWithTimestamp(type_support_area);

        PostgresTypeSupportArea type_support_area2 = type_support_area;
        type_support_areaAssert.assertEqualsTimestamps(
            type_support_area,
            type_support_area2
        );
    }
}
