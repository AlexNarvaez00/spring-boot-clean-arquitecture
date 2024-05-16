package mx.edu.itoaxaca.api.v1.period.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PeriodCurrentTest {

    @Test
    void testIsValid() {
        var periodCurrent = new PeriodCurrent(true);
        assertTrue(Boolean.valueOf(periodCurrent.isValid(true)));
    }
}
