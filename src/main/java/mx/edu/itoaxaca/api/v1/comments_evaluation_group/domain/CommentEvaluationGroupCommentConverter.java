package mx.edu.itoaxaca.api.v1.comments_evaluation_group.domain;

import jakarta.persistence.AttributeConverter;

public class CommentEvaluationGroupCommentConverter
    implements AttributeConverter<CommentEvaluationGroupComment, String> {

    @Override
    public String convertToDatabaseColumn(CommentEvaluationGroupComment attribute) {
        return attribute == null ? null : attribute.getValue().toString();
    }

    @Override
    public CommentEvaluationGroupComment convertToEntityAttribute(String dbData) {
        return dbData == null ? null : new CommentEvaluationGroupComment(dbData);
    }
}
