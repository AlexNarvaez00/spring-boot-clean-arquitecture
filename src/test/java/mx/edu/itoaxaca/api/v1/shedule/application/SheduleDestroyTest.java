package mx.edu.itoaxaca.api.v1.shedule.application;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import mx.edu.itoaxaca.api.v1.shedule.domain.Shedule;
import mx.edu.itoaxaca.api.v1.shedule.domain.SheduleMother;
import mx.edu.itoaxaca.api.v1.shedule.infrastructure.persistence.SheduleRepositoryMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SheduleDestroyTest {

    @Test
    void runTest() {
        var destroyer = new SheduleDestroy();

        Shedule shedule = SheduleMother.random();

        var repo = SheduleRepositoryMock.mock();
        Mockito.when(repo.findSheduleById(shedule.getId())).thenReturn(shedule);

        Mockito.doNothing().when(repo).deleteById(shedule.getId());
        SheduleDestroy.run(repo, shedule.getId());

        verify(repo, times(1)).deleteById(shedule.getId());
    }
}
