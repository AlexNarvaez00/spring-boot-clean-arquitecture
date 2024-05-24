package mx.edu.itoaxaca.api.v1.type_date.infrastructure.controllers;

import java.util.HashMap;
import mx.edu.itoaxaca.Routes;
import mx.edu.itoaxaca.api.v1.type_date.domain.TypeDateMother;
import mx.edu.itoaxaca.api.v1.type_date.domain.TypeDateRepository;
import mx.edu.itoaxaca.api.v1.shared.infrastructure.RestClientTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(TypeDateController.class)
public class TypeDateControllerTest extends RestClientTest<TypeDateRepository>{
    @Test
    void testDestroy() throws Exception {
        var type_date = TypeDateMother.random();
        Mockito.when(this.getRepo().findTypeDateById(type_date.getId())).thenReturn(
            type_date
        );
        var url = Routes.API_V1_TYPE_DATE_BASE + "/" + type_date.getId().toString();
        this.delete(url).andExpect(
                MockMvcResultMatchers.status().isNoContent()
            );
    }

    @Test
    void testIndex() throws Exception {
        this.get(Routes.API_V1_TYPE_DATE_BASE).andExpect(
                MockMvcResultMatchers.status().isOk()
            );
    }

    @Test
    void testShow() throws Exception {
        var type_date = TypeDateMother.random();
        Mockito.when(this.getRepo().findTypeDateById(type_date.getId())).thenReturn(
            type_date
        );

        var url = Routes.API_V1_TYPE_DATE_BASE + "/" + type_date.getId().toString();

        this.get(url).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testStore() throws Exception {
        var type_date = TypeDateMother.random();
        var request = new HashMap<String, String>();
        request.put("name", type_date.getName().getValue());

        this.post(Routes.API_V1_TYPE_DATE_BASE, request).andExpect(
                MockMvcResultMatchers.status().isOk()
            );
    }

    @Test
    void testUpdate() throws Exception {
        var type_date = TypeDateMother.random();
        var type_dateUpdate = TypeDateMother.random();

        var request = new HashMap<String, String>();
        request.put("name", type_date.getName().getValue());

        Mockito.when(this.getRepo().findTypeDateById(type_date.getId())).thenReturn(
            type_dateUpdate
        );

        var url = Routes.API_V1_TYPE_DATE_BASE + "/" + type_date.getId().toString();
        this.put(url, request).andExpect(MockMvcResultMatchers.status().isOk());
    }
}
