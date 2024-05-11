package mx.edu.itoaxaca.api.v1.support_staff.domain;

import jakarta.persistence.AttributeConverter;

public class SupportStaffJobTitleConverter 
    implements AttributeConverter<SupportStaffJobTitle, String> {

    @Override
    public String convertToDatabaseColumn(SupportStaffJobTitle attribute) {
        return (attribute == null) ? null : attribute.getValue();
    }

    @Override
    public SupportStaffJobTitle convertToEntityAttribute(String dbData) {
        return (dbData == null) ? null : new SupportStaffJobTitle(dbData);
    }
}
