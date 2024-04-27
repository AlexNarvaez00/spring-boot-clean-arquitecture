package mx.edu.itoaxaca.api.v1.support_areas.domain;

import jakarta.persistence.AttributeConverter;

public class SupportAreaNameConverter
    implements AttributeConverter<SupportAreaName, String> {

    @Override
    public String convertToDatabaseColumn(SupportAreaName attribute) {
        return (attribute == null) ? null : attribute.getValue();
    }

    @Override
    public SupportAreaName convertToEntityAttribute(String dbData) {
        return (dbData == null) ? null : new SupportAreaName(dbData);
    }
}
