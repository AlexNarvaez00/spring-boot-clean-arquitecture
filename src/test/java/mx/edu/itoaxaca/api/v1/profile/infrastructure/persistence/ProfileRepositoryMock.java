package mx.edu.itoaxaca.api.v1.profile.infrastructure.persistence;

import mx.edu.itoaxaca.api.v1.profile.domain.ProfileRepository;
import org.mockito.Mockito;

public class ProfileRepositoryMock {

    public static ProfileRepository mock(){
        return Mockito.mock(ProfileRepository.class);
    }
}
