package mx.edu.itoaxaca.api.v1.shedule.domain;

import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class SheduleUpdateRequest {

    @Positive
    private Integer start_hour;

    @Positive
    private Integer end_hour;

    private Integer day;

    public Shedule asShedule() {
        return new Shedule(
            null,
            new SheduleStartHour(start_hour),
            new SheduleEndHour(end_hour),
            new SheduleDay(day)
        );
    }
}
