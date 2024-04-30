package mx.edu.itoaxaca.api.v1.shedule.domain;

import jakarta.persistence.AttributeConverter;

public class SheduleStartHourConverter
    implements AttributeConverter<SheduleStartHour, Integer> {

    @Override
    public Integer convertToDatabaseColumn(SheduleStartHour attribute) {
        return (attribute == null) ? null : attribute.getValue();
    }

    @Override
    public SheduleStartHour convertToEntityAttribute(Integer dbData) {
        return (dbData == null) ? null : new SheduleStartHour(dbData);
    }
}
