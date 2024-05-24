package mx.edu.itoaxaca.api.v1.workshop.infrastructure.controllers;

import java.util.HashMap;
import java.util.UUID;
import mx.edu.itoaxaca.Routes;
import mx.edu.itoaxaca.api.v1.shared.infrastructure.RestClientTest;
import mx.edu.itoaxaca.api.v1.workshop.domain.WorkshopMother;
import mx.edu.itoaxaca.api.v1.workshop.domain.WorkshopRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(WorkshopController.class)
public class WorkshopControllerTest extends RestClientTest<WorkshopRepository> {

    @Test
    void testDestroy() throws Exception {
        var workshop = WorkshopMother.random();
        Mockito.when(
            this.getRepo().findWorkshopById(workshop.getId())
        ).thenReturn(workshop);
        var url =
            Routes.API_V1_WORKSHOP_BASE + "/" + workshop.getId().toString();
        this.delete(url).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testIndex() throws Exception {
        this.get(Routes.API_V1_WORKSHOP_BASE).andExpect(
                MockMvcResultMatchers.status().isOk()
            );
    }

    @Test
    void testShow() throws Exception {
        var workshop = WorkshopMother.random();
        Mockito.when(
            this.getRepo().findWorkshopById(workshop.getId())
        ).thenReturn(workshop);

        var url =
            Routes.API_V1_WORKSHOP_BASE + "/" + workshop.getId().toString();

        this.get(url).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testStore() throws Exception {
        var workshop = WorkshopMother.random();
        var request = new HashMap<String, Object>();
        request.put("name", workshop.getName().getValue());
        request.put("speaker", workshop.getSpeaker().getValue());
        request.put("date", workshop.getDate().getValue());
        request.put(
            "speaker_institution",
            workshop.getSpeakerInstitution().getValue()
        );
        request.put("career_ids", new UUID[] { UUID.randomUUID() });

        this.post(Routes.API_V1_WORKSHOP_BASE, request).andExpect(
                MockMvcResultMatchers.status().isOk()
            );
    }

    @Test
    void testUpdate() throws Exception {
        var workshop = WorkshopMother.random();
        var workshopUpdate = WorkshopMother.random();

        var request = new HashMap<String, Object>();
        request.put("name", workshop.getName().getValue());
        request.put("speaker", workshop.getSpeaker().getValue());
        request.put("date", workshop.getDate().getValue());
        request.put(
            "speaker_institution",
            workshop.getSpeakerInstitution().getValue()
        );
        request.put("career_ids", new UUID[] { UUID.randomUUID() });

        Mockito.when(
            this.getRepo().findWorkshopById(workshop.getId())
        ).thenReturn(workshopUpdate);

        var url =
            Routes.API_V1_WORKSHOP_BASE + "/" + workshop.getId().toString();
        this.put(url, request).andExpect(MockMvcResultMatchers.status().isOk());
    }
}
