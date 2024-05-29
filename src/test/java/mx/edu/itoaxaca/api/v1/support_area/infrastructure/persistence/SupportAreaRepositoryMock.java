package mx.edu.itoaxaca.api.v1.support_area.infrastructure.persistence;

import org.mockito.Mockito;

import mx.edu.itoaxaca.api.v1.support_area.domain.SupportAreaRepository;

public class SupportAreaRepositoryMock {

    public static SupportAreaRepository mock(){
        return Mockito.mock(SupportAreaRepository.class);
    }
}
