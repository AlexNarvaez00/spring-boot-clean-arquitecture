package mx.edu.itoaxaca.api.v1.date.domain;

import jakarta.persistence.AttributeConverter;

public class DateLinkConverter 
    implements AttributeConverter<DateLink, String> {

    @Override
    public String convertToDatabaseColumn(DateLink attribute) {
        return (attribute == null) ? null : attribute.getValue();
    }

    @Override
    public DateLink convertToEntityAttribute(String dbData) {
        return (dbData == null) ? null : new DateLink(dbData);
    }
}
