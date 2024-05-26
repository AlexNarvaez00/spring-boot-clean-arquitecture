package mx.edu.itoaxaca.api.v1.tutor.infrastructure.controllers;

import java.util.HashMap;
import mx.edu.itoaxaca.Routes;
import mx.edu.itoaxaca.api.v1.shared.infrastructure.RestClientTest;
import mx.edu.itoaxaca.api.v1.tutor.domain.TutorMother;
import mx.edu.itoaxaca.api.v1.tutor.domain.TutorRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(TutorController.class)
public class TutorControllerTest extends RestClientTest<TutorRepository> {

    @Test
    void testDestroy() throws Exception {
        var tutor = TutorMother.random();
        var url = Routes.API_V1_TUTOR_BASE + "/" + tutor.getId().toString();
        Mockito.doNothing().when(this.getRepo()).deleteById(tutor.getId());
        this.delete(url).andExpect(
                MockMvcResultMatchers.status().isNoContent()
            );
    }

    @Test
    void testIndex() throws Exception {
        this.get(Routes.API_V1_TUTOR_BASE).andExpect(
                MockMvcResultMatchers.status().isOk()
            );
    }

    @Test
    void testShow() throws Exception {
        var tutor = TutorMother.random();
        Mockito.when(this.getRepo().findTutorById(tutor.getId())).thenReturn(
            tutor
        );

        var url = Routes.API_V1_TUTOR_BASE + "/" + tutor.getId().toString();

        this.get(url).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testStore() throws Exception {
        var tutor = TutorMother.random();
        var request = new HashMap<String, String>();
        request.put("classification", tutor.getClassification().getValue());
        request.put("profile_id", tutor.getProfile().getId().toString());
        this.post(Routes.API_V1_TUTOR_BASE, request).andExpect(
                MockMvcResultMatchers.status().isOk()
            );
    }

    @Test
    void testUpdate() throws Exception {
        var tutor = TutorMother.random();
        var tutorUpdate = TutorMother.random();

        var request = new HashMap<String, String>();
        request.put(
            "classification",
            tutorUpdate.getClassification().getValue()
        );
        request.put("profile_id", tutorUpdate.getProfile().getId().toString());

        Mockito.when(this.getRepo().findTutorById(tutor.getId())).thenReturn(
            tutorUpdate
        );

        var url = Routes.API_V1_TUTOR_BASE + "/" + tutor.getId().toString();
        this.put(url, request).andExpect(MockMvcResultMatchers.status().isOk());
    }
}
