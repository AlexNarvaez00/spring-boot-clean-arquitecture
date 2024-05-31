package mx.edu.itoaxaca.api.v1.comments_evaluation_group.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;
import lombok.Setter;
import mx.edu.itoaxaca.api.v1.groups.domain.Group;

@Setter
public class CommentEvaluationGroupStoreRequest {

    private UUID id;

    @NotBlank
    private String comment;

    @NotNull
    private UUID group_id;

    public CommentEvaluationGroup asCommentEvaluationGroup() {
        return new CommentEvaluationGroup(
            (this.id == null) ? null : UUID.randomUUID(),
            new CommentEvaluationGroupComment(this.comment),
            new Group(this.group_id, null, null, null)
        );
    }
}
