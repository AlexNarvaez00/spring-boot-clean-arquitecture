package mx.edu.itoaxaca.api.v1.syllabus.domain;

import jakarta.persistence.AttributeConverter;
import java.time.LocalDate;

public class SyllabusEndDateCoverter implements AttributeConverter<SyllabusEndDate, LocalDate> {

    @Override
    public LocalDate convertToDatabaseColumn(SyllabusEndDate arg0) {
        return (arg0 == null) ? null : arg0.getValue();
    }

    @Override
    public SyllabusEndDate convertToEntityAttribute(LocalDate arg0) {
        return (arg0 == null) ? null : new SyllabusEndDate(arg0);
    }
}
