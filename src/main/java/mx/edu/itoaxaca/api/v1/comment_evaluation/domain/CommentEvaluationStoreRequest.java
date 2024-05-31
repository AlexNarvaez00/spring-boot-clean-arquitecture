package mx.edu.itoaxaca.api.v1.comment_evaluation.domain;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.Setter;
import mx.edu.itoaxaca.api.v1.career.domain.Career;

@Setter
public class CommentEvaluationStoreRequest {
    private UUID id;

    @NotNull
    private String comment;
    
    @NotNull
    private UUID career_id;
    
    public CommentEvaluation asCommentEvaluation() {
        return new CommentEvaluation(
            (this.id == null) ? null : UUID.randomUUID(),
            new CommentEvaluationComment(this.comment),
            new Career(career_id, null, null)
        );
    }
}
