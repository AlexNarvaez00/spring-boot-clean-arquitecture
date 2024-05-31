package mx.edu.itoaxaca.api.v1.strategy.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import mx.edu.itoaxaca.api.v1.strategy.domain.Strategy;
import mx.edu.itoaxaca.api.v1.strategy.domain.StrategyMother;
import mx.edu.itoaxaca.api.v1.strategy.infrastructure.persistence.StrategyRepositoryMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class StrategyGetByIdTest {

    @Test
    void runTest() {
        var creator = new StrategyGetById();
        var repo = StrategyRepositoryMock.mock();

        Strategy strategy = StrategyMother.random();
        Mockito.when(repo.findStrategyById(strategy.getId())).thenReturn(
            strategy
        );
        Strategy strategyFinded = StrategyGetById.run(repo, strategy.getId());

        assertEquals(strategy.getId(), strategyFinded.getId());
    }
}
