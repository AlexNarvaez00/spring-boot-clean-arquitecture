package mx.edu.itoaxaca.api.v1.shedule.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import mx.edu.itoaxaca.api.v1.shedule.domain.Shedule;
import mx.edu.itoaxaca.api.v1.shedule.domain.SheduleMother;
import mx.edu.itoaxaca.api.v1.shedule.infrastructure.persistence.SheduleRepositoryMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SheduleGetByIdTest {
    @Test
    void runTest() {
        var creator = new SheduleGetById();
        var repo = SheduleRepositoryMock.mock();

        Shedule shedule = SheduleMother.random();
        Mockito.when(repo.findSheduleById(shedule.getId())).thenReturn(shedule);
        Shedule sheduleFinded = SheduleGetById.run(repo, shedule.getId());

        assertEquals(shedule.getId(), sheduleFinded.getId()); 
    }
}
