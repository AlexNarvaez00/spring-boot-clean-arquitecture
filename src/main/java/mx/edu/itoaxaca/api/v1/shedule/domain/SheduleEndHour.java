package mx.edu.itoaxaca.api.v1.shedule.domain;

import mx.edu.itoaxaca.api.v1.shared.domain.ValueObject.IntegerValueObject;

public class SheduleEndHour extends IntegerValueObject {

    public SheduleEndHour(Integer value) {
        super(value);
    }

    @Override
    public boolean isValid(Integer value) {
        return value > 7 && value < 12;
    }
}
