package mx.edu.itoaxaca.api.v1.profile.domain;

import jakarta.persistence.AttributeConverter;

public class ProfileEmailConverter 
    implements AttributeConverter<ProfileEmail, String> {

    @Override
    public String convertToDatabaseColumn(ProfileEmail attribute) {
        return (attribute == null) ? null : attribute.getValue();
    }

    @Override
    public ProfileEmail convertToEntityAttribute(String dbData) {
        return (dbData == null) ? null : new ProfileEmail(dbData);
    }
}
