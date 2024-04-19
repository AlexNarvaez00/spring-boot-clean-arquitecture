package mx.edu.itoaxaca.api.v1.comments_evaluation_group.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.comments_evaluation_group.domain.CommentEvaluationGroup;
import mx.edu.itoaxaca.api.v1.comments_evaluation_group.domain.CommentEvaluationGroupRepository;

public class CommentEvaluationGroupUpdate {

    public static CommentEvaluationGroup run(
        CommentEvaluationGroupRepository repo,
        UUID id,
        CommentEvaluationGroup comment
    ) {
        comment.setId(id);
        return repo.save(comment);
    }
}
