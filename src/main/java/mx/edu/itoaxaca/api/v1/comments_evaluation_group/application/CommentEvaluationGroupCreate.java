package mx.edu.itoaxaca.api.v1.comments_evaluation_group.application;

import mx.edu.itoaxaca.api.v1.comments_evaluation_group.domain.CommentEvaluationGroup;
import mx.edu.itoaxaca.api.v1.comments_evaluation_group.domain.CommentEvaluationGroupRepository;

public class CommentEvaluationGroupCreate {

    public static CommentEvaluationGroup run(
        CommentEvaluationGroupRepository repo,
        CommentEvaluationGroup comment
    ) {
        return repo.save(comment);
    }
}
