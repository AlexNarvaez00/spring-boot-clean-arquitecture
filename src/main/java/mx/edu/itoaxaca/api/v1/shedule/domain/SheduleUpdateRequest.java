package mx.edu.itoaxaca.api.v1.shedule.domain;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import mx.edu.itoaxaca.api.v1.profile.domain.Profile;

@Data
public class SheduleUpdateRequest {

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
            null,
            new SheduleStartHour(start_hour),
            new SheduleEndHour(end_hour),
            new SheduleDay(day),
            new Profile(this.personal_id, null, null, null, null)
        );
    }
}
