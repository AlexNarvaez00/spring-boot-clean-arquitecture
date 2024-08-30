package mx.edu.itoaxaca.api.v1.type_support_area.application;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

import mx.edu.itoaxaca.api.v1.type_support_area.domain.TypeSupportAreaMother;
import mx.edu.itoaxaca.api.v1.type_support_area.infrastructure.persistence.PostgresTypeSupportArea;
import mx.edu.itoaxaca.api.v1.type_support_area.infrastructure.persistence.TypeSupportAreaRepositoryMock;

public class TypeSupportAreaUpdateTest {
    @Test
    void runTest() {
        var creator = new TypeSupportAreaUpdate();
        var repo = TypeSupportAreaRepositoryMock.mock();

        PostgresTypeSupportArea type_support_area = TypeSupportAreaMother.random();
        Mockito.when(repo.save(type_support_area)).thenReturn(type_support_area);
        PostgresTypeSupportArea type_support_areaUpdated = TypeSupportAreaUpdate.run(repo, type_support_area.getId(), type_support_area);

        assertEquals(type_support_area, type_support_areaUpdated); 
    }
}
