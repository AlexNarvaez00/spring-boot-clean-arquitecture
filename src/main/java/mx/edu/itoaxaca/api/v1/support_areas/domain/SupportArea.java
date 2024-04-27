package mx.edu.itoaxaca.api.v1.support_areas.domain;

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
@Table(name = "support_areas")
@NoArgsConstructor
public class SupportArea {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false)
    @Convert(converter = SupportAreaNameConverter.class)
    private SupportAreaName name;

    @Column(name = "short_name", nullable = false)
    @Convert(converter = SupportAreaShortNameConverter.class)
    private SupportAreaShortName shortName;

    public SupportArea(UUID id, SupportAreaName name, SupportAreaShortName shortName) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
    }
}
