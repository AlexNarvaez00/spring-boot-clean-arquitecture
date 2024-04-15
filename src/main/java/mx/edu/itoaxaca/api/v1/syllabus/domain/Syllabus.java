package mx.edu.itoaxaca.api.v1.syllabus.domain;

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
import mx.edu.itoaxaca.api.v1.career.domain.Career;

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

    @ManyToOne
    @JoinColumn(name = "career_id")
    @JsonIgnore
    private Career career;

    public Syllabus(
        UUID id,
        SyllabusCode syllabusCode,
        SyllabusStartDate syllabusStartDate,
        SyllabusEndDate syllabusEndDate,
        Career career
    ) {
        this.id = id;
        this.code = syllabusCode;
        this.startDate = syllabusStartDate;
        this.endDate = syllabusEndDate;
        this.career = career;
    }
}
