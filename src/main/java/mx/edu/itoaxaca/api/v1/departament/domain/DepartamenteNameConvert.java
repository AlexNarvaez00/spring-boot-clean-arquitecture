package mx.edu.itoaxaca.api.v1.departament.domain;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class DepartamenteNameConvert implements AttributeConverter<DepartamentName, String> {

    @Override
    public String convertToDatabaseColumn(DepartamentName arg0) {
        return arg0 == null ? null : arg0.getValue().toString();
    }

    @Override
    public DepartamentName convertToEntityAttribute(String arg0) {
        return arg0 == null ? null : new DepartamentName(arg0);
    }
}
