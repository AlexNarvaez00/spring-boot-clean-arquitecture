package mx.edu.itoaxaca.api.v1.follow_up.domain;

import mx.edu.itoaxaca.api.v1.shared.domain.ValueObject.BooleanValueObject;

public class FollowUpConfirm extends BooleanValueObject{
    public FollowUpConfirm(Boolean value) {
        super(value);
    }

    @Override
    public boolean isValid(Boolean value) {
        return true;
    }
}
