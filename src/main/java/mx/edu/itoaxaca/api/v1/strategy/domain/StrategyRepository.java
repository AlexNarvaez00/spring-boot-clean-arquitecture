package mx.edu.itoaxaca.api.v1.strategy.domain;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StrategyRepository {
    Strategy save(Strategy arg);
    Page<Strategy> findAll(Pageable pageable);
    void deleteById(UUID id);
    Strategy findStrategyById(UUID id);
}
