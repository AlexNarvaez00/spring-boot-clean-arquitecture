package mx.edu.itoaxaca.api.v1.shedule.application;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

import mx.edu.itoaxaca.api.v1.shedule.domain.Shedule;
import mx.edu.itoaxaca.api.v1.shedule.domain.SheduleMother;
import mx.edu.itoaxaca.api.v1.shedule.infrastructure.persistence.SheduleRepositoryMock;

public class SheduleUpdateTest {
    @Test
    void runTest() {
        var creator = new SheduleUpdate();
        var repo = SheduleRepositoryMock.mock();

        Shedule shedule = SheduleMother.random();
        Mockito.when(repo.save(shedule)).thenReturn(shedule);
        Shedule sheduleUpdated = SheduleUpdate.run(repo, shedule.getId(), shedule);

        assertEquals(shedule, sheduleUpdated); 
    }
}
