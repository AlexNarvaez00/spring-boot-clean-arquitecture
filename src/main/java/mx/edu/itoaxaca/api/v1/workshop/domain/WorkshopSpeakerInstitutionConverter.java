package mx.edu.itoaxaca.api.v1.workshop.domain;

import jakarta.persistence.AttributeConverter;

public class WorkshopSpeakerInstitutionConverter
    implements AttributeConverter<WorkshopSpeakerInstitution, String> {

    @Override
    public String convertToDatabaseColumn(WorkshopSpeakerInstitution attribute) {
        return attribute == null ? null : attribute.getValue();
    }

    @Override
    public WorkshopSpeakerInstitution convertToEntityAttribute(String dbData) {
        return dbData == null ? null : new WorkshopSpeakerInstitution(dbData);
    }
}
