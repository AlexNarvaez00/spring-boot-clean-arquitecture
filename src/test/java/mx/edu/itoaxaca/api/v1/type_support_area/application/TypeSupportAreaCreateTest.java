package mx.edu.itoaxaca.api.v1.type_support_area.application;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import mx.edu.itoaxaca.api.v1.type_support_area.domain.TypeSupportAreaMother;
import mx.edu.itoaxaca.api.v1.type_support_area.infrastructure.persistence.PostgresTypeSupportArea;
import mx.edu.itoaxaca.api.v1.type_support_area.infrastructure.persistence.TypeSupportAreaRepositoryMock;

public class TypeSupportAreaCreateTest {

    @Test
    public void runTest() {
        var creator = new TypeSupportAreaCreate();
        
        var type_support_area = TypeSupportAreaMother.random();
        var repo = TypeSupportAreaRepositoryMock.mock();
        Mockito.when(repo.save(type_support_area)).thenReturn(type_support_area);
    
        var type_support_areaCreated = TypeSupportAreaCreate.run(repo, type_support_area);
    }
}
