package mx.edu.itoaxaca.api.v1.shared.domain;

import java.time.LocalDateTime;

import jakarta.persistence.AttributeConverter;

public class DeletedAtConverter implements AttributeConverter<CreatedAt, LocalDateTime>{

    @Override
    public LocalDateTime convertToDatabaseColumn(CreatedAt attribute) {
        return (attribute == null) ? null : attribute.getValue();
    }

    @Override
    public CreatedAt convertToEntityAttribute(LocalDateTime dbData) {
        return (dbData == null) ? null : new CreatedAt(dbData); 
    }

}
