package mx.edu.itoaxaca.api.v1.follow_up.domain;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.Setter;

@Setter
public class FollowUpUpdateRequest {

    @NotNull
    private String comment;

    @NotNull
    private Boolean confirm;

    @NotNull
    private LocalDate callOn;

    public FollowUp asFollowUp() {
        return new FollowUp(
            null,
            new FollowUpComment(this.comment),
            new FollowUpConfirm(this.confirm),
            new FollowUpCallOn(this.callOn)
        );
    }
}
