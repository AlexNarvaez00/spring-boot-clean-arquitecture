package mx.edu.itoaxaca.api.v1.support_area.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.edu.itoaxaca.api.v1.shared.domain.WithTimestamps;
import mx.edu.itoaxaca.api.v1.type_support_area.domain.TypeSupportArea;

@Data
@Entity
@Table(name = "support_areas")
@NoArgsConstructor
public class SupportArea extends WithTimestamps{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false)
    @Convert(converter = SupportAreaNameConverter.class)
    private SupportAreaName name;

    @Column(name = "short_name", nullable = false)
    @Convert(converter = SupportAreaShortNameConverter.class)
    private SupportAreaShortName shortName;

    @ManyToOne
    @JoinColumn(name = "type_support_area_id")
    @JsonIgnore
    private TypeSupportArea type_support_area;

    public SupportArea(UUID id, SupportAreaName name, SupportAreaShortName shortName) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
    }

    public SupportArea(UUID id, SupportAreaName name, SupportAreaShortName shortName,
            TypeSupportArea type_support_area) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
        this.type_support_area = type_support_area;
    }
}
