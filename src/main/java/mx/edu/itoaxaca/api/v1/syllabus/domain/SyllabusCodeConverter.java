package mx.edu.itoaxaca.api.v1.syllabus.domain;

import mx.edu.itoaxaca.api.v1.shared.domain.ValueObject.StringValueObject;
import mx.edu.itoaxaca.api.v1.shared.domain.ValueObject.StringValueObjectConverter;

public class SyllabusCodeConverter extends StringValueObjectConverter {

    @Override
    public StringValueObject getInstance(String data) {
        return new SyllabusCode(data);
    }
}
