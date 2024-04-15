package mx.edu.itoaxaca.api.v1.syllabus.domain;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class SyllabusCodeConverter implements AttributeConverter<SyllabusCode, String> {

    @Override
    public String convertToDatabaseColumn(SyllabusCode arg0) {
        return arg0 == null ? null : arg0.getValue().toString();
    }

    @Override
    public SyllabusCode convertToEntityAttribute(String arg0) {
        return arg0 == null ? null : new SyllabusCode(arg0);
    }
}
