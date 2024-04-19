package mx.edu.itoaxaca.api.v1.comments_evaluation_group.domain;

import java.time.LocalDate;

import mx.edu.itoaxaca.api.v1.shared.domain.ValueObject.DateValueObject;

public class CommentEvaluationGroupCreatedAt extends DateValueObject{

    public CommentEvaluationGroupCreatedAt(LocalDate value) {
        super(value);
    }

}
