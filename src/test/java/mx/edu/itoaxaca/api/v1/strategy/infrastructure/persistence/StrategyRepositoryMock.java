package mx.edu.itoaxaca.api.v1.strategy.infrastructure.persistence;

import mx.edu.itoaxaca.api.v1.strategy.domain.StrategyRepository;
import org.mockito.Mockito;

public class StrategyRepositoryMock {

    public static StrategyRepository mock(){
        return Mockito.mock(StrategyRepository.class);
    }
}
