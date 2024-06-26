package mx.edu.itoaxaca.api.v1.period.domain;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import lombok.Setter;

@Setter
public class PeriodUpdateRequest {

    @NotNull
    private LocalDate start_date;

    @NotNull
    private LocalDate end_date;

    @NotNull
    private Boolean current;

    public Period asPeriod() {
        return new Period(
            null,
            new PeriodStartDate(start_date),
            new PeriodEndDate(end_date),
            new PeriodCurrent(current)
        );
    }
}
