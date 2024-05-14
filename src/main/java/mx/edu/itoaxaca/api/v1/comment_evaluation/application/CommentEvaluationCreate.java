package mx.edu.itoaxaca.api.v1.comment_evaluation.application;

import mx.edu.itoaxaca.api.v1.comment_evaluation.domain.CommentEvaluation;
import mx.edu.itoaxaca.api.v1.comment_evaluation.domain.CommentEvaluationRepository;

public class CommentEvaluationCreate {
    public static CommentEvaluation run(CommentEvaluationRepository repo, CommentEvaluation arg) {
        return repo.save(arg);
    }
}
