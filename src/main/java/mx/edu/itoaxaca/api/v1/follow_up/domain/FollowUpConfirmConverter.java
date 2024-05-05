package mx.edu.itoaxaca.api.v1.follow_up.domain;

import jakarta.persistence.AttributeConverter;

public class FollowUpConfirmConverter 
    implements AttributeConverter<FollowUpConfirm, Boolean> {

    @Override
    public Boolean convertToDatabaseColumn(FollowUpConfirm attribute) {
        return (attribute == null) ? null : attribute.getValue();
    }

    @Override
    public FollowUpConfirm convertToEntityAttribute(Boolean dbData) {
        return (dbData == null) ? null : new FollowUpConfirm(dbData);
    }
}
