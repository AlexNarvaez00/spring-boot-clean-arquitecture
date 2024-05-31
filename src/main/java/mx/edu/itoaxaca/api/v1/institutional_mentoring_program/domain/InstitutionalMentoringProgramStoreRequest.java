package mx.edu.itoaxaca.api.v1.institutional_mentoring_program.domain;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.Setter;

@Setter
public class InstitutionalMentoringProgramStoreRequest {
    private UUID id;

    @NotNull
    private LocalDate evaluation_date;
    
    @NotNull
    private LocalDate final_report;
    
    public InstitutionalMentoringProgram asInstitutionalMentoringProgram() {
        return new InstitutionalMentoringProgram(
            (this.id == null) ? null : UUID.randomUUID(),
            new InstitutionalMentoringProgramEvaluationDate(this.evaluation_date),
            new InstitutionalMentoringProgramFinalReport(this.evaluation_date)
        );
    }
}
