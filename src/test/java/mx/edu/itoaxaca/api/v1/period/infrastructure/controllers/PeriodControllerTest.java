package mx.edu.itoaxaca.api.v1.period.infrastructure.controllers;

import mx.edu.itoaxaca.Routes;
import mx.edu.itoaxaca.api.v1.period.domain.PeriodMother;
import mx.edu.itoaxaca.api.v1.period.domain.PeriodRepository;
import mx.edu.itoaxaca.api.v1.period.domain.PeriodStoreRequest;
import mx.edu.itoaxaca.api.v1.shared.infrastructure.RestClient;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(PeriodController.class)
public class PeriodControllerTest extends RestClient<PeriodRepository> {

    @Test
    void testDestroy() {}

    @Test
    void testIndex() throws Exception {
        this.get(Routes.API_V1_PERIOD_BASE).andExpect(
                MockMvcResultMatchers.status().isOk()
            );
    }

    @Test
    void testShow() {}

    @Test
    void testStore() throws Exception {
        var period = PeriodMother.random(true);
        var request = new HashMap<String, String>();
        request.put( "start_date",period.getStartDate().getValue().toString());
        request.put( "end_date",period.getEndDate().getValue().toString());
        request.put( "current",period.getCurrent().getValue().toString());

        this.post(Routes.API_V1_PERIOD_BASE, request).andExpect(
                MockMvcResultMatchers.status().isOk()
            );
    }

    @Test
    void testUpdate() {}
}
