package mx.edu.itoaxaca.api.v1.comment_evaluation.application;

import mx.edu.itoaxaca.api.v1.comment_evaluation.domain.CommentEvaluation;
import mx.edu.itoaxaca.api.v1.comment_evaluation.domain.CommentEvaluationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class CommentEvaluationGetAll {
    public static Page<CommentEvaluation> run(Pageable pageable, CommentEvaluationRepository repo) {
        return repo.findAll(pageable);
    }
}
