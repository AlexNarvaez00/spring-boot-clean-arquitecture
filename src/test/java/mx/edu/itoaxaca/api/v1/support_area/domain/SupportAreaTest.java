package mx.edu.itoaxaca.api.v1.support_area.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.shared.domain.WithTimestampsTest;
import org.junit.jupiter.api.Test;

public class SupportAreaTest {

    @Test
    void testCreateSupportArea() {
        SupportArea temp = SupportAreaMother.random();
        assertNotNull(temp.getId());
    }

    @Test
    void testCreateSupportAreaWithNullValue() {
        SupportArea temp = new SupportArea();
        assertNull(temp.getId());
    }

    @Test
    void testCompareSupportArea() {
        SupportArea temp = SupportAreaMother.random();
        SupportArea temp2 = temp;
        assertTrue(temp.equals(temp2));
        assertInstanceOf(Integer.class, temp2.hashCode());
    }

    @Test
    void testToString() {
        SupportArea support_area = SupportAreaMother.random();
        assertTrue(support_area.toString().contains(support_area.getId().toString()));
    }

    @Test
    void testNotCompareSupportArea() {
        SupportArea temp = SupportAreaMother.random();
        SupportArea temp2 = SupportAreaMother.random();
        assertFalse(temp.equals(temp2));
    }

    @Test
    void testSettingValues() {
        SupportArea support_area = new SupportArea();

        UUID uuid = UUID.randomUUID();
        support_area.setId(uuid);
        assertInstanceOf(UUID.class, support_area.getId());
    }

    @Test
    void testTimestamps() {
        SupportArea support_area = SupportAreaMother.random();
        var support_areaAssert = new WithTimestampsTest<SupportArea>();
        support_areaAssert.assertWithTimestamp(support_area);

        SupportArea support_area2 = support_area;
        support_areaAssert.assertEqualsTimestamps(support_area, support_area2);
    }

}
