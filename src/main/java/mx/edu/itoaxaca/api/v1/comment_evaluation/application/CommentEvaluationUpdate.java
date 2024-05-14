package mx.edu.itoaxaca.api.v1.comment_evaluation.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.comment_evaluation.domain.CommentEvaluation;
import mx.edu.itoaxaca.api.v1.comment_evaluation.domain.CommentEvaluationRepository;

public class CommentEvaluationUpdate {
    public static CommentEvaluation run(
        CommentEvaluationRepository repo,
        UUID id,
        CommentEvaluation arg
    ) {
        arg.setId(id);
        return repo.save(arg);
    }
}
