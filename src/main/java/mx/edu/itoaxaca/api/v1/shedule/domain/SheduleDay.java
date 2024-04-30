package mx.edu.itoaxaca.api.v1.shedule.domain;

import mx.edu.itoaxaca.api.v1.shared.domain.ValueObject.IntegerValueObject;

public class SheduleDay extends IntegerValueObject {

    public SheduleDay(Integer value) {
        super(value);
    }

    @Override
    public boolean isValid(Integer value) {
        return value >= 0 && value < 7;
    }
}
