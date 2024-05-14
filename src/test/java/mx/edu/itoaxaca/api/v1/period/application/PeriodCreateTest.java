package mx.edu.itoaxaca.api.v1.period.application;

import mx.edu.itoaxaca.api.v1.period.domain.Period;
import mx.edu.itoaxaca.api.v1.period.domain.PeriodMother;
import mx.edu.itoaxaca.api.v1.period.infrastructure.persistence.PeriodRepositoryMock;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PeriodCreateTest {

    @Test
    void testRun() {
        Period period = PeriodMother.random(true);
        
        var repo = PeriodRepositoryMock.mock;
        Mockito.when(repo.save(period)).thenReturn(period);

        Period periodCreated = PeriodCreate.run(repo, period);

        assertEquals(period, periodCreated);
    }
}
