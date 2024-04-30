package mx.edu.itoaxaca.api.v1.shedule.domain;

import jakarta.persistence.AttributeConverter;

public class SheduleEndHourConverter
    implements AttributeConverter<SheduleEndHour, Integer> {

    @Override
    public Integer convertToDatabaseColumn(SheduleEndHour attribute) {
        return (attribute == null) ? null : attribute.getValue();
    }

    @Override
    public SheduleEndHour convertToEntityAttribute(Integer dbData) {
        return (dbData == null) ? null : new SheduleEndHour(dbData);
    }
}
