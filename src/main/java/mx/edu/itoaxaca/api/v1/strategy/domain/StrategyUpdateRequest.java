package mx.edu.itoaxaca.api.v1.strategy.domain;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StrategyUpdateRequest {
    
    @NotNull
    private String name;

    public Strategy asStrategy() {
        return new Strategy(
            null,
            new StrategyName(this.name)
        );
    }
}
