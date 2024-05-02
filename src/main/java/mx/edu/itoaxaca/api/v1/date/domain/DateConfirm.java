package mx.edu.itoaxaca.api.v1.date.domain;

import mx.edu.itoaxaca.api.v1.shared.domain.ValueObject.BooleanValueObject;

public class DateConfirm extends BooleanValueObject{

    public DateConfirm(Boolean value) {
        super(value);
    }

    @Override
    public boolean isValid(Boolean value) {
        return true;
    }

}
