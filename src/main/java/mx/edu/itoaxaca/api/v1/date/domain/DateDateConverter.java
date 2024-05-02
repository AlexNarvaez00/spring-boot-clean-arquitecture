package mx.edu.itoaxaca.api.v1.date.domain;

import jakarta.persistence.AttributeConverter;
import java.time.LocalDateTime;

public class DateDateConverter implements AttributeConverter<DateDate, LocalDateTime> {

    @Override
    public LocalDateTime convertToDatabaseColumn(DateDate attribute) {
        return (attribute == null) ? null : attribute.getValue();
    }

    @Override
    public DateDate convertToEntityAttribute(LocalDateTime dbData) {
        return (dbData == null) ? null : new DateDate(dbData);
    }
}
