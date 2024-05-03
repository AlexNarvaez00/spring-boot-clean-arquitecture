package mx.edu.itoaxaca.api.v1.institutional_mentoring_program.domain;

import java.time.LocalDate;

import jakarta.persistence.AttributeConverter;

public class InstitutionalMentoringProgramFinalReportConverter 
    implements AttributeConverter<InstitutionalMentoringProgramFinalReport, LocalDate> {

    @Override
    public LocalDate convertToDatabaseColumn(InstitutionalMentoringProgramFinalReport attribute) {
        return (attribute == null) ? null : attribute.getValue();
    }

    @Override
    public InstitutionalMentoringProgramFinalReport convertToEntityAttribute(LocalDate dbData) {
        return (dbData == null) ? null : new InstitutionalMentoringProgramFinalReport(dbData);
    }
}
