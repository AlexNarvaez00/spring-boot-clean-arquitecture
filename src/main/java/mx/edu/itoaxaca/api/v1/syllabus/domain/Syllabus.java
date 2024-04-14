package mx.edu.itoaxaca.api.v1.syllabus.domain;

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
@Table(name = "syllabus")
@Entity
@NoArgsConstructor
public class Syllabus {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "code", nullable = false)
    @Convert(converter = SyllabusCodeConverter.class)
    private SyllabusCode code;

    @Column(name = "startDate", nullable = false)
    @Convert(converter = SyllabusStartDateCoverter.class)
    private SyllabusStartDate startDate;

    @Column(name = "endDate", nullable = false)
    @Convert(converter = SyllabusEndDateCoverter.class)
    private SyllabusEndDate endDate;

    public Syllabus(
        UUID id,
        SyllabusCode syllabusCode,
        SyllabusStartDate syllabusStartDate,
        SyllabusEndDate syllabusEndDate
    ) {
        this.id = id;
        this.code = syllabusCode;
        this.startDate = syllabusStartDate;
        this.endDate = syllabusEndDate;
    }
}
