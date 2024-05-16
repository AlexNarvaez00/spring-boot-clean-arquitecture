package mx.edu.itoaxaca.api.v1.period.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.shared.domain.ValueObject.DateValueObjectMother;
import mx.edu.itoaxaca.api.v1.shared.domain.WithTimestampsTest;
import org.junit.jupiter.api.Test;

public class PeriodTest {

    @Test
    void testCreatePeriod() {
        Period temp = PeriodMother.random(true);
        assertNotNull(temp.getId());
        assertNotNull(temp.getStartDate());
        assertNotNull(temp.getCurrent());
        assertNotNull(temp.getEndDate());
    }

    @Test
    void testCreatePeriodWithNullValue() {
        Period temp = new Period();
        assertNull(temp.getId());
        assertNull(temp.getStartDate());
        assertNull(temp.getCurrent());
        assertNull(temp.getUpdateAt());
        assertNull(temp.getDeletedAt());
    }

    @Test
    void testComparePeriod() {
        Period temp = PeriodMother.random(true);
        Period temp2 = temp;
        assertTrue(temp.equals(temp2));
        assertInstanceOf(Integer.class, temp2.hashCode());
    }

    @Test
    void testToString() {
        Period period = PeriodMother.random(true);
        assertTrue(period.toString().contains(period.getId().toString()));
    }

    @Test
    void testNotComparePeriod() {
        Period temp = PeriodMother.random(true);
        Period temp2 = PeriodMother.random(true);
        assertFalse(temp.equals(temp2));
    }

    @Test
    void testSettingValues() {
        Period period = new Period();

        UUID uuid = UUID.randomUUID();
        period.setId(uuid);
        assertInstanceOf(UUID.class, period.getId());

        var start = DateValueObjectMother.random();
        period.setStartDate(new PeriodStartDate(start));
        assertInstanceOf(PeriodStartDate.class, period.getStartDate());
        assertEquals(start.toString(), period.getStartDate().getValue().toString());

        var endDate = DateValueObjectMother.random();
        period.setEndDate(new PeriodEndDate(endDate));
        assertInstanceOf(PeriodEndDate.class, period.getEndDate());
        assertEquals(endDate.toString(), period.getEndDate().getValue().toString());

        var curret = true;
        period.setCurrent(new PeriodCurrent(curret));
        assertInstanceOf(PeriodCurrent.class, period.getCurrent());
        assertEquals(curret, period.getCurrent().getValue());
    }

    @Test
    void testTimestamps() {
        Period period = PeriodMother.random(true);
        var periodAssert = new WithTimestampsTest<Period>();
        periodAssert.assertWithTimestamp(period);

        Period period2 = period;
        periodAssert.assertEqualsTimestamps(period, period2);
    }
}
