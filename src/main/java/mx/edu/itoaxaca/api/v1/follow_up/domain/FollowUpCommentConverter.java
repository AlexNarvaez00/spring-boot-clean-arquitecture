package mx.edu.itoaxaca.api.v1.follow_up.domain;

import jakarta.persistence.AttributeConverter;

public class FollowUpCommentConverter 
    implements AttributeConverter<FollowUpComment, String> {

    @Override
    public String convertToDatabaseColumn(FollowUpComment attribute) {
        return (attribute == null) ? null : attribute.getValue();
    }

    @Override
    public FollowUpComment convertToEntityAttribute(String dbData) {
        return (dbData == null) ? null : new FollowUpComment(dbData);
    }
}
