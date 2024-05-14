package mx.edu.itoaxaca.api.v1.period.domain;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.shared.domain.ValueObject.DateValueObjectMother;

public class PeriodMother {

    public static Period random(Boolean current) {
        var dateRandomStart = DateValueObjectMother.random();
        var dateRandomEnd = DateValueObjectMother.random();

        return new Period(
            UUID.randomUUID(),
            new PeriodStartDate(dateRandomStart),
            new PeriodEndDate(dateRandomEnd),
            new PeriodCurrent(current)
        );
    }
}
