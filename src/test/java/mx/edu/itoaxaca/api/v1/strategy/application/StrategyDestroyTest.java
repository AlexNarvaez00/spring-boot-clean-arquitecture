package mx.edu.itoaxaca.api.v1.strategy.application;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import mx.edu.itoaxaca.api.v1.strategy.domain.Strategy;
import mx.edu.itoaxaca.api.v1.strategy.domain.StrategyMother;
import mx.edu.itoaxaca.api.v1.strategy.infrastructure.persistence.StrategyRepositoryMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class StrategyDestroyTest {

    @Test
    void runTest() {
        var destroyer = new StrategyDestroy();

        Strategy strategy = StrategyMother.random();

        var repo = StrategyRepositoryMock.mock();
        Mockito.when(repo.findStrategyById(strategy.getId())).thenReturn(strategy);

        Mockito.doNothing().when(repo).deleteById(strategy.getId());
        StrategyDestroy.run(repo, strategy.getId());

        verify(repo, times(1));
    }
}
