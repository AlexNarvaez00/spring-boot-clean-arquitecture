package mx.edu.itoaxaca.api.v1.career.domain;

import mx.edu.itoaxaca.api.v1.shared.domain.ValueObject.StringValueObject;
import mx.edu.itoaxaca.api.v1.shared.domain.ValueObject.StringValueObjectConverter;

public class CareerNameConverter extends StringValueObjectConverter {

    @Override
    public StringValueObject getInstance(String data) {
        return new CareerName(data);
    }
}
