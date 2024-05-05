package mx.edu.itoaxaca.api.v1.follow_up.domain;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class FollowUpStoreRequest {
    private UUID id;

    @NotNull
    private String comment;
    
    @NotNull
    private Boolean confirm;
    
    @NotNull
    private LocalDate callOn;
    
    public FollowUp asFollowUp() {
        return new FollowUp(
            (this.id == null) ? null : UUID.randomUUID(),
            new FollowUpComment(this.comment),
            new FollowUpConfirm(this.confirm),
            new FollowUpCallOn(this.callOn)
        );
    }
}
