package mx.edu.itoaxaca.api.v1.type_support_area.infrastructure.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import mx.edu.itoaxaca.api.v1.shared.domain.WithTimestamps;
import mx.edu.itoaxaca.api.v1.support_area.domain.SupportArea;

@Entity
@Table(name = "type_support_areas")
@NoArgsConstructor
@Getter
public class PostgresTypeSupportArea extends WithTimestamps{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "type", nullable = false)
    private String type;

    @OneToMany(mappedBy = "type_support_area")
    private List<SupportArea> support_areas;

    public PostgresTypeSupportArea(UUID id, String type) {
        this.id = id;
        this.type = type;
    }
}
