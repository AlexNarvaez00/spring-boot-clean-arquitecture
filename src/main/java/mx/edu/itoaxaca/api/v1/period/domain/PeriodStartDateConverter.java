package mx.edu.itoaxaca.api.v1.period.domain;

import java.time.LocalDate;

import jakarta.persistence.AttributeConverter;

public class PeriodStartDateConverter 
    implements AttributeConverter<PeriodStartDate, LocalDate> {

    @Override
    public LocalDate convertToDatabaseColumn(PeriodStartDate attribute) {
        return (attribute == null) ? null : attribute.getValue();
    }

    @Override
    public PeriodStartDate convertToEntityAttribute(LocalDate dbData) {
        return (dbData == null) ? null : new PeriodStartDate(dbData);
    }
}
