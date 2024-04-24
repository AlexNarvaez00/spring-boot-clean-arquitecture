package mx.edu.itoaxaca.api.v1.workshop.domain;

import jakarta.persistence.AttributeConverter;
import java.time.LocalDate;

public class WorkshopDateConverter implements AttributeConverter<WorkshopDate, LocalDate> {

    @Override
    public LocalDate convertToDatabaseColumn(WorkshopDate attribute) {
        return attribute == null ? null : attribute.getValue();
    }

    @Override
    public WorkshopDate convertToEntityAttribute(LocalDate dbData) {
        return dbData == null ? null : new WorkshopDate(dbData);
    }
}
