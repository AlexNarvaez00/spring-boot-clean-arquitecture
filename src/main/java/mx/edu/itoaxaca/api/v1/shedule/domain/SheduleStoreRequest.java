package mx.edu.itoaxaca.api.v1.shedule.domain;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import java.util.UUID;
import lombok.Setter;
import mx.edu.itoaxaca.api.v1.profile.domain.Profile;

@Setter
public class SheduleStoreRequest {

    private UUID id;

    @Positive
    private Integer start_hour;

    @Positive
    private Integer end_hour;

    @PositiveOrZero
    private Integer day;

    @NotNull
    private UUID personal_id;

    public Shedule asShedule() {
        return new Shedule(
            (this.id == null) ? null : UUID.randomUUID(),
            new SheduleStartHour(start_hour),
            new SheduleEndHour(end_hour),
            new SheduleDay(day),
            new Profile(this.personal_id, null, null, null, null)
        );
    }
}
