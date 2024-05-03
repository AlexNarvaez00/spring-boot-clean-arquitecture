package mx.edu.itoaxaca.api.v1.institutional_mentoring_program.domain;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class InstitutionalMentoringProgramUpdateRequest {
    
    @NotNull
    private LocalDate evaluation_date;
    
    @NotNull
    private LocalDate final_report;

    public InstitutionalMentoringProgram asInstitutionalMentoringProgram() {
        return new InstitutionalMentoringProgram(
            null,
            new InstitutionalMentoringProgramEvaluationDate(this.evaluation_date),
            new InstitutionalMentoringProgramFinalReport(this.evaluation_date)
        );
    }
}
