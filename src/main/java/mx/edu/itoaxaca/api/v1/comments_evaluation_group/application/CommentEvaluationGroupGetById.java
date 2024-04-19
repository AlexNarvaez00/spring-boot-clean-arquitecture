package mx.edu.itoaxaca.api.v1.comments_evaluation_group.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.comments_evaluation_group.domain.CommentEvaluationGroup;
import mx.edu.itoaxaca.api.v1.comments_evaluation_group.domain.CommentEvaluationGroupRepository;

public class CommentEvaluationGroupGetById {

    public static CommentEvaluationGroup run(CommentEvaluationGroupRepository repo, UUID id) {
        return repo.findCommentEvaluationGroupById(id);
    }
}
