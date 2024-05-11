package mx.edu.itoaxaca.api.v1.tutor.domain;

import jakarta.persistence.AttributeConverter;

public class TutorClassificationConverter 
    implements AttributeConverter<TutorClassification, String> {

    @Override
    public String convertToDatabaseColumn(TutorClassification attribute) {
        return (attribute == null) ? null : attribute.getValue();
    }

    @Override
    public TutorClassification convertToEntityAttribute(String dbData) {
        return (dbData == null) ? null : new TutorClassification(dbData);
    }
}
