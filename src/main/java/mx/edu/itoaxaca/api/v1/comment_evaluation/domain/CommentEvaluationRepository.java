package mx.edu.itoaxaca.api.v1.comment_evaluation.domain;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentEvaluationRepository {
    CommentEvaluation save(CommentEvaluation arg);
    Page<CommentEvaluation> findAll(Pageable pageable);
    void deleteById(UUID id);
    CommentEvaluation findCommentEvaluationById(UUID id);
}
