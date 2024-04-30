package mx.edu.itoaxaca.api.v1.speciality.domain;

import java.time.LocalDate;

import mx.edu.itoaxaca.api.v1.shared.domain.ValueObject.DateValueObject;

public class SpecialityStartDate extends DateValueObject{

    public SpecialityStartDate(LocalDate value) {
        super(value);
    }

    
}
