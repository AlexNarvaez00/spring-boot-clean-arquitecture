package mx.edu.itoaxaca.api.v1.channeling.domain;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import mx.edu.itoaxaca.api.v1.profile.domain.Profile;

@Data
public class ChannellingUpdateRequest {
    
    @NotNull
    private String comment;

    @NotNull
    private LocalDate date;

    @NotNull
    private UUID tutor_id;

    @NotNull
    private UUID student_id;

    @NotNull
    private UUID support_staff_id;

    public Channelling asChannelling() {
        return new Channelling(
            null,
            new ChannellingComment(this.comment),
            new ChannellingDate(this.date),
            new Profile(this.tutor_id, null, null, null, null),
            new Profile(this.student_id, null, null, null, null),
            new Profile(this.support_staff_id, null, null, null, null)
        );
    }
}
