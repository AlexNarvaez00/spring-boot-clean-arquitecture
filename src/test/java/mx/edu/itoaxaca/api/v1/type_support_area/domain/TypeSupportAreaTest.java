package mx.edu.itoaxaca.api.v1.type_support_area.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.shared.domain.WithTimestampsTest;
import org.junit.jupiter.api.Test;

public class TypeSupportAreaTest {

    @Test
    void testCreateTypeSupportArea() {
        TypeSupportArea temp = TypeSupportAreaMother.random();
        assertNotNull(temp.getId());
    }

    @Test
    void testCreateTypeSupportAreaWithNullValue() {
        TypeSupportArea temp = new TypeSupportArea();
        assertNull(temp.getId());
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
        assertTrue(type_support_area.toString().contains(type_support_area.getId().toString()));
    }

    @Test
    void testNotCompareTypeSupportArea() {
        TypeSupportArea temp = TypeSupportAreaMother.random();
        TypeSupportArea temp2 = TypeSupportAreaMother.random();
        assertFalse(temp.equals(temp2));
    }

    @Test
    void testSettingValues() {
        TypeSupportArea type_support_area = new TypeSupportArea();

        UUID uuid = UUID.randomUUID();
        type_support_area.setId(uuid);
        assertInstanceOf(UUID.class, type_support_area.getId());
    }

    @Test
    void testTimestamps() {
        TypeSupportArea type_support_area = TypeSupportAreaMother.random();
        var type_support_areaAssert = new WithTimestampsTest<TypeSupportArea>();
        type_support_areaAssert.assertWithTimestamp(type_support_area);

        TypeSupportArea type_support_area2 = type_support_area;
        type_support_areaAssert.assertEqualsTimestamps(type_support_area, type_support_area2);
    }

}
