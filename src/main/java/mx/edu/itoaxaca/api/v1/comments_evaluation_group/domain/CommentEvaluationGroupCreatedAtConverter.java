package mx.edu.itoaxaca.api.v1.comments_evaluation_group.domain;

import jakarta.persistence.AttributeConverter;
import java.time.LocalDate;

public class CommentEvaluationGroupCreatedAtConverter
    implements AttributeConverter<CommentEvaluationGroupCreatedAt, LocalDate> {

    @Override
    public LocalDate convertToDatabaseColumn(CommentEvaluationGroupCreatedAt attribute) {
        return attribute == null ? null : attribute.getValue();
    }

    @Override
    public CommentEvaluationGroupCreatedAt convertToEntityAttribute(LocalDate dbData) {
        return dbData == null ? null : new CommentEvaluationGroupCreatedAt(dbData);
    }
}
