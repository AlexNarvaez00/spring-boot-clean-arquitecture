package mx.edu.itoaxaca.api.v1.comments_evaluation_group.application;

import mx.edu.itoaxaca.api.v1.comments_evaluation_group.domain.CommentEvaluationGroup;
import mx.edu.itoaxaca.api.v1.comments_evaluation_group.domain.CommentEvaluationGroupRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class CommentEvaluationGroupGetAll {

    public static Page<CommentEvaluationGroup> run(
        Pageable pageable,
        CommentEvaluationGroupRepository repo
    ) {
        return repo.findAll(pageable);
    }
}
