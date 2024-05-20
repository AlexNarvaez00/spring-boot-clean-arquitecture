package mx.edu.itoaxaca.api.v1.workshop.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import mx.edu.itoaxaca.api.v1.workshop.domain.Workshop;
import mx.edu.itoaxaca.api.v1.workshop.domain.WorkshopMother;
import mx.edu.itoaxaca.api.v1.workshop.infrastructure.persistence.WorkshopRepositoryMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class WorkshopGetByIdTest {
    @Test
    void runTest() {
        var creator = new WorkshopGetById();
        var repo = WorkshopRepositoryMock.mock();

        Workshop workshop = WorkshopMother.random();
        Mockito.when(repo.findWorkshopById(workshop.getId())).thenReturn(workshop);
        Workshop workshopFinded = WorkshopGetById.run(repo, workshop.getId());

        assertEquals(workshop.getId(), workshopFinded.getId()); 
    }
}
