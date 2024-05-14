package mx.edu.itoaxaca.api.v1.shared.domain;

import java.time.LocalDateTime;

import jakarta.persistence.AttributeConverter;

public class UpdatedAtConverter implements AttributeConverter<UpdatedAt, LocalDateTime>{

    @Override
    public LocalDateTime convertToDatabaseColumn(UpdatedAt attribute) {
        return (attribute == null) ? null : attribute.getValue();
    }

    @Override
    public UpdatedAt convertToEntityAttribute(LocalDateTime dbData) {
        return (dbData == null) ? null : new UpdatedAt(dbData); 
    }

}
