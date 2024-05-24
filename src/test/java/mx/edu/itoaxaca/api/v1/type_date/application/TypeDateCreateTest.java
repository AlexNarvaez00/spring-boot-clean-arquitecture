package mx.edu.itoaxaca.api.v1.type_date.application;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import mx.edu.itoaxaca.api.v1.type_date.domain.TypeDate;
import mx.edu.itoaxaca.api.v1.type_date.domain.TypeDateMother;
import mx.edu.itoaxaca.api.v1.type_date.infrastructure.persistence.TypeDateRepositoryMock;

public class TypeDateCreateTest {

    @Test
    void runTest() {
        var creator = new TypeDateCreate();
        
        var type_date = TypeDateMother.random();
        var repo = TypeDateRepositoryMock.mock();
        Mockito.when(repo.save(type_date)).thenReturn(type_date);
    
        TypeDate type_dateCreated = TypeDateCreate.run(repo, type_date);
    }
}
