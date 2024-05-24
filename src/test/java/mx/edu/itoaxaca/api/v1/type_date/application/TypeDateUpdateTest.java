package mx.edu.itoaxaca.api.v1.type_date.application;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

import mx.edu.itoaxaca.api.v1.type_date.domain.TypeDate;
import mx.edu.itoaxaca.api.v1.type_date.domain.TypeDateMother;
import mx.edu.itoaxaca.api.v1.type_date.infrastructure.persistence.TypeDateRepositoryMock;

public class TypeDateUpdateTest {
    @Test
    void runTest() {
        var creator = new TypeDateUpdate();
        var repo = TypeDateRepositoryMock.mock();

        TypeDate type_date = TypeDateMother.random();
        Mockito.when(repo.save(type_date)).thenReturn(type_date);
        TypeDate type_dateUpdated = TypeDateUpdate.run(repo, type_date.getId(), type_date);

        assertEquals(type_date, type_dateUpdated); 
    }
}
