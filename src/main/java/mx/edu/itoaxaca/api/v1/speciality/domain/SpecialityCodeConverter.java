package mx.edu.itoaxaca.api.v1.speciality.domain;

import jakarta.persistence.AttributeConverter;

public class SpecialityCodeConverter 
    implements AttributeConverter<SpecialityCode, String> {

    @Override
    public String convertToDatabaseColumn(SpecialityCode attribute) {
        return (attribute == null) ? null : attribute.getValue();
    }

    @Override
    public SpecialityCode convertToEntityAttribute(String dbData) {
        return (dbData == null) ? null : new SpecialityCode(dbData);
    }
}
