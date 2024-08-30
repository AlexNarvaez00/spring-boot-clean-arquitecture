package mx.edu.itoaxaca.api.v1.type_support_area.application;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import mx.edu.itoaxaca.api.v1.type_support_area.domain.TypeSupportAreaMother;
import mx.edu.itoaxaca.api.v1.type_support_area.infrastructure.persistence.PostgresTypeSupportArea;
import mx.edu.itoaxaca.api.v1.type_support_area.infrastructure.persistence.TypeSupportAreaRepositoryMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TypeSupportAreaDestroyTest {

    @Test
    void testRun() {
        var destroyer = new TypeSupportAreaDestroy();

        PostgresTypeSupportArea typeSupportArea = TypeSupportAreaMother.random();

        var repo = TypeSupportAreaRepositoryMock.mock();
        
        Mockito.doNothing().when(repo).deleteById(typeSupportArea.getId());
        TypeSupportAreaDestroy.run(repo, typeSupportArea.getId());

        verify(repo, times(1)).deleteById(typeSupportArea.getId());
    }
}
