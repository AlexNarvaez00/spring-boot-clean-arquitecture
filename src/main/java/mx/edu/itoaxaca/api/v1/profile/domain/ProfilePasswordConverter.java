package mx.edu.itoaxaca.api.v1.profile.domain;

import jakarta.persistence.AttributeConverter;

public class ProfilePasswordConverter 
    implements AttributeConverter<ProfilePassword, String> {

    @Override
    public String convertToDatabaseColumn(ProfilePassword attribute) {
        return (attribute == null) ? null : attribute.getValue();
    }

    @Override
    public ProfilePassword convertToEntityAttribute(String dbData) {
        return (dbData == null) ? null : new ProfilePassword(dbData);
    }
}
