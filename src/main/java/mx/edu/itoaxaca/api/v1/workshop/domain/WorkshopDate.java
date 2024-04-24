package mx.edu.itoaxaca.api.v1.workshop.domain;

import java.time.LocalDate;

import mx.edu.itoaxaca.api.v1.shared.domain.ValueObject.DateValueObject;

public class WorkshopDate extends DateValueObject{

    public WorkshopDate(LocalDate value) {
        super(value);
    }

}
