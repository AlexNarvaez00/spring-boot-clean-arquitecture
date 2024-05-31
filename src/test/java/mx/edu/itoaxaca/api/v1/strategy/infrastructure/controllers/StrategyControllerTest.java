package mx.edu.itoaxaca.api.v1.strategy.infrastructure.controllers;

import java.util.HashMap;
import mx.edu.itoaxaca.Routes;
import mx.edu.itoaxaca.api.v1.strategy.domain.StrategyMother;
import mx.edu.itoaxaca.api.v1.strategy.domain.StrategyRepository;
import mx.edu.itoaxaca.api.v1.shared.infrastructure.RestClientTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(StrategyController.class)
public class StrategyControllerTest extends RestClientTest<StrategyRepository>{
    @Test
    void testDestroy() throws Exception {
        var strategy = StrategyMother.random();
        Mockito.when(this.getRepo().findStrategyById(strategy.getId())).thenReturn(
            strategy
        );
        var url = Routes.API_V1_STRATEGY_BASE + "/" + strategy.getId().toString();
        this.delete(url).andExpect(
                MockMvcResultMatchers.status().isNoContent()
            );
    }

    @Test
    void testIndex() throws Exception {
        this.get(Routes.API_V1_STRATEGY_BASE).andExpect(
                MockMvcResultMatchers.status().isOk()
            );
    }

    @Test
    void testShow() throws Exception {
        var strategy = StrategyMother.random();
        Mockito.when(this.getRepo().findStrategyById(strategy.getId())).thenReturn(
            strategy
        );

        var url = Routes.API_V1_STRATEGY_BASE + "/" + strategy.getId().toString();

        this.get(url).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testStore() throws Exception {
        var strategy = StrategyMother.random();
        var request = new HashMap<String, String>();

        this.post(Routes.API_V1_STRATEGY_BASE, request).andExpect(
                MockMvcResultMatchers.status().isOk()
            );
    }

    @Test
    void testUpdate() throws Exception {
        var strategy = StrategyMother.random();
        var strategyUpdate = StrategyMother.random();

        var request = new HashMap<String, String>();

        Mockito.when(this.getRepo().findStrategyById(strategy.getId())).thenReturn(
            strategyUpdate
        );

        var url = Routes.API_V1_STRATEGY_BASE + "/" + strategy.getId().toString();
        this.put(url, request).andExpect(MockMvcResultMatchers.status().isOk());
    }
}
