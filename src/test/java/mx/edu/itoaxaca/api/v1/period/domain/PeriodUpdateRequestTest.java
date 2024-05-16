package mx.edu.itoaxaca.api.v1.period.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PeriodUpdateRequestTest {
    @Test
    void testAsPeriod() {
        Period period = PeriodMother.random(true);
        var request = new PeriodUpdateRequest();
        request.setCurrent(period.getCurrent().getValue());
        request.setStart_date(period.getStartDate().getValue());
        request.setEnd_date(period.getEndDate().getValue());

        var periodFromReq = request.asPeriod();

        assertEquals(
            period.getStartDate().toString(),
            periodFromReq.getStartDate().toString()
        );
        assertEquals(
            period.getEndDate().toString(),
            periodFromReq.getEndDate().toString()
        );
    }
}
