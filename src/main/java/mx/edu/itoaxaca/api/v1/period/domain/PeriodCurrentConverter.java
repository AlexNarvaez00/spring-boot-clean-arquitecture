package mx.edu.itoaxaca.api.v1.period.domain;

import jakarta.persistence.AttributeConverter;

public class PeriodCurrentConverter 
    implements AttributeConverter<PeriodCurrent, Boolean> {

    @Override
    public Boolean convertToDatabaseColumn(PeriodCurrent attribute) {
        return (attribute == null) ? null : attribute.getValue();
    }

    @Override
    public PeriodCurrent convertToEntityAttribute(Boolean dbData) {
        return (dbData == null) ? null : new PeriodCurrent(dbData);
    }
}
