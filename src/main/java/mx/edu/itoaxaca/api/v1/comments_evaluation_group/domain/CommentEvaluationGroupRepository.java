package mx.edu.itoaxaca.api.v1.comments_evaluation_group.domain;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentEvaluationGroupRepository {
    CommentEvaluationGroup save(CommentEvaluationGroup group);
    Page<CommentEvaluationGroup> findAll(Pageable pageable);
    void deleteById(UUID id);
    CommentEvaluationGroup findCommentEvaluationGroupById(UUID id);
}
