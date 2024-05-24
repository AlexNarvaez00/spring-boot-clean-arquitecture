package mx.edu.itoaxaca.api.v1.type_date.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.shared.domain.WithTimestampsTest;
import org.junit.jupiter.api.Test;

public class TypeDateTest {

    @Test
    void testCreateTypeDate() {
        TypeDate temp = TypeDateMother.random();
        assertNotNull(temp.getId());
    }

    @Test
    void testCreateTypeDateWithNullValue() {
        TypeDate temp = new TypeDate();
        assertNull(temp.getId());
    }

    @Test
    void testCompareTypeDate() {
        TypeDate temp = TypeDateMother.random();
        TypeDate temp2 = temp;
        assertTrue(temp.equals(temp2));
        assertInstanceOf(Integer.class, temp2.hashCode());
    }

    @Test
    void testToString() {
        TypeDate type_date = TypeDateMother.random();
        assertTrue(type_date.toString().contains(type_date.getId().toString()));
    }

    @Test
    void testNotCompareTypeDate() {
        TypeDate temp = TypeDateMother.random();
        TypeDate temp2 = TypeDateMother.random();
        assertFalse(temp.equals(temp2));
    }

    @Test
    void testSettingValues() {
        TypeDate type_date = new TypeDate();

        UUID uuid = UUID.randomUUID();
        type_date.setId(uuid);
        assertInstanceOf(UUID.class, type_date.getId());
    }

    @Test
    void testTimestamps() {
        TypeDate type_date = TypeDateMother.random();
        var type_dateAssert = new WithTimestampsTest<TypeDate>();
        type_dateAssert.assertWithTimestamp(type_date);

        TypeDate type_date2 = type_date;
        type_dateAssert.assertEqualsTimestamps(type_date, type_date2);
    }

}
