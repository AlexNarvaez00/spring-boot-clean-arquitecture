package mx.edu.itoaxaca.api.v1.speciality.domain;

import java.time.LocalDate;

import jakarta.persistence.AttributeConverter;

public class SpecialityEndDateConverter 
    implements AttributeConverter<SpecialityEndDate, LocalDate> {

    @Override
    public LocalDate convertToDatabaseColumn(SpecialityEndDate attribute) {
        return (attribute == null) ? null : attribute.getValue();
    }

    @Override
    public SpecialityEndDate convertToEntityAttribute(LocalDate dbData) {
        return (dbData == null) ? null : new SpecialityEndDate(dbData);
    }
}
