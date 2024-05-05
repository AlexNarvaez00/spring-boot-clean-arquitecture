package mx.edu.itoaxaca.api.v1.period.domain;

import java.time.LocalDate;

import mx.edu.itoaxaca.api.v1.shared.domain.ValueObject.DateValueObject;

public class PeriodStartDate extends DateValueObject {

    public PeriodStartDate(LocalDate value) {
        super(value);
    }
}
