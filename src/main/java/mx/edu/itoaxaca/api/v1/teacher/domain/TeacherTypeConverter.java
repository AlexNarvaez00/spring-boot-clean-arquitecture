package mx.edu.itoaxaca.api.v1.teacher.domain;

import jakarta.persistence.AttributeConverter;

public class TeacherTypeConverter 
    implements AttributeConverter<TeacherType, String> {

    @Override
    public String convertToDatabaseColumn(TeacherType attribute) {
        return (attribute == null) ? null : attribute.getValue();
    }

    @Override
    public TeacherType convertToEntityAttribute(String dbData) {
        return (dbData == null) ? null : new TeacherType(dbData);
    }
}
