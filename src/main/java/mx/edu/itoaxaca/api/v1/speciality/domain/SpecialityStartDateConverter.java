package mx.edu.itoaxaca.api.v1.speciality.domain;

import java.time.LocalDate;

import jakarta.persistence.AttributeConverter;

public class SpecialityStartDateConverter 
    implements AttributeConverter<SpecialityStartDate, LocalDate> {

    @Override
    public LocalDate convertToDatabaseColumn(SpecialityStartDate attribute) {
        return (attribute == null) ? null : attribute.getValue();
    }

    @Override
    public SpecialityStartDate convertToEntityAttribute(LocalDate dbData) {
        return (dbData == null) ? null : new SpecialityStartDate(dbData);
    }
}
