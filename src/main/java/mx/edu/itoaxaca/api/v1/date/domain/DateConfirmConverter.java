package mx.edu.itoaxaca.api.v1.date.domain;

import jakarta.persistence.AttributeConverter;

public class DateConfirmConverter implements AttributeConverter<DateConfirm, Boolean> {

    @Override
    public Boolean convertToDatabaseColumn(DateConfirm attribute) {
        return (attribute == null) ? null : attribute.getValue();
    }

    @Override
    public DateConfirm convertToEntityAttribute(Boolean dbData) {
        return (dbData == null) ? null : new DateConfirm(dbData);
    }
}
