package mx.edu.itoaxaca.api.v1.type_support_area.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.edu.itoaxaca.api.v1.support_area.domain.SupportArea;

@Data
@Entity
@Table(name = "type_support_areas")
@NoArgsConstructor
public class TypeSupportArea {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "type", nullable = false)
    @Convert(converter = TypeSupportAreaTypeConverter.class)
    private TypeSupportAreaType type;

    @OneToMany(mappedBy = "type_support_area")
    private List<SupportArea> support_areas;

    public TypeSupportArea(UUID id, TypeSupportAreaType type) {
        this.id = id;
        this.type = type;
    }
}
