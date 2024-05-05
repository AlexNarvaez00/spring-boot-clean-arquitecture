package mx.edu.itoaxaca.api.v1.period.domain;

import java.time.LocalDate;

import jakarta.persistence.AttributeConverter;

public class PeriodEndDateConverter 
    implements AttributeConverter<PeriodEndDate, LocalDate> {

    @Override
    public LocalDate convertToDatabaseColumn(PeriodEndDate attribute) {
        return (attribute == null) ? null : attribute.getValue();
    }

    @Override
    public PeriodEndDate convertToEntityAttribute(LocalDate dbData) {
        return (dbData == null) ? null : new PeriodEndDate(dbData);
    }
}
