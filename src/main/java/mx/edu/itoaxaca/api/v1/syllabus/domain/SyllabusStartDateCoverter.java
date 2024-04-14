package mx.edu.itoaxaca.api.v1.syllabus.domain;

import java.time.LocalDate;
import mx.edu.itoaxaca.api.v1.shared.domain.ValueObject.DateValueObject;
import mx.edu.itoaxaca.api.v1.shared.domain.ValueObject.DateValueObjectConverter;

public class SyllabusStartDateCoverter extends DateValueObjectConverter {

    @Override
    public DateValueObject getInstance(LocalDate data) {
        return new SyllabusStartDate(data);
    }
}
