package mx.edu.itoaxaca.api.v1.groups.domain;

import jakarta.persistence.AttributeConverter;
import java.time.LocalDate;

public class GroupCreatedAtConverter implements AttributeConverter<GroupCreatedAt, LocalDate> {

    @Override
    public LocalDate convertToDatabaseColumn(GroupCreatedAt attribute) {
        return (attribute == null) ? null : attribute.getValue();
    }

    @Override
    public GroupCreatedAt convertToEntityAttribute(LocalDate dbData) {
        return (dbData == null) ? null : new GroupCreatedAt(dbData);
    }
}
