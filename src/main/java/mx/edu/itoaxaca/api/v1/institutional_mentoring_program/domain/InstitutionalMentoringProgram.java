package mx.edu.itoaxaca.api.v1.institutional_mentoring_program.domain;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
import mx.edu.itoaxaca.api.v1.strategy.domain.Strategy;

@Data
@Entity
@Table(name = "institutional_mentoring_programs")
@NoArgsConstructor
public class InstitutionalMentoringProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "evaluation_date", nullable = false)
    @Convert(converter = InstitutionalMentoringProgramEvaluationDateConverter.class)
    private InstitutionalMentoringProgramEvaluationDate evaluationDate;

    @Column(name = "final_report", nullable = false)
    @Convert(converter = InstitutionalMentoringProgramFinalReportConverter.class)
    private InstitutionalMentoringProgramFinalReport finalReport;

    @OneToMany(mappedBy = "institutionalMentoringProgram")
    @JsonIgnore
    private List<Strategy> strategies;

    public InstitutionalMentoringProgram(
        UUID id,
        InstitutionalMentoringProgramEvaluationDate evaluationDate,
        InstitutionalMentoringProgramFinalReport finalReport
    ) {
        this.id = id;
        this.evaluationDate = evaluationDate;
        this.finalReport = finalReport;
    }
}
