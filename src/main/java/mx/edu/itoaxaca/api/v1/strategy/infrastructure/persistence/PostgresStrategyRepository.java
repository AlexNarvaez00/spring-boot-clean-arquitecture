package mx.edu.itoaxaca.api.v1.strategy.infrastructure.persistence;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.strategy.domain.Strategy;
import mx.edu.itoaxaca.api.v1.strategy.domain.StrategyRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresStrategyRepository 
    extends JpaRepository<Strategy, UUID>, StrategyRepository {}
