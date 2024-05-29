package mx.edu.itoaxaca.api.v1.support_area.application;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import mx.edu.itoaxaca.api.v1.support_area.domain.SupportArea;
import mx.edu.itoaxaca.api.v1.support_area.domain.SupportAreaMother;
import mx.edu.itoaxaca.api.v1.support_area.infrastructure.persistence.SupportAreaRepositoryMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SupportAreaDestroyTest {

    @Test
    void runTest() {
        var destroyer = new SupportAreaDestroy();

        SupportArea support_area = SupportAreaMother.random();

        var repo = SupportAreaRepositoryMock.mock();
        Mockito.when(repo.findSupportAreaById(support_area.getId())).thenReturn(
            support_area
        );

        Mockito.doNothing().when(repo).deleteById(support_area.getId());
        SupportAreaDestroy.run(repo, support_area.getId());

        verify(repo, times(1)).deleteById(support_area.getId());
    }
}
