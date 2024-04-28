package mx.edu.itoaxaca.api.v1.type_support_area.domain;

import jakarta.persistence.AttributeConverter;

public class TypeSupportAreaTypeConverter 
    implements AttributeConverter<TypeSupportAreaType, String> {

    @Override
    public String convertToDatabaseColumn(TypeSupportAreaType attribute) {
        return (attribute == null) ? null : attribute.getValue();
    }

    @Override
    public TypeSupportAreaType convertToEntityAttribute(String dbData) {
        return (dbData == null) ? null : new TypeSupportAreaType(dbData);
    }
}
