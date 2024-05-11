package mx.edu.itoaxaca.api.v1.institutional_coordinator.domain;

import jakarta.persistence.AttributeConverter;

public class InstitutionalCoordinatorDegreeConverter 
    implements AttributeConverter<InstitutionalCoordinatorDegree, String> {

    @Override
    public String convertToDatabaseColumn(InstitutionalCoordinatorDegree attribute) {
        return (attribute == null) ? null : attribute.getValue();
    }

    @Override
    public InstitutionalCoordinatorDegree convertToEntityAttribute(String dbData) {
        return (dbData == null) ? null : new InstitutionalCoordinatorDegree(dbData);
    }
}
