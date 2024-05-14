package mx.edu.itoaxaca.api.v1.comment_evaluation.infrastructure.persistence;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.comment_evaluation.domain.CommentEvaluation;
import mx.edu.itoaxaca.api.v1.comment_evaluation.domain.CommentEvaluationRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresCommentEvaluationRepository 
    extends JpaRepository<CommentEvaluation, UUID>, CommentEvaluationRepository {}
