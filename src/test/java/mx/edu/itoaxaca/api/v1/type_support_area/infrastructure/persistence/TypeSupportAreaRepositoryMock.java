package mx.edu.itoaxaca.api.v1.type_support_area.infrastructure.persistence;

import mx.edu.itoaxaca.api.v1.type_support_area.domain.TypeSupportAreaRepository;
import org.mockito.Mockito;

public class TypeSupportAreaRepositoryMock {

    public static final TypeSupportAreaRepository mock() {
        return Mockito.mock(TypeSupportAreaRepository.class);
    }
}
