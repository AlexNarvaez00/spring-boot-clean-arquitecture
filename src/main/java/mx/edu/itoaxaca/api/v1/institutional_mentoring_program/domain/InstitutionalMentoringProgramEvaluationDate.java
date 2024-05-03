package mx.edu.itoaxaca.api.v1.institutional_mentoring_program.domain;

import java.time.LocalDate;

import mx.edu.itoaxaca.api.v1.shared.domain.ValueObject.DateValueObject;

public class InstitutionalMentoringProgramEvaluationDate extends DateValueObject{
    public InstitutionalMentoringProgramEvaluationDate(LocalDate value) {
        super(value);
    }
}
