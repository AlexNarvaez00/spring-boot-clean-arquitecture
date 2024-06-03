package mx.edu.itoaxaca.api.v1.speciality.infrastructure.controllers;

import java.util.HashMap;
import mx.edu.itoaxaca.Routes;
import mx.edu.itoaxaca.api.v1.speciality.domain.SpecialityMother;
import mx.edu.itoaxaca.api.v1.speciality.domain.SpecialityRepository;
import mx.edu.itoaxaca.api.v1.shared.infrastructure.RestClientTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(SpecialityController.class)
public class SpecialityControllerTest extends RestClientTest<SpecialityRepository>{
    @Test
    void testDestroy() throws Exception {
        var speciality = SpecialityMother.random();
        Mockito.when(this.getRepo().findSpecialityById(speciality.getId())).thenReturn(
            speciality
        );
        var url = Routes.API_V1_SPECIALITY_BASE + "/" + speciality.getId().toString();
        this.delete(url).andExpect(
                MockMvcResultMatchers.status().isNoContent()
            );
    }

    @Test
    void testIndex() throws Exception {
        this.get(Routes.API_V1_SPECIALITY_BASE).andExpect(
                MockMvcResultMatchers.status().isOk()
            );
    }

    @Test
    void testShow() throws Exception {
        var speciality = SpecialityMother.random();
        Mockito.when(this.getRepo().findSpecialityById(speciality.getId())).thenReturn(
            speciality
        );

        var url = Routes.API_V1_SPECIALITY_BASE + "/" + speciality.getId().toString();

        this.get(url).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testStore() throws Exception {
        var speciality = SpecialityMother.random();
        var request = new HashMap<String, Object>();
        request.put("code", speciality.getCode().getValue());
        request.put("start_date", speciality.getStart_date().getValue());
        request.put("end_date", speciality.getEnd_date().getValue());


        this.post(Routes.API_V1_SPECIALITY_BASE, request).andExpect(
                MockMvcResultMatchers.status().isOk()
            );
    }

    @Test
    void testUpdate() throws Exception {
        var speciality = SpecialityMother.random();
        var specialityUpdate = SpecialityMother.random();

        var request = new HashMap<String, Object>();
        request.put("code", specialityUpdate.getCode().getValue());
        request.put("start_date", specialityUpdate.getStart_date().getValue());
        request.put("end_date", specialityUpdate.getEnd_date().getValue());
        
        Mockito.when(this.getRepo().findSpecialityById(speciality.getId())).thenReturn(
            specialityUpdate
        );

        var url = Routes.API_V1_SPECIALITY_BASE + "/" + speciality.getId().toString();
        this.put(url, request).andExpect(MockMvcResultMatchers.status().isOk());
    }
}
