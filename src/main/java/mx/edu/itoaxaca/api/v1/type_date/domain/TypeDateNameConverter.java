package mx.edu.itoaxaca.api.v1.type_date.domain;

import jakarta.persistence.AttributeConverter;

public class TypeDateNameConverter 
    implements AttributeConverter<TypeDateName, String> {

    @Override
    public String convertToDatabaseColumn(TypeDateName attribute) {
        return (attribute == null) ? null : attribute.getValue();
    }

    @Override
    public TypeDateName convertToEntityAttribute(String dbData) {
        return (dbData == null) ? null : new TypeDateName(dbData);
    }
}
