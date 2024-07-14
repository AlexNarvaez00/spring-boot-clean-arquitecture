package mx.edu.itoaxaca.api.v1.shedule.infrastructure.persistence;

import mx.edu.itoaxaca.api.v1.shedule.domain.SheduleRepository;
import org.mockito.Mockito;

public class SheduleRepositoryMock {

    public static SheduleRepository mock(){
        return Mockito.mock(SheduleRepository.class);
    }
}
