package mx.edu.itoaxaca.api.v1.period.domain;

import mx.edu.itoaxaca.api.v1.shared.domain.ValueObject.BooleanValueObject;

public class PeriodCurrent extends BooleanValueObject {

    public PeriodCurrent(Boolean value) {
        super(value);
    }

    @Override
    public boolean isValid(Boolean value) {
        return true;
    }
}
