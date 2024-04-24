package mx.edu.itoaxaca.api.v1.workshop.domain;

import jakarta.persistence.AttributeConverter;

public class WorkshopNameConverter implements AttributeConverter<WorkshopName, String> {

    @Override
    public String convertToDatabaseColumn(WorkshopName attribute) {
        return attribute == null ? null : attribute.getValue().toString();
    }

    @Override
    public WorkshopName convertToEntityAttribute(String dbData) {
        return dbData == null ? null : new WorkshopName(dbData);
    }
}
