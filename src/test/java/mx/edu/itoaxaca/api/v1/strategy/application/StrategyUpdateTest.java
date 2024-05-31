package mx.edu.itoaxaca.api.v1.strategy.application;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

import mx.edu.itoaxaca.api.v1.strategy.domain.Strategy;
import mx.edu.itoaxaca.api.v1.strategy.domain.StrategyMother;
import mx.edu.itoaxaca.api.v1.strategy.infrastructure.persistence.StrategyRepositoryMock;

public class StrategyUpdateTest {
    @Test
    void runTest() {
        var creator = new StrategyUpdate();
        var repo = StrategyRepositoryMock.mock();

        Strategy strategy = StrategyMother.random();
        Mockito.when(repo.save(strategy)).thenReturn(strategy);
        Strategy strategyUpdated = StrategyUpdate.run(repo, strategy.getId(), strategy);

        assertEquals(strategy, strategyUpdated); 
    }
}
