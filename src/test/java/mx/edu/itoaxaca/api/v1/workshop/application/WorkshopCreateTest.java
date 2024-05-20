package mx.edu.itoaxaca.api.v1.workshop.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import mx.edu.itoaxaca.api.v1.workshop.domain.Workshop;
import mx.edu.itoaxaca.api.v1.workshop.domain.WorkshopMother;
import mx.edu.itoaxaca.api.v1.workshop.infrastructure.persistence.WorkshopRepositoryMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class WorkshopCreateTest {

    @Test
    void runTest() {
        var creator = new WorkshopCreate();

        var workshop = WorkshopMother.random();
        var repo = WorkshopRepositoryMock.mock();
        Mockito.when(repo.save(workshop)).thenReturn(workshop);

        Workshop workshopCreated = WorkshopCreate.run(repo, workshop);
        assertEquals(
            workshop.getName().getValue(),
            workshopCreated.getName().getValue()
        );
    }
}
