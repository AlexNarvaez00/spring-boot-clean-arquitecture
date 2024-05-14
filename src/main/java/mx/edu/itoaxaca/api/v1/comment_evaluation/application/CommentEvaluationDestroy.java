package mx.edu.itoaxaca.api.v1.comment_evaluation.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.comment_evaluation.domain.CommentEvaluationRepository;

public class CommentEvaluationDestroy {
    public static void run(CommentEvaluationRepository repo, UUID id) {
        repo.deleteById(id);
    }
}
