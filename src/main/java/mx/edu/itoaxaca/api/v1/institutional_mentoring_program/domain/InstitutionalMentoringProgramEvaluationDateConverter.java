package mx.edu.itoaxaca.api.v1.institutional_mentoring_program.domain;

import java.time.LocalDate;

import jakarta.persistence.AttributeConverter;

public class InstitutionalMentoringProgramEvaluationDateConverter 
    implements AttributeConverter<InstitutionalMentoringProgramEvaluationDate, LocalDate> {

    @Override
    public LocalDate convertToDatabaseColumn(InstitutionalMentoringProgramEvaluationDate attribute) {
        return (attribute == null) ? null : attribute.getValue();
    }

    @Override
    public InstitutionalMentoringProgramEvaluationDate convertToEntityAttribute(LocalDate dbData) {
        return (dbData == null) ? null : new InstitutionalMentoringProgramEvaluationDate(dbData);
    }
}
