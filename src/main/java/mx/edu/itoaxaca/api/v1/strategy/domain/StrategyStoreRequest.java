package mx.edu.itoaxaca.api.v1.strategy.domain;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StrategyStoreRequest {
    private UUID id;

    @NotNull
    private String name;

    public Strategy asStrategy() {
        return new Strategy(
            (this.id == null) ? null : UUID.randomUUID(),
            new StrategyName(this.name)
        );
    }
}
