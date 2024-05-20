package mx.edu.itoaxaca.api.v1.workshop.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class WorkshopStoreRequestTest {

    @Test
    void testAsWorkshop() {
        Workshop workshop = WorkshopMother.random();
        var request = new WorkshopStoreRequest();
        request.setId(workshop.getId());
        request.setName(workshop.getName().getValue());

        var workshopFromReq = request.aWorkshop();

        assertEquals(workshopFromReq.getId(),  workshop.getId());
    } 
}
