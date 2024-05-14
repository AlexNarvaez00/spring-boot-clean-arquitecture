package mx.edu.itoaxaca.api.v1.comment_evaluation.domain;

import jakarta.persistence.AttributeConverter;

public class CommentEvaluationCommentConverter 
    implements AttributeConverter<CommentEvaluationComment, String> {

    @Override
    public String convertToDatabaseColumn(CommentEvaluationComment attribute) {
        return (attribute == null) ? null : attribute.getValue();
    }

    @Override
    public CommentEvaluationComment convertToEntityAttribute(String dbData) {
        return (dbData == null) ? null : new CommentEvaluationComment(dbData);
    }
}
