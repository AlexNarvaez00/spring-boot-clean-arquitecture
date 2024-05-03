package mx.edu.itoaxaca.api.v1.institutional_mentoring_program.domain;

import java.time.LocalDate;
import mx.edu.itoaxaca.api.v1.shared.domain.ValueObject.DateValueObject;

public class InstitutionalMentoringProgramFinalReport extends DateValueObject {

    public InstitutionalMentoringProgramFinalReport(LocalDate value) {
        super(value);
    }
}
