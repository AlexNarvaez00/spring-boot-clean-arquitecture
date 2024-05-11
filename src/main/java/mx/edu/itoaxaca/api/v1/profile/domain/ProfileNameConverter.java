package mx.edu.itoaxaca.api.v1.profile.domain;

import jakarta.persistence.AttributeConverter;

public class ProfileNameConverter 
    implements AttributeConverter<ProfileName, String> {

    @Override
    public String convertToDatabaseColumn(ProfileName attribute) {
        return (attribute == null) ? null : attribute.getValue();
    }

    @Override
    public ProfileName convertToEntityAttribute(String dbData) {
        return (dbData == null) ? null : new ProfileName(dbData);
    }
}
