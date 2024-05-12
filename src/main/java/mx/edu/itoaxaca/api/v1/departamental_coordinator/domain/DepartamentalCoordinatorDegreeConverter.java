package mx.edu.itoaxaca.api.v1.departamental_coordinator.domain;

import jakarta.persistence.AttributeConverter;

public class DepartamentalCoordinatorDegreeConverter 
    implements AttributeConverter<DepartamentalCoordinatorDegree, String> {

    @Override
    public String convertToDatabaseColumn(DepartamentalCoordinatorDegree attribute) {
        return (attribute == null) ? null : attribute.getValue();
    }

    @Override
    public DepartamentalCoordinatorDegree convertToEntityAttribute(String dbData) {
        return (dbData == null) ? null : new DepartamentalCoordinatorDegree(dbData);
    }
}
