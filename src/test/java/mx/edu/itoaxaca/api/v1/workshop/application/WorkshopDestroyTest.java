package mx.edu.itoaxaca.api.v1.workshop.application;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import mx.edu.itoaxaca.api.v1.workshop.domain.Workshop;
import mx.edu.itoaxaca.api.v1.workshop.domain.WorkshopMother;
import mx.edu.itoaxaca.api.v1.workshop.infrastructure.persistence.WorkshopRepositoryMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.workshop.domain.WorkshopRepository;

public class WorkshopDestroyTest {

    @Test
    void runTest() {
        var destroyer = new WorkshopDelete();

        Workshop workshop = WorkshopMother.random();

        var repo = WorkshopRepositoryMock.mock();
        Mockito.when(repo.findWorkshopById(workshop.getId())).thenReturn(workshop);

        Mockito.doNothing().when(repo).deleteById(workshop.getId());
        WorkshopDelete.run(repo, workshop.getId());

        verify(repo, times(1)).deleteById(workshop.getId());
    }
}
