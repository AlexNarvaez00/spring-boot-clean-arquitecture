package mx.edu.itoaxaca.api.v1.workshop.application;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

import mx.edu.itoaxaca.api.v1.workshop.domain.Workshop;
import mx.edu.itoaxaca.api.v1.workshop.domain.WorkshopMother;
import mx.edu.itoaxaca.api.v1.workshop.infrastructure.persistence.WorkshopRepositoryMock;

public class WorkshopUpdateTest {
    @Test
    void runTest() {
        var creator = new WorkshopUpdate();
        var repo = WorkshopRepositoryMock.mock();

        Workshop workshop = WorkshopMother.random();
        Mockito.when(repo.save(workshop)).thenReturn(workshop);
        Workshop workshopUpdated = WorkshopUpdate.run(repo, workshop.getId(), workshop);

        assertEquals(workshop, workshopUpdated); 
    }
}
