package mx.edu.itoaxaca.api.v1.profile.domain;

import java.time.LocalDateTime;

import jakarta.persistence.AttributeConverter;

public class ProfileCreatedAtConverter 
    implements AttributeConverter<ProfileCreatedAt, LocalDateTime> {

    @Override
    public LocalDateTime convertToDatabaseColumn(ProfileCreatedAt attribute) {
        return (attribute == null) ? null : attribute.getValue();
    }

    @Override
    public ProfileCreatedAt convertToEntityAttribute(LocalDateTime dbData) {
        return (dbData == null) ? null : new ProfileCreatedAt(dbData);
    }
}
