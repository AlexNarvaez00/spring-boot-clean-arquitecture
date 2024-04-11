package mx.edu.itoaxaca.api.v1.departament.domain;

import mx.edu.itoaxaca.api.v1.shared.domain.ValueObject.StringValueObject;
import mx.edu.itoaxaca.api.v1.shared.domain.ValueObject.StringValueObjectConverter;

public class DepartamenteNameConvert extends StringValueObjectConverter {

    @Override
    public StringValueObject getInstance(String data) {
        return new DepartamentName(data);
    }
}
