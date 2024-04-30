package mx.edu.itoaxaca.api.v1.shedule.domain;

import jakarta.persistence.AttributeConverter;

public class SheduleDayConverter implements AttributeConverter<SheduleDay, Integer> {

    @Override
    public Integer convertToDatabaseColumn(SheduleDay attribute) {
        return (attribute == null) ? null : attribute.getValue();
    }

    @Override
    public SheduleDay convertToEntityAttribute(Integer dbData) {
        return (dbData == null) ? null : new SheduleDay(dbData);
    }
}
