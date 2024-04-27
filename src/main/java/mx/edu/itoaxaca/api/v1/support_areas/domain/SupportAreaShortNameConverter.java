package mx.edu.itoaxaca.api.v1.support_areas.domain;

import jakarta.persistence.AttributeConverter;

public class SupportAreaShortNameConverter
    implements AttributeConverter<SupportAreaShortName, String> {

    @Override
    public String convertToDatabaseColumn(SupportAreaShortName attribute) {
        return (attribute == null) ? null : attribute.getValue();
    }

    @Override
    public SupportAreaShortName convertToEntityAttribute(String dbData) {
        return (dbData == null) ? null : new SupportAreaShortName(dbData);
    }
}
