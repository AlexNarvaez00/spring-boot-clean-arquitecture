package mx.edu.itoaxaca.api.v1.strategy.application;

import mx.edu.itoaxaca.api.v1.strategy.domain.Strategy;
import mx.edu.itoaxaca.api.v1.strategy.domain.StrategyRepository;

public class StrategyCreate {
    public static Strategy run(StrategyRepository repo, Strategy arg) {
        return repo.save(arg);
    }
}
