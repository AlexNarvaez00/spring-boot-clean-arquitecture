package mx.edu.itoaxaca.api.v1.syllabus.domain;

import java.time.LocalDate;

import mx.edu.itoaxaca.api.v1.shared.domain.ValueObject.DateValueObject;

public class SyllabusEndDate extends DateValueObject{

    public SyllabusEndDate(LocalDate value) {
        super(value);
    }
    
}
