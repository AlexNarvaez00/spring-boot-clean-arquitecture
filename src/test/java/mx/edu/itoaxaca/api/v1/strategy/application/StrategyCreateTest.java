package mx.edu.itoaxaca.api.v1.strategy.application;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import mx.edu.itoaxaca.api.v1.strategy.domain.Strategy;
import mx.edu.itoaxaca.api.v1.strategy.domain.StrategyMother;
import mx.edu.itoaxaca.api.v1.strategy.infrastructure.persistence.StrategyRepositoryMock;

public class StrategyCreateTest {

    @Test
    void runTest() {
        var creator = new StrategyCreate();
        
        var strategy = StrategyMother.random();
        var repo = StrategyRepositoryMock.mock();
        Mockito.when(repo.save(strategy)).thenReturn(strategy);
    
        Strategy strategyCreated = StrategyCreate.run(repo, strategy);
    }
}
