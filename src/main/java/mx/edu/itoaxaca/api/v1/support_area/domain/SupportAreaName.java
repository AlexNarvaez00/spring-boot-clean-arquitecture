package mx.edu.itoaxaca.api.v1.support_area.domain;

import mx.edu.itoaxaca.api.v1.shared.domain.ValueObject.StringValueObject;

public class SupportAreaName extends StringValueObject {

    public SupportAreaName(String value) {
        super(value);
    }

    @Override
    public boolean isValid(String value) {
        return value != null && value.length() >= 5;
    }
}
