package mx.edu.itoaxaca.api.v1.strategy.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StrategyUpdateRequestTest {

    @Test
    void testAsStrategy() {
        Strategy strategy = StrategyMother.random();
        var request = new StrategyUpdateRequest();
        request.setName(strategy.getName().getValue());

        var strategyFromReq = request.asStrategy();

        assertEquals(
            strategy.getName().getValue(),
            strategyFromReq.getName().getValue()
        );
    }
}
