package mx.edu.itoaxaca.api.v1.period.domain;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;
import lombok.Data;

@Data
public class PeriodStoreRequest {

    private UUID id;

    @NotNull
    private LocalDate start_date;

    @NotNull
    private LocalDate end_date;

    @NotNull
    private Boolean current;

    public Period asPeriod() {
        return new Period(
            (this.id == null) ? null : UUID.randomUUID(),
            new PeriodStartDate(start_date),
            new PeriodEndDate(end_date),
            new PeriodCurrent(current)
        );
    }
}
