package mx.edu.itoaxaca.api.v1.type_date.infrastructure.persistence;

import org.mockito.Mockito;

import mx.edu.itoaxaca.api.v1.type_date.domain.TypeDateRepository;

public class TypeDateRepositoryMock {

    public static TypeDateRepository mock(){
        return Mockito.mock(TypeDateRepository.class);
    }
}
