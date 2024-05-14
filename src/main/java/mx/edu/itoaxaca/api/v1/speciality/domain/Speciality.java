package mx.edu.itoaxaca.api.v1.speciality.domain;

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
import mx.edu.itoaxaca.api.v1.shared.domain.WithTimestamps;

@Data
@Entity
@Table(name = "specialities")
@NoArgsConstructor
public class Speciality extends WithTimestamps{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "code", nullable = false)
    @Convert(converter = SpecialityCodeConverter.class)
    private SpecialityCode code;

    @Column(name = "start_date", nullable = false)
    @Convert(converter = SpecialityStartDateConverter.class)
    private SpecialityStartDate start_date;

    @Column(name = "end_date", nullable = false)
    @Convert(converter = SpecialityEndDateConverter.class)
    private SpecialityEndDate end_date;

    public Speciality(
        UUID id,
        SpecialityCode code,
        SpecialityStartDate start_date,
        SpecialityEndDate end_date
    ) {
        this.id = id;
        this.code = code;
        this.start_date = start_date;
        this.end_date = end_date;
    }
}
