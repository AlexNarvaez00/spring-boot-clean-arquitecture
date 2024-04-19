package mx.edu.itoaxaca.api.v1.comments_evaluation_group.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.comments_evaluation_group.domain.CommentEvaluationGroupRepository;

public class CommentEvaluationGroupDelete {

    public static void run(CommentEvaluationGroupRepository repo, UUID id) {
        repo.deleteById(id);
    }
}
