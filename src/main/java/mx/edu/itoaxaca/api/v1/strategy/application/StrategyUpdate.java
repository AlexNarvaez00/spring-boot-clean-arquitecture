package mx.edu.itoaxaca.api.v1.strategy.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.strategy.domain.Strategy;
import mx.edu.itoaxaca.api.v1.strategy.domain.StrategyRepository;

public class StrategyUpdate {
    public static Strategy run(
        StrategyRepository repo,
        UUID id,
        Strategy arg
    ) {
        arg.setId(id);
        return repo.save(arg);
    }
}
