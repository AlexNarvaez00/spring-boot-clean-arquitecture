package mx.edu.itoaxaca.api.v1.support_area.infrastructure.controllers;

import java.util.HashMap;
import mx.edu.itoaxaca.Routes;
import mx.edu.itoaxaca.api.v1.shared.infrastructure.RestClientTest;
import mx.edu.itoaxaca.api.v1.support_area.domain.SupportAreaMother;
import mx.edu.itoaxaca.api.v1.support_area.domain.SupportAreaRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(SupportAreaController.class)
public class SupportAreaControllerTest
    extends RestClientTest<SupportAreaRepository> {

    @Test
    void testDestroy() throws Exception {
        var support_area = SupportAreaMother.random();
        Mockito.when(
            this.getRepo().findSupportAreaById(support_area.getId())
        ).thenReturn(support_area);
        var url =
            Routes.API_V1_SUPPORT_AREAS_BASE +
            "/" +
            support_area.getId().toString();
        this.delete(url).andExpect(
                MockMvcResultMatchers.status().isNoContent()
            );
    }

    @Test
    void testIndex() throws Exception {
        this.get(Routes.API_V1_SUPPORT_AREAS_BASE).andExpect(
                MockMvcResultMatchers.status().isOk()
            );
    }

    @Test
    void testShow() throws Exception {
        var support_area = SupportAreaMother.random();
        Mockito.when(
            this.getRepo().findSupportAreaById(support_area.getId())
        ).thenReturn(support_area);

        var url =
            Routes.API_V1_SUPPORT_AREAS_BASE +
            "/" +
            support_area.getId().toString();

        this.get(url).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testStore() throws Exception {
        var support_area = SupportAreaMother.random();
        var request = new HashMap<String, String>();
        request.put("name", support_area.getName().getValue());
        request.put("short_name", support_area.getShortName().getValue());
        request.put(
            "type_support_area_id",
            support_area.getType_support_area().getId().toString()
        );
        this.post(Routes.API_V1_SUPPORT_AREAS_BASE, request).andExpect(
                MockMvcResultMatchers.status().isOk()
            );
    }

    @Test
    void testUpdate() throws Exception {
        var support_area = SupportAreaMother.random();
        var support_areaUpdate = SupportAreaMother.random();

        var request = new HashMap<String, String>();
        request.put("name", support_areaUpdate.getName().getValue());
        request.put("short_name", support_areaUpdate.getShortName().getValue());
        request.put(
            "type_support_area_id",
            support_areaUpdate.getType_support_area().getId().toString()
        );

        Mockito.when(
            this.getRepo().findSupportAreaById(support_area.getId())
        ).thenReturn(support_areaUpdate);

        var url =
            Routes.API_V1_SUPPORT_AREAS_BASE +
            "/" +
            support_area.getId().toString();
        this.put(url, request).andExpect(MockMvcResultMatchers.status().isOk());
    }
}
