package mx.edu.itoaxaca.api.v1.period.application;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import mx.edu.itoaxaca.api.v1.period.domain.Period;
import mx.edu.itoaxaca.api.v1.period.domain.PeriodMother;
import mx.edu.itoaxaca.api.v1.period.infrastructure.persistence.PeriodRepositoryMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PeriodDestroyTest {

    @Test
    void testRun() {
        var destroyer = new PeriodDestroy();

        Period period = PeriodMother.random(true);

        var repo = PeriodRepositoryMock.mock;
        Mockito.when(repo.findPeriodById(period.getId())).thenReturn(period);

        Mockito.doNothing().when(repo).deleteById(period.getId());
        PeriodDestroy.run(repo, period.getId());

        verify(repo, times(1));
    }
}
