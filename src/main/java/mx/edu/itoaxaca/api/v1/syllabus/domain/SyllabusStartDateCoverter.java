package mx.edu.itoaxaca.api.v1.syllabus.domain;

import jakarta.persistence.AttributeConverter;
import java.time.LocalDate;

public class SyllabusStartDateCoverter implements AttributeConverter<SyllabusStartDate, LocalDate> {

    @Override
    public LocalDate convertToDatabaseColumn(SyllabusStartDate arg0) {
        return (arg0 == null) ? null : arg0.getValue();
    }

    @Override
    public SyllabusStartDate convertToEntityAttribute(LocalDate arg0) {
        return (arg0 == null) ? null : new SyllabusStartDate(arg0);
    }
}
