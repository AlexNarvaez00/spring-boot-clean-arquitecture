package mx.edu.itoaxaca.api.v1.shedule.infrastructure.controllers;

import java.util.HashMap;
import mx.edu.itoaxaca.Routes;
import mx.edu.itoaxaca.api.v1.shedule.domain.SheduleMother;
import mx.edu.itoaxaca.api.v1.shedule.domain.SheduleRepository;
import mx.edu.itoaxaca.api.v1.shared.infrastructure.RestClientTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(SheduleController.class)
public class SheduleControllerTest extends RestClientTest<SheduleRepository>{
    @Test
    void testDestroy() throws Exception {
        var shedule = SheduleMother.random();
        Mockito.when(this.getRepo().findSheduleById(shedule.getId())).thenReturn(
            shedule
        );
        var url = Routes.API_V1_SCHEDULE_BASE + "/" + shedule.getId().toString();
        this.delete(url).andExpect(
                MockMvcResultMatchers.status().isNoContent()
            );
    }

    @Test
    void testIndex() throws Exception {
        this.get(Routes.API_V1_SCHEDULE_BASE).andExpect(
                MockMvcResultMatchers.status().isOk()
            );
    }

    @Test
    void testShow() throws Exception {
        var shedule = SheduleMother.random();
        Mockito.when(this.getRepo().findSheduleById(shedule.getId())).thenReturn(
            shedule
        );

        var url = Routes.API_V1_SCHEDULE_BASE + "/" + shedule.getId().toString();

        this.get(url).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testStore() throws Exception {
        var shedule = SheduleMother.random();
        var request = new HashMap<String, String>();

        this.post(Routes.API_V1_SCHEDULE_BASE, request).andExpect(
                MockMvcResultMatchers.status().isOk()
            );
    }

    @Test
    void testUpdate() throws Exception {
        var shedule = SheduleMother.random();
        var sheduleUpdate = SheduleMother.random();

        var request = new HashMap<String, String>();

        Mockito.when(this.getRepo().findSheduleById(shedule.getId())).thenReturn(
            sheduleUpdate
        );

        var url = Routes.API_V1_SCHEDULE_BASE + "/" + shedule.getId().toString();
        this.put(url, request).andExpect(MockMvcResultMatchers.status().isOk());
    }
}
