package mx.edu.itoaxaca.api.v1.speciality.domain;

import java.time.LocalDate;

import mx.edu.itoaxaca.api.v1.shared.domain.ValueObject.DateValueObject;

public class SpecialityEndDate extends DateValueObject{

    public SpecialityEndDate(LocalDate value) {
        super(value);
    }

    
}
