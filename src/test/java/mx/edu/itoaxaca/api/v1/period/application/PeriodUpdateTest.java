package mx.edu.itoaxaca.api.v1.period.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import mx.edu.itoaxaca.api.v1.period.domain.Period;
import mx.edu.itoaxaca.api.v1.period.domain.PeriodMother;
import mx.edu.itoaxaca.api.v1.period.infrastructure.persistence.PeriodRepositoryMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PeriodUpdateTest {

    @Test
    void testRun() {
        var creator = new PeriodUpdate();
        var repo = PeriodRepositoryMock.mock();

        Period period = PeriodMother.random(true);

        Mockito.when(repo.save(period)).thenReturn(period);

        Period periodUpdated = PeriodUpdate.run(repo, period.getId(), period);

        assertEquals(period, periodUpdated);
    }
}
