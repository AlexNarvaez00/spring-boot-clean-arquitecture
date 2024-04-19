package mx.edu.itoaxaca.api.v1.comments_evaluation_group.infrastructure.persistence;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.comments_evaluation_group.domain.CommentEvaluationGroup;
import mx.edu.itoaxaca.api.v1.comments_evaluation_group.domain.CommentEvaluationGroupRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresCommentEvaluationGroupRepository
    extends JpaRepository<CommentEvaluationGroup, UUID>, CommentEvaluationGroupRepository {}
