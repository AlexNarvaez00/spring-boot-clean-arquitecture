package mx.edu.itoaxaca.api.v1.profile.domain;

import java.time.LocalDateTime;

import jakarta.persistence.AttributeConverter;

public class ProfileLastSessionConverter 
    implements AttributeConverter<ProfileLastSession, LocalDateTime> {

    @Override
    public LocalDateTime convertToDatabaseColumn(ProfileLastSession attribute) {
        return (attribute == null) ? null : attribute.getValue();
    }

    @Override
    public ProfileLastSession convertToEntityAttribute(LocalDateTime dbData) {
        return (dbData == null) ? null : new ProfileLastSession(dbData);
    }
}
