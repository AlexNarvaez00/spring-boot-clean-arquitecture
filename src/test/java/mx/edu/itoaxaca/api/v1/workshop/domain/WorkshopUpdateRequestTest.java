package mx.edu.itoaxaca.api.v1.workshop.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;
import org.junit.jupiter.api.Test;

public class WorkshopUpdateRequestTest {

    @Test
    void testAsWorkshop() {
        Workshop workshop = WorkshopMother.random();
        var request = new WorkshopUpdateRequest();
        request.setName(workshop.getName().getValue());
        request.setDate(workshop.getDate().getValue());
        request.setSpeaker(workshop.getSpeaker().getValue());
        request.setSpeaker_institution(
            workshop.getSpeakerInstitution().getValue()
        );
        request.setCareer_ids(new UUID[] { UUID.randomUUID() });
        var workshopFromReq = request.aWorkshop();

        assertEquals(
            workshopFromReq.getName().getValue(),
            workshop.getName().getValue()
        );
    }
}
