package mx.edu.itoaxaca.api.v1.type_support_area.infrastructure.controllers;

import java.util.HashMap;
import mx.edu.itoaxaca.Routes;
import mx.edu.itoaxaca.api.v1.shared.infrastructure.RestClientTest;
import mx.edu.itoaxaca.api.v1.type_support_area.domain.TypeSupportAreaMother;
import mx.edu.itoaxaca.api.v1.type_support_area.domain.TypeSupportAreaRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(TypeSupportAreaController.class)
public class TypeSupportAreaControllerTest
    extends RestClientTest<TypeSupportAreaRepository> {

    @Test
    void testDestroy() throws Exception {
        var type_support_area = TypeSupportAreaMother.random();
        Mockito.when(
            this.getRepo().findTypeSupportAreaById(type_support_area.getId())
        ).thenReturn(type_support_area);
        var url =
            Routes.API_V1_TYPE_SUPPORT_AREAS_BASE +
            "/" +
            type_support_area.getId().toString();
        this.delete(url).andExpect(
                MockMvcResultMatchers.status().isNoContent()
            );
    }

    @Test
    void testIndex() throws Exception {
        this.get(Routes.API_V1_TYPE_SUPPORT_AREAS_BASE).andExpect(
                MockMvcResultMatchers.status().isOk()
            );
    }

    @Test
    void testShow() throws Exception {
        var type_support_area = TypeSupportAreaMother.random();
        Mockito.when(
            this.getRepo().findTypeSupportAreaById(type_support_area.getId())
        ).thenReturn(type_support_area);

        var url =
            Routes.API_V1_TYPE_SUPPORT_AREAS_BASE +
            "/" +
            type_support_area.getId().toString();

        this.get(url).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testStore() throws Exception {
        var typeAupportArea = TypeSupportAreaMother.random();
        var request = new HashMap<String, String>();
        request.put("type", typeAupportArea.getType().getValue());

        this.post(Routes.API_V1_TYPE_SUPPORT_AREAS_BASE, request).andExpect(
                MockMvcResultMatchers.status().isOk()
            );
    }

    @Test
    void testUpdate() throws Exception {
        var typeSupportArea = TypeSupportAreaMother.random();
        var typeSupportAreaUpdate = TypeSupportAreaMother.random();

        var request = new HashMap<String, String>();
        request.put("type", typeSupportAreaUpdate.getType().getValue());

        Mockito.when(
            this.getRepo().findTypeSupportAreaById(typeSupportArea.getId())
        ).thenReturn(typeSupportAreaUpdate);

        var url =
            Routes.API_V1_TYPE_SUPPORT_AREAS_BASE +
            "/" +
            typeSupportArea.getId().toString();
        this.put(url, request).andExpect(MockMvcResultMatchers.status().isOk());
    }
}
