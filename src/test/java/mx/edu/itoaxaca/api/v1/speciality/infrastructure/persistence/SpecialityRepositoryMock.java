package mx.edu.itoaxaca.api.v1.speciality.infrastructure.persistence;

import mx.edu.itoaxaca.api.v1.speciality.domain.SpecialityRepository;
import org.mockito.Mockito;

public class SpecialityRepositoryMock {

    public static SpecialityRepository mock(){
        return Mockito.mock(SpecialityRepository.class);
    }
}
