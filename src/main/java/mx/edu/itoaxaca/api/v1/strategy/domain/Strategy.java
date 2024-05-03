package mx.edu.itoaxaca.api.v1.strategy.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "strategies")
@NoArgsConstructor
public class Strategy {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false)
    @Convert(converter = StrategyNameConverter.class)
    private StrategyName name;

    public Strategy(UUID id, StrategyName name) {
        this.id = id;
        this.name = name;
    }
}
