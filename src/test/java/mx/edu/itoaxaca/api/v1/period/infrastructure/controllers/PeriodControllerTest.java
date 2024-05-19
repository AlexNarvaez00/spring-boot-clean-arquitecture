package mx.edu.itoaxaca.api.v1.period.infrastructure.controllers;

import java.util.HashMap;
import mx.edu.itoaxaca.Routes;
import mx.edu.itoaxaca.api.v1.period.domain.PeriodMother;
import mx.edu.itoaxaca.api.v1.period.domain.PeriodRepository;
import mx.edu.itoaxaca.api.v1.shared.infrastructure.RestClientTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(PeriodController.class)
public class PeriodControllerTest extends RestClientTest<PeriodRepository> {

    @Test
    void testDestroy() throws Exception {
        var period = PeriodMother.random(true);
        Mockito.when(this.getRepo().findPeriodById(period.getId())).thenReturn(
            period
        );
        var url = Routes.API_V1_PERIOD_BASE + "/" + period.getId().toString();
        this.delete(url).andExpect(
                MockMvcResultMatchers.status().isNoContent()
            );
    }

    @Test
    void testIndex() throws Exception {
        this.get(Routes.API_V1_PERIOD_BASE).andExpect(
                MockMvcResultMatchers.status().isOk()
            );
    }

    @Test
    void testShow() throws Exception {
        var period = PeriodMother.random(true);
        Mockito.when(this.getRepo().findPeriodById(period.getId())).thenReturn(
            period
        );

        var url = Routes.API_V1_PERIOD_BASE + "/" + period.getId().toString();

        this.get(url).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testStore() throws Exception {
        var period = PeriodMother.random(true);
        var request = new HashMap<String, String>();
        request.put("start_date", period.getStartDate().getValue().toString());
        request.put("end_date", period.getEndDate().getValue().toString());
        request.put("current", period.getCurrent().getValue().toString());

        this.post(Routes.API_V1_PERIOD_BASE, request).andExpect(
                MockMvcResultMatchers.status().isOk()
            );
    }

    @Test
    void testUpdate() throws Exception {
        var period = PeriodMother.random(true);
        var periodUpdate = PeriodMother.random(true);

        var request = new HashMap<String, String>();
        request.put(
            "start_date",
            periodUpdate.getStartDate().getValue().toString()
        );
        request.put(
            "end_date",
            periodUpdate.getEndDate().getValue().toString()
        );
        request.put("current", periodUpdate.getCurrent().getValue().toString());

        Mockito.when(this.getRepo().findPeriodById(period.getId())).thenReturn(
            periodUpdate
        );

        var url = Routes.API_V1_PERIOD_BASE + "/" + period.getId().toString();
        this.put(url, request).andExpect(MockMvcResultMatchers.status().isOk());
    }
}
