package mx.edu.itoaxaca.api.v1.shedule.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.shared.domain.WithTimestampsTest;
import org.junit.jupiter.api.Test;

public class SheduleTest {

    @Test
    void testCreateShedule() {
        Shedule temp = SheduleMother.random();
        assertNotNull(temp.getId());
    }

    @Test
    void testCreateSheduleWithNullValue() {
        Shedule temp = new Shedule();
        assertNull(temp.getId());
    }

    @Test
    void testCompareShedule() {
        Shedule temp = SheduleMother.random();
        Shedule temp2 = temp;
        assertTrue(temp.equals(temp2));
        assertInstanceOf(Integer.class, temp2.hashCode());
    }

    @Test
    void testToString() {
        Shedule shedule = SheduleMother.random();
        assertTrue(shedule.toString().contains(shedule.getId().toString()));
    }

    @Test
    void testNotCompareShedule() {
        Shedule temp = SheduleMother.random();
        Shedule temp2 = SheduleMother.random();
        assertFalse(temp.equals(temp2));
    }

    @Test
    void testSettingValues() {
        Shedule shedule = new Shedule();

        UUID uuid = UUID.randomUUID();
        shedule.setId(uuid);
        assertInstanceOf(UUID.class, shedule.getId());
    }

    @Test
    void testTimestamps() {
        Shedule shedule = SheduleMother.random();
        var sheduleAssert = new WithTimestampsTest<Shedule>();
        sheduleAssert.assertWithTimestamp(shedule);

        Shedule shedule2 = shedule;
        sheduleAssert.assertEqualsTimestamps(shedule, shedule2);
    }

}
