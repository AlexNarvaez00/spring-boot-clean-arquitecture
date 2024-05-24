package mx.edu.itoaxaca.api.v1.type_date.application;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import mx.edu.itoaxaca.api.v1.type_date.domain.TypeDate;
import mx.edu.itoaxaca.api.v1.type_date.domain.TypeDateMother;
import mx.edu.itoaxaca.api.v1.type_date.infrastructure.persistence.TypeDateRepositoryMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TypeDateDestroyTest {

    @Test
    void runTest() {
        var destroyer = new TypeDateDestroy();
        TypeDate type_date = TypeDateMother.random();
        var repo = TypeDateRepositoryMock.mock();

        Mockito.doNothing().when(repo).deleteById(type_date.getId());
        TypeDateDestroy.run(repo, type_date.getId());

        verify(repo, times(1)).deleteById(type_date.getId());
    }
}
