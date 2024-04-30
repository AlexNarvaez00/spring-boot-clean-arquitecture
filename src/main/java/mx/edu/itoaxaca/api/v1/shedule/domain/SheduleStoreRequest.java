package mx.edu.itoaxaca.api.v1.shedule.domain;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.UUID;
import lombok.Data;

@Data
public class SheduleStoreRequest {

    private UUID id;

    @Positive
    private Integer start_hour;

    @Positive
    private Integer end_hour;

    @PositiveOrZero
    private Integer day;

    public Shedule asShedule() {
        return new Shedule(
            (this.id == null) ? null : UUID.randomUUID(),
            new SheduleStartHour(start_hour),
            new SheduleEndHour(end_hour),
            new SheduleDay(day)
        );
    }
}
