package mx.edu.itoaxaca.api.v1.activity.domain;

import jakarta.persistence.AttributeConverter;

public class ActivityNameConverter 
    implements AttributeConverter<ActivityName, String> {

    @Override
    public String convertToDatabaseColumn(ActivityName attribute) {
        return (attribute == null) ? null : attribute.getValue();
    }

    @Override
    public ActivityName convertToEntityAttribute(String dbData) {
        return (dbData == null) ? null : new ActivityName(dbData);
    }
}
