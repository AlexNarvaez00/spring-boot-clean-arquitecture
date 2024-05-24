package mx.edu.itoaxaca.api.v1.type_date.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import mx.edu.itoaxaca.api.v1.type_date.domain.TypeDate;
import mx.edu.itoaxaca.api.v1.type_date.domain.TypeDateMother;
import mx.edu.itoaxaca.api.v1.type_date.infrastructure.persistence.TypeDateRepositoryMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TypeDateGetByIdTest {
    @Test
    void runTest() {
        var creator = new TypeDateGetById();
        var repo = TypeDateRepositoryMock.mock();

        TypeDate type_date = TypeDateMother.random();
        Mockito.when(repo.findTypeDateById(type_date.getId())).thenReturn(type_date);
        TypeDate type_dateFinded = TypeDateGetById.run(repo, type_date.getId());

        assertEquals(type_date.getId(), type_dateFinded.getId()); 
    }
}
