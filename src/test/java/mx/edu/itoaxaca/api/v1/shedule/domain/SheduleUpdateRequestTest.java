package mx.edu.itoaxaca.api.v1.shedule.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SheduleUpdateRequestTest {

    @Test
    void testAsShedule() {
        Shedule shedule = SheduleMother.random();
        var request = new SheduleUpdateRequest();
        request.setDay(shedule.getDay().getValue());
        request.setStart_hour(shedule.getStartHour().getValue());
        request.setEnd_hour(shedule.getEndHour().getValue());

        var sheduleFromReq = request.asShedule();

        assertEquals(
            shedule.getDay().getValue(),
            sheduleFromReq.getDay().getValue()
        );
    }
}
