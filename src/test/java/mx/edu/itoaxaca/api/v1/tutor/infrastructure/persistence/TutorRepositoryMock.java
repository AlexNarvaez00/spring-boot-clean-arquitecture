package mx.edu.itoaxaca.api.v1.tutor.infrastructure.persistence;

import mx.edu.itoaxaca.api.v1.tutor.domain.TutorRepository;
import org.mockito.Mockito;

public class TutorRepositoryMock {

    public static TutorRepository mock() {
        return Mockito.mock(TutorRepository.class);
    }
}
