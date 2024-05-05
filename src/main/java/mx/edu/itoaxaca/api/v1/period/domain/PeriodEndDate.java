package mx.edu.itoaxaca.api.v1.period.domain;

import java.time.LocalDate;

import mx.edu.itoaxaca.api.v1.shared.domain.ValueObject.DateValueObject;

public class PeriodEndDate extends DateValueObject {

    public PeriodEndDate(LocalDate value) {
        super(value);
    }
}
