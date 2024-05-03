package mx.edu.itoaxaca.api.v1.activity_institutional_mentoring_program.domain;

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
@Table(name = "activity_institutional_mentoring_programs")
@NoArgsConstructor
public class ActivityInstitutionalMentoringProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false)
    @Convert(converter = ActivityInstitutionalMentoringProgramNameConverter.class)
    private ActivityInstitutionalMentoringProgramName name;

    public ActivityInstitutionalMentoringProgram(
        UUID id,
        ActivityInstitutionalMentoringProgramName name
    ) {
        this.id = id;
        this.name = name;
    }
}
