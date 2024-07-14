package mx.edu.itoaxaca.api.v1.shedule.application;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import mx.edu.itoaxaca.api.v1.shedule.domain.Shedule;
import mx.edu.itoaxaca.api.v1.shedule.domain.SheduleMother;
import mx.edu.itoaxaca.api.v1.shedule.infrastructure.persistence.SheduleRepositoryMock;

public class SheduleCreateTest {

    @Test
    void runTest() {
        var creator = new SheduleCreate();
        
        var shedule = SheduleMother.random();
        var repo = SheduleRepositoryMock.mock();
        Mockito.when(repo.save(shedule)).thenReturn(shedule);
    
        Shedule sheduleCreated = SheduleCreate.run(repo, shedule);
    }
}
