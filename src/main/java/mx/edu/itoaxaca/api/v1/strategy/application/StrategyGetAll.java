package mx.edu.itoaxaca.api.v1.strategy.application;

import mx.edu.itoaxaca.api.v1.strategy.domain.Strategy;
import mx.edu.itoaxaca.api.v1.strategy.domain.StrategyRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class StrategyGetAll {
    public static Page<Strategy> run(Pageable pageable, StrategyRepository repo) {
        return repo.findAll(pageable);
    }
}
