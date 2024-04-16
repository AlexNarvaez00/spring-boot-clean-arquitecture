package mx.edu.itoaxaca.api.v1.groups.domain;

import jakarta.persistence.AttributeConverter;

public class GroupNameConverter implements AttributeConverter<GroupName, String> {

    @Override
    public String convertToDatabaseColumn(GroupName attribute) {
        return (attribute == null) ? null : attribute.getValue();
    }

    @Override
    public GroupName convertToEntityAttribute(String dbData) {
        return (dbData == null) ? null : new GroupName(dbData);
    }
}
