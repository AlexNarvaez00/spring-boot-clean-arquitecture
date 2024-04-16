package mx.edu.itoaxaca.api.v1.groups.domain;

import jakarta.persistence.AttributeConverter;

public class GroupCodeConverter implements AttributeConverter<GroupCode, String> {

    @Override
    public String convertToDatabaseColumn(GroupCode attribute) {
        return (attribute == null) ? null : attribute.getValue();
    }

    @Override
    public GroupCode convertToEntityAttribute(String dbData) {
        return (dbData == null) ? null : new GroupCode(dbData);
    }
}
