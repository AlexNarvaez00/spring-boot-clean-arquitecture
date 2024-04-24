package mx.edu.itoaxaca.api.v1.workshop.domain;

import jakarta.persistence.AttributeConverter;

public class WorkshopSpeakerConverter implements AttributeConverter<WorkshopSpeaker, String> {

    @Override
    public String convertToDatabaseColumn(WorkshopSpeaker attribute) {
        return attribute == null ? null : attribute.getValue();
    }

    @Override
    public WorkshopSpeaker convertToEntityAttribute(String dbData) {
        return dbData == null ? null : new WorkshopSpeaker(dbData);
    }
}
