package mx.edu.itoaxaca.api.v1.strategy.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.strategy.domain.StrategyRepository;

public class StrategyDestroy {
    public static void run(StrategyRepository repo, UUID id) {
        repo.deleteById(id);
    }
}
