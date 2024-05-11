package mx.edu.itoaxaca.api.v1.student.domain;

import jakarta.persistence.AttributeConverter;

public class StudentControlNumberConverter 
    implements AttributeConverter<StudentControlNumber, String> {

    @Override
    public String convertToDatabaseColumn(StudentControlNumber attribute) {
        return (attribute == null) ? null : attribute.getValue();
    }

    @Override
    public StudentControlNumber convertToEntityAttribute(String dbData) {
        return (dbData == null) ? null : new StudentControlNumber(dbData);
    }
}
