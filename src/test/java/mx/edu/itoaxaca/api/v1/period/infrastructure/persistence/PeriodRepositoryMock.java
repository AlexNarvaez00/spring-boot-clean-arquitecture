package mx.edu.itoaxaca.api.v1.period.infrastructure.persistence;

import mx.edu.itoaxaca.api.v1.period.domain.PeriodRepository;
import org.mockito.Mockito;

public class PeriodRepositoryMock {

    public static PeriodRepository mock() {
        return Mockito.mock(PeriodRepository.class);
    }
}
