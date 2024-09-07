package mx.edu.itoaxaca.api.v1.type_support_area.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import mx.edu.itoaxaca.api.v1.type_support_area.domain.TypeSupportArea;
import mx.edu.itoaxaca.api.v1.type_support_area.domain.TypeSupportAreaMother;
import mx.edu.itoaxaca.api.v1.type_support_area.infrastructure.persistence.PostgresTypeSupportArea;
import mx.edu.itoaxaca.api.v1.type_support_area.infrastructure.persistence.TypeSupportAreaRepositoryMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TypeSupportAreaGetByIdTest {
    
    @Test
    void testRun() {
        var creator = new TypeSupportAreaGetById();
        var repo = TypeSupportAreaRepositoryMock.mock();

       TypeSupportArea type_support_area = TypeSupportAreaMother.random();
        Mockito.when(repo.findTypeSupportAreaById(type_support_area.id())).thenReturn(type_support_area);
       TypeSupportArea type_support_areaFinded = TypeSupportAreaGetById.run(repo, type_support_area.id());

        assertEquals(type_support_area.id(), type_support_areaFinded.id()); 
    }

}
